package com.why.Evaluation.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.serviceImpl.Bank_QuestionService;
import com.why.Evaluation.utils.ExcelUtil;
import com.why.Evaluation.utils.WDWUtil;
import com.why.Evaluation.vo.*;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lhy on 2017/6/4 0004.
 */
@Controller
public class Bank_QuestionsController {

    @Resource
    private Bank_QuestionService bank_QuestionService;


    @RequestMapping("/query")
    public String query(Model model, Integer pageNum, VO4QuestionQueryParam vo4QuestionQueryParam, HttpSession session){
        System.out.println(vo4QuestionQueryParam.getKeyname()+":"+vo4QuestionQueryParam.getSubject()+":"+vo4QuestionQueryParam.getType()+":"+vo4QuestionQueryParam.getLevel()+":"+vo4QuestionQueryParam.getStartdate()+":"+vo4QuestionQueryParam.getEnddate());
        if(pageNum==null){
            pageNum = 1;
        }

        if(!"".equals(vo4QuestionQueryParam.getType())){

        if("1".equals(vo4QuestionQueryParam.getType())){
            vo4QuestionQueryParam.setType("单选题");

        }else  if("2".equals(vo4QuestionQueryParam.getType())){
            vo4QuestionQueryParam.setType("多选题");

        }
        else  if("3".equals(vo4QuestionQueryParam.getType())){
            vo4QuestionQueryParam.setType("判断题");

        }
        else  if("4".equals(vo4QuestionQueryParam.getType())){
            vo4QuestionQueryParam.setType("问答题");

        }
        else  if("5".equals(vo4QuestionQueryParam.getType())){
            vo4QuestionQueryParam.setType("填空题");

        }

        }
        if(!"".equals(vo4QuestionQueryParam.getLevel())){

            if("1".equals(vo4QuestionQueryParam.getLevel())){

                vo4QuestionQueryParam.setLevel("低级");

            }

           else if("2".equals(vo4QuestionQueryParam.getLevel())){

                vo4QuestionQueryParam.setLevel("中级");

            }
            else if("3".equals(vo4QuestionQueryParam.getLevel())){

                vo4QuestionQueryParam.setLevel("高级");

            }

        }



        Map<String,Object> keymap = new HashMap<String, Object>();

            keymap.put("keyname",vo4QuestionQueryParam.getKeyname());
            keymap.put("subject",vo4QuestionQueryParam.getSubject());
            keymap.put("type",vo4QuestionQueryParam.getType());
            keymap.put("level",vo4QuestionQueryParam.getLevel());
            keymap.put("startdate",vo4QuestionQueryParam.getStartdate());
            keymap.put("enddate",vo4QuestionQueryParam.getEnddate());
            keymap.put("pageNum",pageNum);
            session.setAttribute("questionKey",vo4QuestionQueryParam);

    	System.out.print("准备启动service");
    	Map<String,Object> pagemap = bank_QuestionService.queryQuestionsByKey(keymap);

        List<Bank_VO4QuestionQuery_Rtn> list = (List<Bank_VO4QuestionQuery_Rtn>) pagemap.get("list");
        PageInfo<Questions> pageInfo = (PageInfo<Questions>) pagemap.get("pageinfo");

        model.addAttribute("list",list);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo.getPages());
        return "bank_single.jsp";

    }
    @RequestMapping("/insertQuestion")
    public String insertQuestion(Model model, VO4QuestionAddParam vo4QuestionAddParam,Integer pageNum){
    if(pageNum==null){


        pageNum=1;
    }
        System.out.println(vo4QuestionAddParam.getQuestionTitle()+":"+vo4QuestionAddParam.getOptionA()+":"+vo4QuestionAddParam.getQuestionLevel());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime =sdf.format(new Date());
        System.out.print(createtime);

        vo4QuestionAddParam.setCreateTime(createtime);

        String flag = bank_QuestionService.insertQuestion(vo4QuestionAddParam);
        Map<String,Object> map = bank_QuestionService.queryAllQuestions(pageNum);
        List<Bank_VO4QuestionQuery_Rtn> list = (List<Bank_VO4QuestionQuery_Rtn>) map.get("list");

        model.addAttribute("list",list);
        return "redirect:testBank.jsp";



    }



    @RequestMapping("/queryAllQuestion")
    public String queryAllQuestion(Model model,Integer pageNum){

        if(pageNum==null){

            pageNum=1;


        }
        Map<String,Object> map = bank_QuestionService.queryAllQuestions(pageNum);
        List<Bank_VO4QuestionQuery_Rtn> list = (List<Bank_VO4QuestionQuery_Rtn>) map.get("list");
        PageInfo<Questions> pageInfo = (PageInfo<Questions>) map.get("pageInfo");
        System.out.println("集合大小"+list.size());
        model.addAttribute("list",list);
        model.addAttribute("pageInfo",pageInfo);
        return "bank_single.jsp";



    }
    @RequestMapping("/queryById")
    public String queryById(Model model,Integer Id){

        Questions question = bank_QuestionService.queryById(Id);

        model.addAttribute("question",question);
        return "bank_updateQuestion.jsp";



    }
    @RequestMapping("/exam_queryById")
    public String exam_queryById(Model model,@RequestParam(value = "paperId") Integer paperId,@RequestParam(value = "questionId") Integer questionId){

        Questions question = bank_QuestionService.queryById(questionId);

        model.addAttribute("question",question);
        model.addAttribute("paperId",paperId);
        return "exam_addExamPaper_updateQuestion.jsp";



    }

    @RequestMapping("/importQuestion")
    @ResponseBody
    public String importQuestion(Model model,Integer subject,@RequestParam(value="filename") MultipartFile file){
        System.out.print(file.getOriginalFilename()+":"+file.isEmpty());
        String flag="";
        String filename = file.getOriginalFilename();
        if(WDWUtil.isDoc2003(file.getOriginalFilename())||WDWUtil.isDoc2007(file.getOriginalFilename())){

            flag= bank_QuestionService.ExcuteInsertDoc(filename,file,subject);
            System.out.println(flag);
        }
        else if(WDWUtil.isExcel2003(file.getOriginalFilename())||WDWUtil.isExcel2007(file.getOriginalFilename())){

            flag = bank_QuestionService.ExcuteInsertExcel(filename,file,subject);
            System.out.println(flag);

        }
        else if(WDWUtil.isTxt(filename)){
            flag = bank_QuestionService.ExcuteInsertTxt(filename,file,subject);
            System.out.println(flag);

        }

        return flag;
    }
    @RequestMapping(value="/test", produces="text/html;charset=UTF-8")
    @ResponseBody
    public  String test(String subject,@RequestParam(value="filename") MultipartFile file){

        String filename = file.getOriginalFilename();
       String flag =  bank_QuestionService.checkExcel(filename,file);
        System.out.print("测试ajax "+flag);

        return flag;

    }

    @RequestMapping(value="/delete")

    public String deleteQuestion(Model model,@RequestParam(value = "checks[]") Integer[] checks,@RequestParam(value = "pageNum") Integer pageNum,HttpSession session){
        Integer count =0;

    if(checks.length>0) {
       count= bank_QuestionService.deleteByids(checks);
    }
        if(count==checks.length)
        {
VO4QuestionQueryParam vo4QuestionQueryParam = (VO4QuestionQueryParam) session.getAttribute("questionKey");
           return pageQuestion(model,pageNum,false,false,session);

        }
        return pageQuestion(model,pageNum,false,false,session);
    }

    @RequestMapping(value="/updateQuesion")
    public String updateQuestion(Model model, VO4QuestionUpdateParam vo4QuestionUpdateParam){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String createtime =sdf.format(new Date());
        System.out.println(createtime);
        vo4QuestionUpdateParam.setCreateTime(createtime);
        System.out.println(vo4QuestionUpdateParam.toString());
        String flag = bank_QuestionService.UpdateQuestion(vo4QuestionUpdateParam);
        System.out.println("修改状态："+flag);


        return "redirect:testBank.jsp";


    }

    @RequestMapping(value="/exam_updateQuesion")
    public String exam_updateQuesion(HttpServletRequest request, VO4QuestionUpdateParam vo4QuestionUpdateParam, Integer paperId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String createtime =sdf.format(new Date());
        System.out.println(createtime);
        vo4QuestionUpdateParam.setCreateTime(createtime);
        System.out.println(vo4QuestionUpdateParam.toString());
        String flag = bank_QuestionService.UpdateQuestion(vo4QuestionUpdateParam);
        System.out.println("修改状态："+flag);
        request.setAttribute("paper_id",paperId);
        return "exam_addExamPaper.jsp";


    }


    @RequestMapping(value="/pageQuestion")
    public String pageQuestion(Model model,Integer pageNum,Boolean hasNext,Boolean hasPre,HttpSession session){
        VO4QuestionQueryParam vo4QuestionQueryParam = (VO4QuestionQueryParam) session.getAttribute("questionKey");


        if(hasPre!=null&&hasPre==true){

            pageNum--;

        }
        if(hasNext!=null&&hasNext==true){

            pageNum++;

        }
        if(vo4QuestionQueryParam==null){
            return queryAllQuestion(model,pageNum);

        }
        else {
            return query(model, pageNum, vo4QuestionQueryParam, session);
        }

    }

    @RequestMapping("bank_addMoreQuestions") //增加多个试题
    public String bank_addMoreQuestions(Model model,String str,Integer questions_catalog){

        System.out.println("试题的目录:"+questions_catalog);

        String result = bank_QuestionService.bank_addMoreQuestions(str,questions_catalog);
        model.addAttribute("goodInformation",result);

        return "testBank.jsp";
    }
    @RequestMapping("/downloadExample")
    public ResponseEntity<byte[]> download(String type) throws IOException {
        String path="";
        if("txt".equals(type)){
            path="D:\\NewWorkSplace\\Evaluation\\src\\main\\webapp\\download\\test.txt";
        }
       else if("xls".equals(type)){
            path="D:\\NewWorkSplace\\Evaluation\\src\\main\\webapp\\download\\题目.xlsx";

        }
        else if("doc".equals(type)){
            path="D:\\NewWorkSplace\\Evaluation\\src\\main\\webapp\\download\\test2.doc";

        }
        File file=new File(path);

        String dfileName = new String(file.getName().getBytes("utf-8"), "utf-8");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    @RequestMapping("/export")
    public ResponseEntity<byte[]> download(Integer pageNum,HttpSession session){

        VO4QuestionQueryParam vo4QuestionQueryParam = (VO4QuestionQueryParam) session.getAttribute("questionKey");
        if(vo4QuestionQueryParam==null) {
            Map<String, Object> map = bank_QuestionService.queryAllQuestions(pageNum);
            List<Bank_VO4QuestionQuery_Rtn> list = (List<Bank_VO4QuestionQuery_Rtn>)map.get("list");
            List<VO4QuestionExport> exports = new ArrayList<VO4QuestionExport>();
            for (int i = 0; i < list.size(); i++) {
                VO4QuestionExport vo4QuestionExport = new VO4QuestionExport();
                vo4QuestionExport.setQuestionType(list.get(i).getQuestionType());
                vo4QuestionExport.setQuestionTitle(list.get(i).getQuestionTitle());
                vo4QuestionExport.setQuestionSocre(list.get(i).getQuestionSocre());
                vo4QuestionExport.setOptionA(list.get(i).getOptionA());
                vo4QuestionExport.setOptionB(list.get(i).getOptionB());
                vo4QuestionExport.setOptionC(list.get(i).getOptionC());
                vo4QuestionExport.setOptionD(list.get(i).getOptionD());
                vo4QuestionExport.setAnswerTrue(list.get(i).getAnswerTrue());
                vo4QuestionExport.setQuestionAnalysis(list.get(i).getQuestionAnalysis());
                vo4QuestionExport.setQuestionLevel(list.get(i).getQuestionLevel());
                exports.add(vo4QuestionExport);

            }

            //执行excel导出
            ExcelUtil excelutil = new ExcelUtil();
            File file = new File("D:"+File.separator+"ExportDownload");

            if (!file.exists()) file.mkdirs();
            File file1 = new File("D:"+File.separator+"ExportDownload"+File.separator+new Date().getTime()+".xls");

            if(!file1.exists()) {
                try {
                    file1.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                //输出流
                FileOutputStream fos =  new FileOutputStream(file1);
                excelutil.exportDataToExcel(exports, new String[]{"题目类型","题目","题目分数","选项A","选项B","选项C","选项D","正确答案","题目分析","题目难度"}, "Export", fos);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String filePath  = file1.getPath();
            File exportFile=new File(filePath);
            String dfileName = null;
            try {
                dfileName = new String(exportFile.getName().getBytes("utf-8"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", dfileName);
            try {
                return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(exportFile), headers, HttpStatus.CREATED);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
       else{
            Map<String,Object> keymap = new HashMap<String, Object>();

            keymap.put("keyname",vo4QuestionQueryParam.getKeyname());
            keymap.put("subject",vo4QuestionQueryParam.getSubject());
            keymap.put("type",vo4QuestionQueryParam.getType());
            keymap.put("level",vo4QuestionQueryParam.getLevel());
            keymap.put("startdate",vo4QuestionQueryParam.getStartdate());
            keymap.put("enddate",vo4QuestionQueryParam.getEnddate());
            keymap.put("pageNum",pageNum);
            Map<String, Object> map = bank_QuestionService.queryQuestionsByKey(keymap);
            List<Questions> list = (List<Questions>) map.get("list");
            List<VO4QuestionExport> exports = new ArrayList<VO4QuestionExport>();
            for (int i = 0; i < list.size(); i++) {
                VO4QuestionExport vo4QuestionExport = new VO4QuestionExport();
                vo4QuestionExport.setQuestionType(list.get(i).getQuestionType());
                vo4QuestionExport.setQuestionTitle(list.get(i).getQuestionTitle());
                vo4QuestionExport.setQuestionSocre(list.get(i).getQuestionSocre());
                vo4QuestionExport.setOptionA(list.get(i).getOptionA());
                vo4QuestionExport.setOptionB(list.get(i).getOptionB());
                vo4QuestionExport.setOptionC(list.get(i).getOptionC());
                vo4QuestionExport.setOptionD(list.get(i).getOptionD());
                vo4QuestionExport.setAnswerTrue(list.get(i).getAnswerTrue());
                vo4QuestionExport.setQuestionAnalysis(list.get(i).getQuestionAnalysis());
                vo4QuestionExport.setQuestionLevel(list.get(i).getQuestionLevel());
                exports.add(vo4QuestionExport);

            }

            //执行excel导出
            ExcelUtil excelutil = new ExcelUtil();
            File file = new File("D:"+File.separator+"ExportDownload");

            if (!file.exists()) file.mkdirs();
            File file1 = new File("D:"+File.separator+"ExportDownload"+File.separator+new Date().getTime()+".xls");
            if(!file1.exists())
                try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                //输出流
                FileOutputStream fos =  new FileOutputStream(file1);
                excelutil.exportDataToExcel(exports, new String[]{"题目类型","题目","题目分数","选项A","选项B","选项C","选项D","正确答案","题目分析","题目难度"}, "Export", fos);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String filePath  = file1.getPath();
            File exportFile=new File(filePath);
            String dfileName = null;
            try {
                dfileName = new String(exportFile.getName().getBytes("utf-8"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", dfileName);
            try {
                return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(exportFile), headers, HttpStatus.CREATED);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }


}
