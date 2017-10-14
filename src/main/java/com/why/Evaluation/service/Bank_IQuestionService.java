package com.why.Evaluation.service;

import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.vo.VO4QuestionAddParam;
import com.why.Evaluation.vo.VO4QuestionUpdateParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by Lhy on 2017/6/4 0004.
 */
public interface Bank_IQuestionService {
    Map<String,Object> queryAllQuestions(Integer pageNum);

    Map<String,Object>  queryQuestionsByKey(Map<String,Object> keymap);

    String insertQuestion(VO4QuestionAddParam vo4QuestionAddParam);

    List<Questions> excelQuestion(String filename, MultipartFile file,Integer subjcet);

    String checkExcel(String filename, MultipartFile file);

    String insertExcel(List<Questions> questions);

    String ExcuteInsertExcel(String filename, MultipartFile file,Integer subject);

    Integer deleteByids(Integer[] ids);

    Questions queryById(Integer Id);

    String UpdateQuestion(VO4QuestionUpdateParam vo4QuestionUpdateParam);

    String bank_addMoreQuestions(String str,Integer questions_catalog);

    String ExcuteInsertDoc(String filename, MultipartFile file,Integer subject);

    String ExcuteInsertTxt(String filename, MultipartFile file,Integer subject);
}
