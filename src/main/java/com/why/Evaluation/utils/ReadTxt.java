package com.why.Evaluation.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.Date;

/**
 * Created by Lhy on 2017/6/18 0018.
 */
public class ReadTxt {


    public String getTxtInfo(String fileName, MultipartFile Mfile){

        BufferedReader br = null;
        StringBuffer sb = null;
        CommonsMultipartFile cf = (CommonsMultipartFile) Mfile; //获取本地存储路径
        File file = new File("D:\\fileupload");
        File file1;
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!file.exists()) file.mkdirs();
          //初始化输入流
        InputStream is = null;
        file1 = new File("D:\\fileupload\\" + new Date().getTime() + ".txt");
        //将上传的文件写入新建的文件中
        try {
            cf.getFileItem().write(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //读取文件

        try {
            is = new FileInputStream(file1);
            br = new BufferedReader(new InputStreamReader(is,"GBK")); //这里可以控制编码
            sb = new StringBuffer();
            String line = null;
            while((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String data = new String(sb); //StringBuffer ==> String
        System.out.println("数据为==> " + data);


        return data;

    }


}
