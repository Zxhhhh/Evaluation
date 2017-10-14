package com.why.Evaluation.utils;

import com.why.Evaluation.dto.Questions;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lhy on 2017/6/9 0009.
 */
public class CheckExcel {




        //总行数
        private int totalRows = 0;
        //总条数
        private int totalCells = 0;
        //错误信息接收器
        private String errorMsg;

        //构造方法
        public CheckExcel() {
        }

        //获取总行数
        public int getTotalRows() {
            return totalRows;
        }

        //获取总列数
        public int getTotalCells() {
            return totalCells;
        }

        //获取错误信息
        public String getErrorInfo() {
            return errorMsg;
        }

        /**
         * 验证EXCEL文件
         *
         * @param filePath
         * @return
         */
        public boolean validateExcel(String filePath) {
            if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))) {
                errorMsg = "文件名不是excel格式";
                return false;
            }
            return true;
        }

        /**
         * 读EXCEL文件，获取客户信息集合
         *
         * @param
         * @return
         */
        public String getExcelInfo(String fileName, MultipartFile Mfile) {
String flag ="";
            //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
            CommonsMultipartFile cf = (CommonsMultipartFile) Mfile; //获取本地存储路径
            File file = new File("D:\\fileuploadTemp");
            //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
            if (!file.exists()) file.mkdirs();
            //新建一个文件
            File file1 = new File("D:\\fileuploadTemp\\" + new Date().getTime() + ".xlsx");
            //将上传的文件写入新建的文件中
            try {
                cf.getFileItem().write(file1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //初始化客户信息的集合
            List<Questions> questionList = new ArrayList<Questions>();
            //初始化输入流
            InputStream is = null;
            try {
                //验证文件名是否合格
                if (!validateExcel(fileName)) {
                    return null;
                }
                //根据文件名判断文件是2003版本还是2007版本
                boolean isExcel2003 = true;
                if (WDWUtil.isExcel2007(fileName)) {
                    isExcel2003 = false;
                }
                //根据新建的文件实例化输入流
                is = new FileInputStream(file1);
                //根据excel里面的内容读取客户信息
                flag = getExcelInfo(is, isExcel2003);
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        is = null;
                        e.printStackTrace();
                    }
                }
            }
            return flag;
        }

        /**
         * 根据excel里面的内容读取信息
         *
         * @param is          输入流
         * @param isExcel2003 excel是2003还是2007版本
         * @return
         * @throws IOException
         */
        public String getExcelInfo(InputStream is, boolean isExcel2003) {
            String flag="";
            try {
                /** 根据版本选择创建Workbook的方式 */
                Workbook wb = null;
                //当excel是2003时
                if (isExcel2003) {
                    wb = new HSSFWorkbook(is);
                } else {//当excel是2007时
                    wb = new XSSFWorkbook(is);
                }
                //读取Excel里面客户的信息
                flag = readExcelValue(wb);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return flag;
        }

        /**
         * 读取Excel里面的信息
         *
         * @param wb
         * @return
         */
        private String readExcelValue(Workbook wb) {
            String flag="格式无误";
            System.out.println("开始执行读取！");
            //得到第一个shell
            Sheet sheet = wb.getSheetAt(0);

            //得到Excel的行数
            this.totalRows = sheet.getPhysicalNumberOfRows();

            //得到Excel的列数(前提是有行数)
            if (totalRows >= 1 && sheet.getRow(0) != null) {
                this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            }


            //循环Excel行数,从第二行开始。标题不入库
            for (int r = 0; r < totalRows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;


                //循环Excel的列
                for (int c = 0; c < this.totalCells; c++) {
                    Cell cell = row.getCell(c);
                    if (null != cell) {
                    if(r==0){
                        System.out.println("进入第一行判断");
                        if(c==0){
                            System.out.println(cell.getStringCellValue());
                            if(!"题目类型".equals(cell.getStringCellValue())||cell.getStringCellValue()==null){

                                return "Excel 第一行 第一列格式错误 应为题目类型";

                            }
                            continue;
                        }

                       else if(c==1){
                            System.out.println(cell.getStringCellValue());
                            if(!"题目".equals(cell.getStringCellValue())){
                                return "Excel 第一行格式不对 应为题目 ";

                            }
                            continue;
                        }
                        else if(c==2){
                            System.out.println(cell.getStringCellValue());
                            if(!"题目分数".equals(cell.getStringCellValue())){
                                return "Excel 第一行格式不对";

                            }
                            continue;
                        }
                        else if(c==3){
                            System.out.println(cell.getStringCellValue());
                            if(!"选项A".equals(cell.getStringCellValue())){
                                return "Excel 第一行格式不对";

                            }
                            continue;
                        }
                        else if(c==4){
                            System.out.println(cell.getStringCellValue());
                            if(!"选项B".equals(cell.getStringCellValue())){
                                return "Excel 第一行格式不对";

                            }
                            continue;
                        }
                        else if(c==5){
                            System.out.println(cell.getStringCellValue());
                            if(!"选项C".equals(cell.getStringCellValue())){
                                return "Excel 第一行格式不对";

                            }

                        }
                        else if(c==6){
                            System.out.println(cell.getStringCellValue());
                            if(!"选项D".equals(cell.getStringCellValue())){
                                return "Excel 第一行格式不对";

                            }
                            continue;
                        }
                        else if(c==7){
                            System.out.println(cell.getStringCellValue());
                            if(!"正确答案".equals(cell.getStringCellValue())){
                                return "Excel 第一行格式不对";

                            }
                            continue;
                        }
                        else if(c==8){
                            System.out.println(cell.getStringCellValue());
                            if(!"题目分析".equals(cell.getStringCellValue())){
                                return "Excel 第一行格式不对";

                            }
                            continue;
                        }
                        else if(c==9){
                            System.out.println(cell.getStringCellValue());
                            if(!"题目难度".equals(cell.getStringCellValue())){
                                return "Excel 第一行格式不对";

                            }

                        }
                    break;

                    }

                        if (c == 0) {
                            if(cell.getStringCellValue()==null||"".equals(cell.getStringCellValue())){

                                return "第"+(r+1)+"行，第"+(c+1)+"列 不能为空";
                            }


                        }  else if (c == 1) {
                            if(cell.getStringCellValue()==null||"".equals(cell.getStringCellValue())){

                                return "第"+(r+1)+"行，第"+(c+1)+"列 不能为空";
                            }

                        } else if (c == 2) {
                            if(cell.getNumericCellValue()<=0||cell.getNumericCellValue()>100){

                                return "第"+(r+1)+"行，第"+(c+1)+"列 格式错误";
                            }

                        } else if (c == 3) {
                            if(cell.getStringCellValue()==null||"".equals(cell.getStringCellValue())){

                                return "第"+(r+1)+"行，第"+(c+1)+"列 不能为空";
                            }

                        } else if (c == 4) {
                            if(cell.getStringCellValue()==null||"".equals(cell.getStringCellValue())){

                                return "第"+(r+1)+"行，第"+(c+1)+"列 不能为空";
                            }

                        }else if (c == 5) {
                            if(cell.getStringCellValue()==null||"".equals(cell.getStringCellValue())){

                                return "第"+(r+1)+"行，第"+(c+1)+"列 不能为空";
                            }

                        }else if (c == 6) {
                            if(cell.getStringCellValue()==null||"".equals(cell.getStringCellValue())){

                                return "第"+(r+1)+"行，第"+(c+1)+"列 不能为空";
                            }

                        }else if (c == 7) {
                            if(cell.getStringCellValue()==null||"".equals(cell.getStringCellValue())){

                                return "第"+(r+1)+"行，第"+(c+1)+"列 不能为空";
                            }

                        }else if (c == 8) {
                            if(cell.getStringCellValue()==null||"".equals(cell.getStringCellValue())){

                                return "第"+(r+1)+"行，第"+(c+1)+"列 不能为空";
                            }

                        }
                        else if (c == 9) {
                            if(cell.getStringCellValue()==null||"".equals(cell.getStringCellValue())){

                                return "第"+(r+1)+"行，第"+(c+1)+"列 不能为空";
                            }

                        }

                        }
                    }

                }
                //添加客户

            return flag;
            }

        }


