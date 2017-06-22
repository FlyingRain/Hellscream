package com.flyingrain.translate.framework.lang.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件工具类
 * Created by wally on 5/11/17.
 */
public class FileUtil {


    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 缓存文件
     *
     * @param path
     * @param context
     * @return
     */
    public static boolean saveFile(String path, String fileName, String context) {
        if (StringUtils.isEmpty(path)) {
            logger.error("file path is null!");
            return false;
        }
        File dir = new File(path);
        if(!dir.exists()){
            if(dir.mkdirs()){
                logger.info("mkdir [{}]",path);
            }else{
                logger.error("mkdir failed![{}]",path);
            }
        }
        File file = Paths.get(path,fileName).toFile();
        if(file.exists()){
            logger.info("file has exit! start to delete it![{}]",fileName);
            if(file.delete()){
                logger.info("delete file success![{}]",fileName);
            }
            return false;
        }
        try {
            if (!file.createNewFile()) {
                logger.error("create file failed!");
                return false;
            }
        } catch (IOException e) {
            logger.error("create file failed! [{}]", path);
            logger.error("exception is ", e);
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file));) {
            writer.write(context);
        } catch (FileNotFoundException e) {
            logger.error("file not exists! [{}]", file.getPath());
            logger.error("exception is ", e);
            return false;
        } catch (IOException e) {
            logger.error("write file error!", e);
            return false;
        }
        return true;
    }


    /**
     * 判断文件是否存在
     *
     * @param filePath
     * @return
     */
    public static boolean isExit(String filePath) {
        Path path = Paths.get(filePath);
        return path.toFile().exists();
    }

    /**
     * 读取文件内容
     *
     * @param path
     * @return
     */
    public static String readFile(String path) {
        if (StringUtils.isEmpty(path)) {
            logger.error("filePath is null!");
            return "";
        }
        File file = new File(path);

        if (!file.exists()) {
            logger.error("file not exist![{}]", path);
            return null;
        }
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(path));) {
            result = reader.lines().reduce("", (context, element) -> context + element);
        } catch (FileNotFoundException e) {
            logger.error("file not Found!", e);
        } catch (IOException e) {
            logger.error("read file error!", e);
        }
        return result;

    }
}
