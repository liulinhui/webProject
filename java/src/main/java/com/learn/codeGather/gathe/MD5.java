package com.learn.codeGather.gathe;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*
 * MD5 算法
*/
public class MD5 {
    
    // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5() {
    }

    // 返回形式为数字跟字符串
    private String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    @SuppressWarnings("unused")
	private  String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private  String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    public static void main(String[] args) {
//    	double begin = System.currentTimeMillis(); // 程序开始时间，调用系统的当前时间
    	ControllerHelp controllerHelp=new ControllerHelp();
        MD5 getMD5 = new MD5();
//        String string="12345";
//        int i;
//        for (i = 0; i <200; i++) {
//			string=getMD5.GetMD5Code(string);
//		}
        String string2=getMD5.GetMD5Code("123"+controllerHelp.Reg_time());
//        double end = System.currentTimeMillis(); // 程序结束时间，调用系统当前时间
//		double time = end - begin;// 程序的运行时间
//		System.out.println("代码执行了"+time / 60 + "秒");
//		System.out.println("加密层数:"+i+ "次");
//        System.out.println(string);
		System.out.println(string2);
//		System.out.println(begin);
    }
}