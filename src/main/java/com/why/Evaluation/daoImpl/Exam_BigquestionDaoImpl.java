package com.why.Evaluation.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Repository;

import com.why.Evaluation.dao.Exam_BigquestionDao;
import com.why.Evaluation.dto.Bigquestion;
import com.why.Evaluation.dto.BigquestionExample;
import com.why.Evaluation.dto.BigquestionExample.Criteria;
import com.why.Evaluation.mapperImpl.BigquestionMapper;

@Repository
public class Exam_BigquestionDaoImpl implements Exam_BigquestionDao {
	
	@Resource
	private BigquestionMapper bigquestionMapper;

	@Override //新增大题并返回大题的编号
	public Integer addBigquestion(Bigquestion bigquestion) {
		
		Integer currentBigquestion_id = 0;
		
		Integer result = bigquestionMapper.insert(bigquestion);
		
		if(result!=0){
			
			Bigquestion currentBigquestion = getBigquestionByPaperAndNumber(bigquestion.getPaperId(), bigquestion.getBigquestionN());
			
			currentBigquestion_id = currentBigquestion.getBigquestionId();
			
		}
		
		return currentBigquestion_id;
	}
	
	@Override //通过试卷id和大题号获取唯一大题(主要是用于获取id)
	public Bigquestion getBigquestionByPaperAndNumber(Integer paper_id,Integer bigquestion_n){
		
		Bigquestion bigquestion = null;
		
		BigquestionExample bigquestionExample = new BigquestionExample();
		
		Criteria cri = bigquestionExample.createCriteria();
		
		cri.andPaperIdEqualTo(paper_id);
		
		cri.andBigquestionNEqualTo(bigquestion_n);
		
		List<Bigquestion> bigquestions = bigquestionMapper.selectByExample(bigquestionExample);
		
		if(bigquestions.size()!=0){
			
			bigquestion = bigquestions.get(0);
			
		}
		
		return bigquestion;
		
	}

	@Override //根据大题id获取大题
	public Bigquestion getBigquestionById(Integer bigquestion_id) {
		
		Bigquestion bigquestion = bigquestionMapper.selectByPrimaryKey(bigquestion_id);
		
		return bigquestion;
	}

	@Override //根据试卷id来获取该试卷的所有大题
	public List<Bigquestion> getBigquestionsByPaperId(Integer paper_id) {
		
		BigquestionExample bigquestionExample = new BigquestionExample();
		
		Criteria cri = bigquestionExample.createCriteria();
		
		cri.andPaperIdEqualTo(paper_id);
		
		List<Bigquestion> bigquestions = bigquestionMapper.selectByExample(bigquestionExample);
		
		return bigquestions;
	}

	@Override //修改大题(增加,删除小题,修改大题的总分值)
	public boolean updateBigquestion(Bigquestion bigquestion) {
		
		Integer result = bigquestionMapper.updateByPrimaryKeySelective(bigquestion);
		
		return result==0?false:true;
	}

	@Override //降低大题的序号(在大题被删除后，在其后面大题的序号-1)
	public boolean decreaseBigquestionNumber(Bigquestion bigquestion) {
		
		Bigquestion operate = new Bigquestion();
		operate.setBigquestionId(bigquestion.getBigquestionId());
		operate.setBigquestionN(bigquestion.getBigquestionN()-1); //大题的序号减小1
		
		Integer result = bigquestionMapper.updateByPrimaryKeySelective(operate);
		
		return result==0?false:true;
	}

	@Override //删除大题
	public boolean deleteBigquestion(Integer bigquestion_id) {
		
		Integer result = bigquestionMapper.deleteByPrimaryKey(bigquestion_id);
		
		return result==0?false:true;
	}

	@Override //获取需要减少大题序号的大题(删除大题时要做的动作)
	public List<Bigquestion> getUnderNumberExam(Bigquestion bigquestion) {
		
		BigquestionExample bigquestionExample = new BigquestionExample();
		
		Criteria cri = bigquestionExample.createCriteria();
		
		cri.andBigquestionNGreaterThan(bigquestion.getBigquestionN());
		
		List<Bigquestion> bigquestions = bigquestionMapper.selectByExample(bigquestionExample);
		
		return bigquestions;
	}

	@Override
	public Integer getBiggestBigquestionN(Integer paper_id) {
		
		Integer biggestBigquestionN = bigquestionMapper.selectMaxBigquestionN(paper_id);
		
		System.out.println("我查出来的最大值:"+biggestBigquestionN);
		
		return biggestBigquestionN;
	}

	@Override
	public Integer getBigquestionScoreSum(Integer paper_id) {
		
		Integer bigquestionScoreSum = bigquestionMapper.selectSumScore(paper_id);
		
		return bigquestionScoreSum;
	}

}
