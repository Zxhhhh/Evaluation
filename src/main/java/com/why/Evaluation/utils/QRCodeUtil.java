package com.why.Evaluation.utils;

import java.nio.file.FileSystems;  
import java.nio.file.Path;  
import java.util.HashMap;  
import java.util.Map;  
import com.google.zxing.BarcodeFormat;  
import com.google.zxing.EncodeHintType;  
import com.google.zxing.MultiFormatWriter;  
import com.google.zxing.client.j2se.MatrixToImageWriter;  
import com.google.zxing.common.BitMatrix;  
import com.why.Evaluation.vo.Exam_VO4QRCodeInfo;

/**
 * 二维码生成工具类(ZXing组件)
 * @author K550J
 *
 */
public class QRCodeUtil {
	
	/**
	 * 生成二维码
	 * @param exam_VO4QRCodeInfo 二维码信息
	 * @throws Exception
	 */
	public void Encode(Exam_VO4QRCodeInfo exam_VO4QRCodeInfo) throws Exception{
		
	    String filePath = exam_VO4QRCodeInfo.getImgPath();  
	    String fileName = exam_VO4QRCodeInfo.getImgName();  
//	    JSONObject json = new JSONObject();  
//	    json.put("zxing","https://github.com/zxing/zxing/tree/zxing-3.0.0/javase/src/main/java/com/google/zxing");  
//	    json.put("author", "shihy");  
//	    String content = json.toJSONString();// 内容
	    String content = exam_VO4QRCodeInfo.getImgContent();
	    int width = exam_VO4QRCodeInfo.getImgWidth(); // 图像宽度  
	    int height = exam_VO4QRCodeInfo.getImgHeight(); // 图像高度  
	    String format = exam_VO4QRCodeInfo.getImgFormat();// 图像类型  
	    Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();  
	    hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
	    BitMatrix bitMatrix = new MultiFormatWriter().encode(content,  
	            BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵  
	    Path path = FileSystems.getDefault().getPath(filePath, fileName);  
	    MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像 
	    System.out.println("输出内容:"+content);
	    System.out.println("输出成功.");  
	}
	
	public static void main(String[] args) throws Exception{
		
		new QRCodeUtil().Encode(new Exam_VO4QRCodeInfo());
		
	}

}
