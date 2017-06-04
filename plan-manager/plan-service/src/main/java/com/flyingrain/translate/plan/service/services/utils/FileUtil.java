package com.flyingrain.translate.plan.service.services.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * Created by wally on 5/11/17.
 */
public class FileUtil {


    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static boolean saveFile(String path,String context){
        if(StringUtils.isEmpty(path)){
            logger.error("file path is null!");
            return false;
        }

        File file = new File(path);
        if(!file.exists()){
            logger.info("file not exists! start create file :[{}]",path);
            try {
                if(!file.createNewFile()){
                    throw new RuntimeException("createFile failed! " + path);
                }
            } catch (IOException e) {
                logger.error("create file failed! [{}]",path);
                return false;
            }
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file));){
            writer.write(context);
        }catch (FileNotFoundException e){
            logger.error("file not exists! [{}]",file.getPath(),e);
            return false;
        } catch (IOException e) {
            logger.error("write file error!",e);
            return false;
        }
        return true;
    }


    public static String readFile(String path){
        if(StringUtils.isEmpty(path)){
            logger.error("filePath is null!");
            return "";
        }
        File file = new File(path);

        if(!file.exists()){
            logger.error("file not exist![{}]",path);
            return null;
        }
        String result="";
        try(BufferedReader reader = new BufferedReader(new FileReader(path));) {
            result = reader.lines().reduce("",(context,element) -> context + element);
        } catch (FileNotFoundException e) {
            logger.error("file not Found!",e);
        } catch (IOException e) {
            logger.error("read file error!",e);
        }
        return result;

    }
}
