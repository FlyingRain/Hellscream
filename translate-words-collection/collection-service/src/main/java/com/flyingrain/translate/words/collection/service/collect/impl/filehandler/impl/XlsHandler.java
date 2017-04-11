package com.flyingrain.translate.words.collection.service.collect.impl.filehandler.impl;

import com.flyingrain.translate.words.collection.service.collect.impl.filehandler.FileHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wally on 4/11/17.
 */
public class XlsHandler implements FileHandler {
    private Logger logger = LoggerFactory.getLogger(XlsHandler.class);

    @Override
    public List<String> handleFile(String path) {
        return handleFile(path, 0);
    }

    @Override
    public List<String> handleFile(String path, int num) {
        return handleFile(path, 0, num);
    }

    @Override
    public List<String> handleFile(String path, int start, int num) {
        if (path.endsWith(".xlsx")) {
            return handleXlsx(path, start, num);
        } else if (path.endsWith(".xls")) {
            return handleXls(path, start, num);
        } else {
            logger.error("invalid file type :" + path);
        }
        return null;
    }

    private int getXlsxAllNum(String path) {
        try (InputStream is = new FileInputStream(path);
             XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);) {
            int i = xssfWorkbook.getNumberOfSheets();
            if(i<1){
                return 0;
            }
            Sheet sheet = xssfWorkbook.getSheetAt(0);
            return sheet.getLastRowNum();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getAllNum(String path) {
        if (path.endsWith(".xlsx")) {
            return getXlsxAllNum(path);
        } else if (path.endsWith(".xls")) {
            return getXlsAllNum(path);
        } else {
            logger.error("invalid file type :" + path);
        }
        return 0;
    }



    private int getXlsAllNum(String path){
        return 0;
    }
    /**
     * 　处理xlsx文件
     *
     * @param path  　文件路径
     * @param num   　总共抽取多少
     * @param start 　开始
     * @return
     */
    private List<String> handleXlsx(String path, int start, int num) {
        try (InputStream is = new FileInputStream(path);
             XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);) {
            List<List<String>> result = new ArrayList<>();
            xssfWorkbook.forEach(sheet -> {

                if (sheet != null) {
                    int first = start + 1;
                    if (first < 1) {
                        first = 1;
                    }
                    int end = sheet.getLastRowNum();
                    if (sheet.getLastRowNum() > num + first && num > 0) {
                        end = num + first;
                    }

                    for (int i = first; i < end; i++) {
                        Row row = sheet.getRow(i);
                        int minColIx = row.getFirstCellNum();
                        int maxColIx = row.getLastCellNum();
                        List<String> rowList = new ArrayList<>();
                        for (int colIx = minColIx; colIx < maxColIx; colIx++) {
                            Cell cell = row.getCell(colIx);
                            if (cell != null) {
                                rowList.add(cell.getStringCellValue());
                            }
                        }
                        result.add(rowList);
                    }
                }
            });
            List<String> words = new ArrayList<>();
            result.forEach(rows -> {
                words.add(words.get(0));
            });
            return words;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> handleXls(String path, int start, int num) {
        return null;
    }
}
