package com.why.Evaluation.utils;

import com.why.Evaluation.dto.Questions;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lhy on 2017/6/18 0018.
 */
public class ReadDoc {
    private String filepath="";



    String errorMsg;
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(WDWUtil.isDoc2003(filePath) || WDWUtil.isDoc2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }


    public String getDocInfo(String fileName, MultipartFile Mfile)  {
    String text="";
        //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
        CommonsMultipartFile cf = (CommonsMultipartFile) Mfile; //获取本地存储路径
        File file = new File("D:\\fileupload");
        File file1;
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!file.exists()) file.mkdirs();

        //初始化输入流
        InputStream is = null;
        //新建一个文件

        if(WDWUtil.isDoc2003(fileName)){
            System.out.println(WDWUtil.isDoc2003(fileName));
            file1 = new File("D:\\fileupload\\" + new Date().getTime() + ".doc");
            //将上传的文件写入新建的文件中
            try {
                cf.getFileItem().write(file1);
            } catch (Exception e) {
                e.printStackTrace();
            }



            try {
                is = new FileInputStream(file1);
                text = get2003DocInfo(is);
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {

            }
        }
      else{
            System.out.println(WDWUtil.isDoc2003(fileName));
             file1 = new File("D:\\fileupload\\" + new Date().getTime() + ".docx");
            //将上传的文件写入新建的文件中
            try {
                cf.getFileItem().write(file1);
            } catch (Exception e) {
                e.printStackTrace();
            }



            try {
                is = new FileInputStream(file1);
                text = get2007DocInfo(file1.getPath());
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {

            }

        }


        return text;
    }

    public String get2003DocInfo(InputStream is) {
        String doc2 = "";
        try {
            /** 根据版本选择创建Workbook的方式 */

            //当excel是2003时

                WordExtractor doc = new WordExtractor(is);

                 doc2 = doc.getText();

                System.out.println(doc2);




        } catch (IOException e) {
            e.printStackTrace();
        }
        return  doc2;
    }

    public String get2007DocInfo(String filepath) {
        String doc2 = "";
        try {
            /** 根据版本选择创建Workbook的方式 */

            //当excel是2003时

            XWPFWordExtractor docx = new XWPFWordExtractor(POIXMLDocument.openPackage(filepath));

            doc2 = docx.getText();

            System.out.println(doc2);




        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlException e) {
            e.printStackTrace();
        } catch (OpenXML4JException e) {
            e.printStackTrace();
        }
        return  doc2;
    }
}

