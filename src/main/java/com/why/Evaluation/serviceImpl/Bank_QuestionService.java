package com.why.Evaluation.serviceImpl;

import com.why.Evaluation.dao.Bank_CatalogueDao;
import com.why.Evaluation.daoImpl.Bank_QuestionDao;
import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.service.Bank_IQuestionService;
import com.why.Evaluation.utils.*;
import com.why.Evaluation.vo.Bank_VO4QuestionQuery_Rtn;
import com.why.Evaluation.vo.Exam_VO4QuestionAddParam;
import com.why.Evaluation.vo.VO4QuestionAddParam;
import com.why.Evaluation.vo.VO4QuestionUpdateParam;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lhy on 2017/6/4 0004.
 */
@Service
public class Bank_QuestionService implements Bank_IQuestionService {
    @Resource
    private Bank_QuestionDao bank_QuestionDao;
    @Resource
    private Bank_CatalogueDao bank_CatalogueDao;

        @Override
        public  Map<String,Object> queryAllQuestions(Integer pageNum) {

            Map<String, Object> map = bank_QuestionDao.queryAllQuestion(pageNum);
            List<Questions> list = (List<Questions>) map.get("list");
            List<Bank_VO4QuestionQuery_Rtn> volist = new ArrayList<Bank_VO4QuestionQuery_Rtn>();
            System.out.println(list.size());

            for(int i=0;i<list.size();i++){
                Bank_VO4QuestionQuery_Rtn queryRtn= new Bank_VO4QuestionQuery_Rtn();
                queryRtn.setQuestionId(list.get(i).getQuestionId());
                queryRtn.setQuestionType(list.get(i).getQuestionType());
                queryRtn.setQuestionTitle(list.get(i).getQuestionTitle());

                queryRtn.setAnswerTrue(list.get(i).getAnswerTrue());
                queryRtn.setQuestionLevel(list.get(i).getQuestionLevel());
                queryRtn.setQuestionSocre(list.get(i).getQuestionSocre());
                queryRtn.setSubject(bank_CatalogueDao.queryCatalogNameById(list.get(i).getCatalogId()));
                queryRtn.setCreateTime(list.get(i).getCreateTime());
                volist.add(queryRtn);

            }
            map.put("list",volist);
            return map;
        }
		@Override
		public Map<String, Object> queryQuestionsByKey(Map<String, Object> keymap) {
			// TODO Auto-generated method stub
            Map<String, Object> map = bank_QuestionDao.queryQuestionsByKey(keymap);
            List<Questions> list = (List<Questions>) map.get("list");
            List<Bank_VO4QuestionQuery_Rtn> volist = new ArrayList<Bank_VO4QuestionQuery_Rtn>();


            for(int i=0;i<list.size();i++){
                Bank_VO4QuestionQuery_Rtn queryRtn= new Bank_VO4QuestionQuery_Rtn();
                queryRtn.setQuestionId(list.get(i).getQuestionId());
                queryRtn.setQuestionType(list.get(i).getQuestionType());
                queryRtn.setQuestionTitle(list.get(i).getQuestionTitle());
                queryRtn.setAnswerTrue(list.get(i).getAnswerTrue());
                queryRtn.setQuestionLevel(list.get(i).getQuestionLevel());
                queryRtn.setQuestionSocre(list.get(i).getQuestionSocre());
                queryRtn.setSubject(bank_CatalogueDao.queryCatalogNameById(list.get(i).getCatalogId()));
                queryRtn.setCreateTime(list.get(i).getCreateTime());
                volist.add(queryRtn);



            }
            map.put("list",volist);
            return map;
		}

    @Override
    public String insertQuestion(VO4QuestionAddParam vo4QuestionAddParam) {
    Questions question = new Questions();
        question.setAnswerTrue(vo4QuestionAddParam.getAnswerTrue());
        question.setCategory(vo4QuestionAddParam.getCategory());
        question.setCreateTime(vo4QuestionAddParam.getCreateTime());
        question.setOptionA(vo4QuestionAddParam.getOptionA());
        question.setOptionB(vo4QuestionAddParam.getOptionB());
        question.setOptionC(vo4QuestionAddParam.getOptionC());
        question.setOptionD(vo4QuestionAddParam.getOptionD());
        question.setQuestionAnalysis(vo4QuestionAddParam.getQuestionAnalysis());
        question.setQuestionLevel(vo4QuestionAddParam.getQuestionLevel());
        question.setQuestionTitle(vo4QuestionAddParam.getQuestionTitle());
        if("1".equals(vo4QuestionAddParam.getQuestionType()))
        {
            question.setQuestionType("单选题");

        }
        else if("2".equals(vo4QuestionAddParam.getQuestionType())){
            question.setQuestionType("多选题");

        }else if("3".equals(vo4QuestionAddParam.getQuestionType())){
            question.setQuestionType("判断题");
        }
        else if("4".equals(vo4QuestionAddParam.getQuestionType())){
            question.setQuestionType("问答题");
        }
        else if("5".equals(vo4QuestionAddParam.getQuestionType())){
            question.setQuestionType("填空题");
        }

        if("1".equals(vo4QuestionAddParam.getQuestionLevel())){
            question.setQuestionLevel("低级");
        }else if("2".equals(vo4QuestionAddParam.getQuestionLevel())){
            question.setQuestionLevel("中级");

        }else if("3".equals(vo4QuestionAddParam.getQuestionLevel())){
            question.setQuestionLevel("高级");

        }

        question.setQuestionSocre(vo4QuestionAddParam.getQuestionSocre());

        return bank_QuestionDao.insertQuestion(question);

    }

