package com.flyingrain.translate.words.collection.service.collect.impl.filehandler;

import java.util.List;

/**
 * Created by wally on 4/11/17.
 */
public interface FileHandler {
    /**
     * 读取文件全部内容
     * @param path　文件路径
     * @return  文件内容
     */
    List<String> handleFile(String path);

    /**
     * 读取文件部分内容
     * @param path　文件路径
     * @param num　个数
     * @return  内容
     */
    List<String> handleFile(String path,int num);

    /**
     * 读取指定内容
     * @param path　文件路径
     * @param start　开始行数
     * @param num　读取个数
     * @return  内容
     */
    List<String> handleFile(String path,int start, int num);

    int getAllNum(String path);
}
