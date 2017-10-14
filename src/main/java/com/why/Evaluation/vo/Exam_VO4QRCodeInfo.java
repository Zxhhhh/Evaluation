package com.why.Evaluation.vo;

/**
 * 二维码信息
 * 
 * @author K550J
 * 
 */

public class Exam_VO4QRCodeInfo {

	private String imgPath;// 二维码路径
	private String imgName;// 二维码文件名
	private String imgContent;// 二维码内容
	private Integer imgWidth;// 二维码宽度
	private Integer imgHeight;// 二维码高度
	private String imgFormat;// 二维码格式(png,jpg等 )

	public Exam_VO4QRCodeInfo() {
		super();
	}

	public  Exam_VO4QRCodeInfo(String imgPath, String imgName,
			String imgContent, Integer imgWidth, Integer imgHeight,
			String imgFormat) {
		super();
		this.imgPath = imgPath;
		this.imgName = imgName;
		this.imgContent = imgContent;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.imgFormat = imgFormat;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgContent() {
		return imgContent;
	}

	public void setImgContent(String imgContent) {
		this.imgContent = imgContent;
	}

	public Integer getImgHeight() {
		return imgHeight;
	}

	public void setImgHeight(Integer imgHeight) {
		this.imgHeight = imgHeight;
	}

	public String getImgFormat() {
		return imgFormat;
	}

	public void setImgFormat(String imgFormat) {
		this.imgFormat = imgFormat;
	}

	public Integer getImgWidth() {
		return imgWidth;
	}

	public void setImgWidth(Integer imgWidth) {
		this.imgWidth = imgWidth;
	}

	@Override
	public String toString() {
		return "Exam_VO4QRCodeInfo [imgPath=" + imgPath + ", imgName="
				+ imgName + ", imgContent=" + imgContent + ", imgWidth="
				+ imgWidth + ", imgHeight=" + imgHeight + ", imgFormat="
				+ imgFormat + "]";
	}

}