    @Override
    public List<Questions> excelQuestion(String filename, MultipartFile file,Integer subject) {
        ReadExcel readExcel = new ReadExcel();



        return readExcel.getExcelInfo(filename,file,subject);
    }

    @Override
    public String checkExcel(String filename, MultipartFile file) {
        CheckExcel checkExcel = new CheckExcel();



        return checkExcel.getExcelInfo(filename,file);
    }

    @Override
    public String insertExcel(List<Questions> questions) {
       int count =0;
        for(int i=0;i<questions.size();i++){
            if("0".equals(bank_QuestionDao.insertQuestion(questions.get(i)))){
                count++;
            }

        }

        return "成功导入"+count+"题";
    }

    @Override
    public String ExcuteInsertExcel(String filename, MultipartFile file,Integer subject) {
        List<Questions> list =excelQuestion(filename,file,subject);
                return  insertExcel(list);
    }

    @Override
    public Integer deleteByids(Integer[] ids) {

        return bank_QuestionDao.deleteByIds(ids);
    }

    @Override
    public Questions queryById(Integer Id) {

        return bank_QuestionDao.queryById(Id);

    }

    @Override
    public String UpdateQuestion(VO4QuestionUpdateParam vo4QuestionUpdateParam) {
        Questions question = new Questions();
        question.setQuestionId(vo4QuestionUpdateParam.getQuestionId());
        question.setAnswerTrue(vo4QuestionUpdateParam.getAnswerTrue());
        question.setCatalogId(vo4QuestionUpdateParam.getCatalogId());
        question.setCreateTime(vo4QuestionUpdateParam.getCreateTime());
        question.setOptionA(vo4QuestionUpdateParam.getOptionA());
        question.setOptionB(vo4QuestionUpdateParam.getOptionB());
        question.setOptionC(vo4QuestionUpdateParam.getOptionC());
        question.setOptionD(vo4QuestionUpdateParam.getOptionD());
        question.setQuestionAnalysis(vo4QuestionUpdateParam.getQuestionAnalysis());
        question.setQuestionLevel(vo4QuestionUpdateParam.getQuestionLevel());
        question.setQuestionTitle(vo4QuestionUpdateParam.getQuestionTitle());
        if("1".equals(vo4QuestionUpdateParam.getQuestionType()))
        {
            question.setQuestionType("单选题");

        }
        else if("2".equals(vo4QuestionUpdateParam.getQuestionType())){
            question.setQuestionType("多选题");

        }else if("3".equals(vo4QuestionUpdateParam.getQuestionType())){
            question.setQuestionType("判断题");
        }else if("4".equals(vo4QuestionUpdateParam.getQuestionType())){
            question.setQuestionType("问答题");
        }else if("5".equals(vo4QuestionUpdateParam.getQuestionType())){
            question.setQuestionType("填空题");
        }


        if("1".equals(vo4QuestionUpdateParam.getQuestionLevel())){
            question.setQuestionLevel("低级");
        }else if("2".equals(vo4QuestionUpdateParam.getQuestionLevel())){
            question.setQuestionLevel("中级");

        }else if("3".equals(vo4QuestionUpdateParam.getQuestionLevel())){
            question.setQuestionLevel("高级");

        }

        question.setQuestionSocre(vo4QuestionUpdateParam.getQuestionSocre());

        return bank_QuestionDao.UpdateQuestion(question);
    }

