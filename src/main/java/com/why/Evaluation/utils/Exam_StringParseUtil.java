package com.why.Evaluation.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.why.Evaluation.vo.Exam_VO4QuestionAddParam;

public class Exam_StringParseUtil {
	
	public static Map parseQuestionStr(String str,boolean isAjax,Integer questions_catalog){
		
		Map parseResult = new HashMap();
		
		List<Exam_VO4QuestionAddParam>  vo4QuestionAddParams = new ArrayList<Exam_VO4QuestionAddParam>();
		
		Integer questionCount = 0;//试题总数,
		Integer pastQuestionCount = 0;//格式符合的试题总数
		Integer notPastQuestionCount = 0;//格式不符合的试题总数
		List<Integer> notPastNumList = new ArrayList<Integer>(); //格式不符合的试题编号集合
		
		String[] questionStrings = null;
		//获取各个大题
		if(isAjax)
			questionStrings = str.split("\n\n");
		else
			questionStrings = str.split("\r\n\r\n");
		
		//System.out.println("试题数量:"+questionStrings.length);
		
		questionCount = questionStrings.length;
		
		for(int i=0;i<questionStrings.length;i++){
			
			Exam_VO4QuestionAddParam vo4QuestionAddParam = new Exam_VO4QuestionAddParam();
			
			String questionStr = questionStrings[i];
			
			
			//System.out.println(questionStr);
			
			//解析试题的各个部分
			String[] questionPartsStrings = questionStr.split("   ");
			
			boolean format = true;
			for(int j=0;j<questionPartsStrings.length;j++){
				
				
				
				//System.out.println("-------------------");
				
				String partStr = questionPartsStrings[j];
				
				//System.out.println("空格分隔的模块"+j+":"+partStr);
				
				if("".equals(partStr)||partStr==null){
					continue;
				}
				
				//非题干和选项部分
				if(j!=questionPartsStrings.length-1){
					
					if(partStr.startsWith("题型:")){
						
						String content = partStr.substring(partStr.lastIndexOf(":")+1,partStr.length());
						//System.out.println("有题型了:"+content);
						
						List<String> types = Arrays.asList(Exam_ArrayUtil.questionTypes);
						
						if(types.contains(content)){
							
							//System.out.println("包含！！！");
							
							vo4QuestionAddParam.setQuestionType(content);
							
						}else{//题型不合格式
							
							//System.out.println("题型有问题!!!");
							format =false;
							break;
						}
						
						
					}else if(partStr.startsWith("标准答案:")){
						
						String content = partStr.substring(partStr.lastIndexOf(":")+1,partStr.length());
						//System.out.println("*******有标准答案了:"+content);
						
						String questionType = vo4QuestionAddParam.getQuestionType();
						
						//System.out.println("*********获取题目类型:"+questionType);
						
						if(questionType==null){
							
							//System.out.println("声明顺序有问题!!");
							format =false;
							break;
							
						}else{
							
							List<String> answers = Arrays.asList(Exam_ArrayUtil.singleChoices);
							
							if("单选题".equals(questionType)){
								
								if(answers.contains(content)){
									
									vo4QuestionAddParam.setAnswerTrue(content);
									
								}else{//答案不合格式
									
									//System.out.println("单选题答案格式有问题！！！");
									format =false;
									break;
									
								}
								
							}else if("多选题".equals(questionType)){
								
								List<String> contentList = Arrays.asList(content.split(","));
								
								if(answers.containsAll(contentList)){//包含代表多选答案是ABCD的子集
									
									//System.out.println("多选符合！！");
									
									vo4QuestionAddParam.setAnswerTrue(content);
									
								}else{
									
									//System.out.println("多选题答案格式有问题！！！");
									format =false;
									break;
									
								}
								
							}else{
								
								vo4QuestionAddParam.setAnswerTrue(content);
								
							}
						}
						
					}else if(partStr.startsWith("分数:")){
						
						String content = partStr.substring(partStr.lastIndexOf(":")+1,partStr.length());
						//System.out.println("有分数了:"+content);
						
						try{
							
							Double score = Double.parseDouble(content);
							vo4QuestionAddParam.setQuestionSocre(score);
							
						}catch (Exception e) {
							//System.out.println("分数格式有问题!!!");
							format =false;
							break;
						}
						
						
					}else if(partStr.startsWith("难度:")){
						
						String content = partStr.substring(partStr.lastIndexOf(":")+1,partStr.length());
						//System.out.println("有难度了:"+content);
						
						List<String> questionLevels = Arrays.asList(Exam_ArrayUtil.questionLevels);
						
						if(questionLevels.contains(content)){
							vo4QuestionAddParam.setQuestionLevel(content);
						}else{
							
							//System.out.println("难度格式有问题!!!");
							format =false;
							break;
							
						}
						
					}else if(partStr.startsWith("试题分析:")){
						
						String content = partStr.substring(partStr.lastIndexOf(":")+1,partStr.length());
						//System.out.println("有试题分析了:"+content);
						
						vo4QuestionAddParam.setQuestionAnalysis(content);
					}
					
				}else{
					
					//System.out.println("题干和选项部分:"+partStr);
					
					String[] mainPartStrings = partStr.split("\n");
					
					System.out.println("题干和选项部分的大小:"+mainPartStrings);
					
					for(int k=0;k<mainPartStrings.length;k++){
						
						String mainPartStr = mainPartStrings[k];
						
						if(mainPartStr.startsWith("题干:")){
							
							String content = mainPartStr.substring(mainPartStr.lastIndexOf(":")+1,mainPartStr.length());
//							System.out.println("有题干了:"+content);
							
							vo4QuestionAddParam.setQuestionTitle(content);
							
						}else if(mainPartStr.startsWith("A")){
							
							String content = mainPartStr.substring(mainPartStr.lastIndexOf(":")+1,mainPartStr.length());
//							System.out.println("有选项A了:"+content);
							
							vo4QuestionAddParam.setOptionA(content);
							
						}else if(mainPartStr.startsWith("B")){
							
							String content = mainPartStr.substring(mainPartStr.lastIndexOf(":")+1,mainPartStr.length());
//							System.out.println("有选项B了:"+content);
							
							vo4QuestionAddParam.setOptionB(content);
							
						}else if(mainPartStr.startsWith("C")){
							
							String content = mainPartStr.substring(mainPartStr.lastIndexOf(":")+1,mainPartStr.length());
//							System.out.println("有选项C了:"+content);
							
							vo4QuestionAddParam.setOptionC(content);
							
						}else if(mainPartStr.startsWith("D")){
							
							String content = mainPartStr.substring(mainPartStr.lastIndexOf(":")+1,mainPartStr.length());
//							System.out.println("有选项D了:"+content);
							
							vo4QuestionAddParam.setOptionD(content);
							
						}
					}
				}
				
//				System.out.println("-------------------");
			}
			
			if(format){
				
				String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				vo4QuestionAddParam.setCreateTime(dateStr);
				if(questions_catalog==0){
					vo4QuestionAddParam.setCatalogId(1);

				}
				vo4QuestionAddParam.setCatalogId(questions_catalog);
				
				vo4QuestionAddParams.add(vo4QuestionAddParam);
			}else{
				
				//格式有问题的试题
				
				notPastNumList.add(i+1);
				
			}
			
		}
		
		pastQuestionCount = vo4QuestionAddParams.size();//格式符合的试题总数
		notPastQuestionCount = questionCount-pastQuestionCount;
		
		String notPastNumStr = notPastNumList.toString();
		notPastNumStr = notPastNumStr.substring(notPastNumStr.lastIndexOf("[")+1,notPastNumStr.lastIndexOf("]"));
		notPastNumStr = notPastNumStr.replace(" ", "");
		
		parseResult.put("questionCount", questionCount);
		parseResult.put("pastQuestionCount",pastQuestionCount);
		parseResult.put("notPastQuestionCount",notPastQuestionCount);
		parseResult.put("notPastNumStr", notPastNumStr);
		parseResult.put("vo4QuestionAddParams",vo4QuestionAddParams);
		
		System.out.println("总试题数:"+questionCount);
		System.out.println("通过的试题数:"+pastQuestionCount);
		System.out.println("不通过的试题数:"+notPastQuestionCount);
		System.out.println("不通过的试题列表:"+notPastNumStr);
		System.out.println("通过的试题:"+vo4QuestionAddParams);
		
		System.out.println("----------");
		
		for(Exam_VO4QuestionAddParam exam_VO4QuestionAddParam:vo4QuestionAddParams){
			System.out.println(exam_VO4QuestionAddParam);
		}
		
		return parseResult;
		
	}

}
