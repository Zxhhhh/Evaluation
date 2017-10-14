package com.why.Evaluation.vo;

/**
 * 饼图数据
 * 
 * @author K550J
 * 
 */
public class Exam_VO4PieChartInfo {

	private String itemName;
	private Integer itemData;

	public Exam_VO4PieChartInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam_VO4PieChartInfo(String itemName, Integer itemData) {
		super();
		this.itemName = itemName;
		this.itemData = itemData;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemData() {
		return itemData;
	}

	public void setItemData(Integer itemData) {
		this.itemData = itemData;
	}

}
