package com.why.Evaluation.daoImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.why.Evaluation.dao.Bank_IQuestionDao;
import com.why.Evaluation.dto.Questions;
import com.why.Evaluation.dto.QuestionsExample;
import com.why.Evaluation.dto.QuestionsExample.Criteria;
import com.why.Evaluation.mapperImpl.QuestionsMapper;
import com.why.Evaluation.vo.VO4QuestionUpdateParam;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lhy on 2017/6/4 0004.
 */
@Repository
public class Bank_QuestionDao implements Bank_IQuestionDao {
    @Resource
    private QuestionsMapper questionsMapper;
	@Resource
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public Map<String, Object> queryAllQuestion(Integer pageNum) {
		// TODO Auto-generated method stub
		Map<String,Object> map =new HashMap<String,Object>();
		PageHelper.startPage(pageNum, 10);

		 QuestionsExample questionsExample = new QuestionsExample();
	        questionsExample.createCriteria().andQuestionIdIsNotNull();
	        List<Questions> list = questionsMapper.selectByExample(questionsExample);
		PageInfo<Questions> pageInfo = new PageInfo<Questions>(list);

		map.put("list",list);
		map.put("pageInfo",pageInfo);
	        return map;
	}

	@Override
	public Map<String, Object> queryQuestionsByKey(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Map<String, Object> pagemap= new HashMap<String,Object>();
		String keyname,type,level,enddate,startdate;
		Integer pageNum;
		Integer subject;
		keyname = (String) map.get("keyname");
		pageNum= (Integer) map.get("pageNum");
		if(map.get("subject").equals("")){

			subject=0;
		}
		else {
			subject = Integer.parseInt((String) map.get("subject"));
	}
	type = (String) map.get("type");
		level = (String) map.get("level");
		enddate = (String) map.get("enddate");
		startdate = (String) map.get("startdate");
		 System.out.println(keyname+":"+subject+":"+type+":"+level+":"+startdate+":"+enddate);

		QuestionsExample questionsExample = new QuestionsExample();

		Criteria cri= questionsExample.createCriteria();
        List<Questions> list = new ArrayList<Questions>();
		if("".equals(keyname)&&"".equals(subject)&&"".equals(type)&&"".equals(level)&&"".equals(startdate)&&"".equals(enddate)){
			PageHelper.startPage(pageNum, 5);
	       cri.andQuestionIdIsNotNull();
			questionsExample.setOrderByClause("createTime desc");
	        list = questionsMapper.selectByExample(questionsExample);
			System.out.print("分页集合大小："+list.size());
			PageInfo<Questions> pageInfo = new PageInfo<Questions>(list);
			pagemap.put("pageinfo",pageInfo);
			pagemap.put("list",list);
			return pagemap;
		
		}
		if(!"".equals(keyname)){
		cri.andQuestionTitleLike("%"+keyname+"%");
			}
		if(subject!=0){
			System.out.println("科目"+subject);
			cri.andCatalogIdEqualTo(subject);
		}
		if(!"".equals(type)){
			cri.andQuestionTypeEqualTo(type);

		}
		if(!"".equals(level)){
			cri.andQuestionLevelEqualTo(level);
		}
		if(!"".equals(startdate)&&!"".equals(enddate)){
			cri.andCreateTimeBetween(startdate,enddate);
		}
		else{
			if(!"".equals(startdate)){
			cri.andCreateTimeLike(startdate+"%");
			}
			if(!"".equals(enddate)){
				cri.andCreateTimeLike(enddate+"%");

			}

		}


		PageHelper.startPage(pageNum, 10);
		list  =questionsMapper.selectByExample(questionsExample);
		PageInfo<Questions> pageInfo = new PageInfo<Questions>(list);
		pagemap.put("pageinfo",pageInfo);
		pagemap.put("list",list);
		return pagemap;
	}

	@Override
	public String insertQuestion(Questions question) {
		int result  = questionsMapper.insert(question);

		System.out.println(result);
		if(result>0){
			return "0";

		}else{

			return "1";
		}

	}

	@Override
	public Integer deleteByIds(Integer[] ids) {
		Integer count =0;
		for(int i=0;i<ids.length;i++) {
			int result = questionsMapper.deleteByPrimaryKey(ids[i]);
			count=count+result;
		}

		return count;
	}

	@Override
	public Questions queryById(Integer Id) {
		Questions question = questionsMapper.selectByPrimaryKey(Id);

		return question;
	}

	@Override
	public String UpdateQuestion(Questions question) {
		int result = questionsMapper.updateByPrimaryKey(question);
		if(result>0){
			return "0";

		}else {


			return "1";
		}

	}


}
