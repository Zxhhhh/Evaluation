package com.why.Evaluation.utils;

/**
 * Created by Lhy on 2017/6/9 0009.
 */
public class WDWUtil {
    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    //@描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    // @描述：是否是2003的excel，返回true是2003
    public static boolean isDoc2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(doc)$");
    }

    //@描述：是否是2007的excel，返回true是2007
    public static boolean isDoc2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(docx)$");
    }

    public static boolean isTxt(String filePath)  {
        return filePath.matches("^.+\\.(?i)(txt)$");
    }
}
