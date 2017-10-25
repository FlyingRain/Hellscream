package com.flyingrain.translate.plan.service.services.cach;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyingrain.translate.framework.lang.utils.FileUtil;
import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.api.response.TaskSummary;
import com.flyingrain.translate.plan.service.services.TaskCache;
import com.flyingrain.translate.plan.service.services.dao.model.DayPlan;
import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.googlecode.concurrentlinkedhashmap.Weighers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 任务缓存(文件)
 * Created by wally on 6/13/17.
 */
@Component
public class FileTaskCache implements TaskCache {

    private Logger logger = LoggerFactory.getLogger(FileTaskCache.class);

    @Value("${plan.savePath}")
    private String rootPath;

    private ConcurrentLinkedHashMap<Integer, String> filePathCache = new ConcurrentLinkedHashMap.Builder<Integer, String>().weigher(Weighers.singleton()).maximumWeightedCapacity(1000).build();

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 从缓存中查找文件
     *
     * @param dayPlan
     * @return
     */
    @Override
    public Task getTask(DayPlan dayPlan) {
        String filePath = filePathCache.get(dayPlan.getId());
        if (StringUtils.isEmpty(filePath)) {
            filePath = getFile(dayPlan);
        }
        if (FileUtil.isExit(filePath)) {
            String taskString = FileUtil.readFile(filePath);
            try {
                return objectMapper.readValue(taskString, Task.class);
            } catch (IOException e) {
                logger.error("deserialize task failed! content is :[{}]", taskString);
                logger.error("IOException ", e);
            }
        }
        logger.info("file not exits![{}]", filePath);
        return null;
    }

    /**
     * 添加任务到缓存中
     *
     * @param task
     * @param dayPlan
     */
    @Override
    public void cacheTask(Task task, DayPlan dayPlan) {
        String filePath = getFilePath(dayPlan);
        String path = filePathCache.putIfAbsent(dayPlan.getId(), getFile(dayPlan));
        String fileName = dayPlan.getUser_id() + ".txt";
        if (path != null) {
            logger.error("there has been a task int the cache [{}]", dayPlan);
            return;
        }
        String taskString = taskToString(task);
        FileUtil.saveFile(filePath, fileName, taskString);

        String taskSummaryString="";
        try {
            taskSummaryString = objectMapper.writeValueAsString(generateSummaryFromTask(task,dayPlan));
        } catch (JsonProcessingException e) {
            logger.error("transfer summary to string error!",e);
        }
        String summaryFileName = dayPlan.getUser_id()+"_summary.txt";
        FileUtil.saveFile(filePath,summaryFileName,taskSummaryString);

    }

    @Override
    public TaskSummary getTaskSummary(Date planDate, int userId) {
        return null;
    }

    private String taskToString(Task task) {
        if (task == null) {
            logger.error("task is null!");
            return "";
        }
        String result = "";
        try {
            result = objectMapper.writeValueAsString(task);
        } catch (JsonProcessingException e) {
            logger.error("transfer to json failed ![{}]", task);
            logger.error("exception is JsonProcessingException", e);
        }
        return result;
    }


    private String getFilePath(DayPlan dayPlan) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date taskDate = dayPlan.getPlan_date();
        Path path = Paths.get(rootPath, "plan", "task", format.format(taskDate));
        return path.toAbsolutePath().toString();

    }

    private String getFile(DayPlan dayPlan){
        String path = getFilePath(dayPlan);
        String fileName = dayPlan.getUser_id() + ".txt";
        Path path1 = Paths.get(path,fileName);
        return path1.toAbsolutePath().toString();
    }

    private TaskSummary generateSummaryFromTask(Task task,DayPlan dayPlan){
        logger.info("start to generate task Summary! task:[{}]",task);
        TaskSummary summary = new TaskSummary();
        summary.setUserId(dayPlan.getUser_id());
        summary.setPlanId(dayPlan.getPlan_id());
        summary.setNewWordsNumber(task.getNewWordNumber());
        summary.setOldWordsNumber(task.getWordNumber()-task.getNewWordNumber());
        summary.setTotal(task.getWordNumber());
        summary.setTaskDate(dayPlan.getPlan_date());
        return summary;
    }
}