    @Override
    public String bank_addMoreQuestions(String str, Integer questions_catalog) {
        boolean isAjax = false;

        Map parseQuestionStringsResult = new Exam_StringParseUtil().parseQuestionStr(str,isAjax,questions_catalog);


        List<Exam_VO4QuestionAddParam> exam_VO4QuestionAddParams = (ArrayList<Exam_VO4QuestionAddParam>)parseQuestionStringsResult.get("vo4QuestionAddParams");

        for(Exam_VO4QuestionAddParam exam_VO4QuestionAddParam:exam_VO4QuestionAddParams){
                String flag = voTransformAndInsert(exam_VO4QuestionAddParam);
            System.out.println(flag);
        }

        Integer pastQuestionCount = (Integer)parseQuestionStringsResult.get("pastQuestionCount");
        Integer notPastQuestionCount = (Integer)parseQuestionStringsResult.get("notPastQuestionCount");
        String notPastNumStr = (String)parseQuestionStringsResult.get("notPastNumStr");

        String result = "";
        if(notPastQuestionCount==0){
            result = "所有试题新增成功!";
        }else{
            result = "成功新增"+pastQuestionCount+"道试题,试题"+notPastNumStr+"格式错误,新增失败";
        }

        return result;


    }

    @Override
    public String ExcuteInsertDoc(String filename, MultipartFile file, Integer subject) {
        ReadDoc doc = new ReadDoc();
        String text = doc.getDocInfo(filename,file);
        Map parseQuestionStringsResult = new Exam_StringParseUtil().parseQuestionStr(text,false,subject);

        List<Exam_VO4QuestionAddParam> exam_VO4QuestionAddParams = (ArrayList<Exam_VO4QuestionAddParam>)parseQuestionStringsResult.get("vo4QuestionAddParams");

        for(Exam_VO4QuestionAddParam exam_VO4QuestionAddParam:exam_VO4QuestionAddParams){
            String flag = voTransformAndInsert(exam_VO4QuestionAddParam);
            System.out.println(flag);
        }

        Integer pastQuestionCount = (Integer)parseQuestionStringsResult.get("pastQuestionCount");
        Integer notPastQuestionCount = (Integer)parseQuestionStringsResult.get("notPastQuestionCount");
        String notPastNumStr = (String)parseQuestionStringsResult.get("notPastNumStr");

        String result = "";
        if(notPastQuestionCount==0){
            result = "所有试题新增成功!";
        }else{
            result = "成功新增"+pastQuestionCount+"道试题,试题"+notPastNumStr+"格式错误,新增失败";
        }

        return result;



    }

    @Override
    public String ExcuteInsertTxt(String filename, MultipartFile file, Integer subject) {
        ReadTxt txt = new ReadTxt();
        String text = txt.getTxtInfo(filename,file);
        Map parseQuestionStringsResult = new Exam_StringParseUtil().parseQuestionStr(text,false,subject);

        List<Exam_VO4QuestionAddParam> exam_VO4QuestionAddParams = (ArrayList<Exam_VO4QuestionAddParam>)parseQuestionStringsResult.get("vo4QuestionAddParams");

        for(Exam_VO4QuestionAddParam exam_VO4QuestionAddParam:exam_VO4QuestionAddParams){
            String flag = voTransformAndInsert(exam_VO4QuestionAddParam);
            System.out.println(flag);
        }

        Integer pastQuestionCount = (Integer)parseQuestionStringsResult.get("pastQuestionCount");
        Integer notPastQuestionCount = (Integer)parseQuestionStringsResult.get("notPastQuestionCount");
        String notPastNumStr = (String)parseQuestionStringsResult.get("notPastNumStr");

        String result = "";
        if(notPastQuestionCount==0){
            result = "所有试题新增成功!";
        }else{
            result = "成功新增"+pastQuestionCount+"道试题,试题"+notPastNumStr+"格式错误,新增失败";
        }

        return result;
    }

    public String voTransformAndInsert(Exam_VO4QuestionAddParam exam_vo4QuestionAddParam){
            Questions question = new Questions();

            question.setAnswerTrue(exam_vo4QuestionAddParam.getAnswerTrue());
            question.setCatalogId(exam_vo4QuestionAddParam.getCatalogId());
            question.setCreateTime(exam_vo4QuestionAddParam.getCreateTime());
            question.setOptionA(exam_vo4QuestionAddParam.getOptionA());
            question.setOptionB(exam_vo4QuestionAddParam.getOptionB());
            question.setOptionC(exam_vo4QuestionAddParam.getOptionC());
            question.setOptionD(exam_vo4QuestionAddParam.getOptionD());
            question.setQuestionAnalysis(exam_vo4QuestionAddParam.getQuestionAnalysis());
            question.setQuestionLevel(exam_vo4QuestionAddParam.getQuestionLevel());
            question.setQuestionTitle(exam_vo4QuestionAddParam.getQuestionTitle());
            question.setQuestionType(exam_vo4QuestionAddParam.getQuestionType());
            question.setQuestionSocre(exam_vo4QuestionAddParam.getQuestionSocre());

            return bank_QuestionDao.insertQuestion(question);


        }

}
