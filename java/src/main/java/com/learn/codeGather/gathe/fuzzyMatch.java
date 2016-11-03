package com.learn.codeGather.gathe;
interface MatchHander{  
    boolean compare(int a, int b);
} 
public class fuzzyMatch {  
  
    /** 
     * 百分之多少之内匹配错误可以接受 
     * a与ab匹配为百分之50的错误率。 
     * @param percent 设置匹配百分比 
     * @param src 字符串1 
     * @param dest 字符串2 
     * @param hander 匹配规则 
     * @return 
     */  
    public static boolean match(double percent,String src,String dest,MatchHander hander){  
        char[] csrc = src.toCharArray();  
        char[] cdest = dest.toCharArray();  
        double score = 0;  
        score = cal(csrc,0,cdest,0,hander);  
        int max = csrc.length>cdest.length?csrc.length:cdest.length;  
        System.out.println("最小匹配百分比："+percent+"，成功匹配百分比："+score / max);  
        return score / max > percent;  
    }  
  
    /** 
     * 几个错误的字符可以接受 
     * a与ab为1个字符错误可以接受 
     * @param percent 设置匹配百分比 
     * @param src 字符串1 
     * @param dest 字符串2 
     * @param hander 匹配规则 
     * @return 
     */  
    public static boolean match(int errorNum,String src,String dest,MatchHander hander){  
        char[] csrc = src.toCharArray();  
        char[] cdest = dest.toCharArray();  
        int score = 0;  
        score = cal(csrc,0,cdest,0,hander);  
        int max = csrc.length>cdest.length?csrc.length:cdest.length;  
        System.out.println("可以接受错误数："+errorNum+"，发现错误数："+(max - score) );  
        return max - score  <= errorNum;  
    }  
    /** 
     * 2个字符串75%匹配成功返回true 
     * @param src 
     * @param dest 
     * @return 
     */  
    public static boolean match(double percent,String src,String dest){  
        return match(percent,src,dest,new MatchHander(){  
  
            public boolean compare(int a, int b) {  
                return a==b;  
            }});  
    }  
    /** 
     * 2个字符串错几个字符可以接受 
     * @param errorNum 
     * @param src 
     * @param dest 
     * @return 
     */  
    public static boolean match(String src,String dest){ 
    	int errorNum=dest.length()-src.length();
        return match(errorNum,src,dest,new MatchHander(){  
  
            public boolean compare(int a, int b) {  
                return a==b;  
            }});  
    }  
  
	/**
	 * 使用递归方法匹配字符串
	 * 
	 * @param csrc
	 * @param i
	 * @param cdest
	 * @param j
	 * @param hander
	 * @return
	 */ 
    private static int cal(char[] csrc, int i, char[] cdest, int j, MatchHander hander) {  
        int score = 0;  
        if(i >= csrc.length || j >= cdest.length)  
            return 0;  
        boolean ismatch = hander.compare(csrc[i], cdest[j]);  
        if(ismatch){  
            score++;  
            if(i+1<csrc.length && j+1<cdest.length)  
                score +=  cal(csrc, i+1, cdest, j+1, hander) ;  
        }else{  
            int temp1 = 0;  
            int temp2 = 0;  
            int temp3 = 0;  
            temp1 +=  cal(csrc, i, cdest, j+1, hander) ;  
//            temp2 +=  cal(csrc, i+1, cdest, j, hander) ;  
//            temp3 +=  cal(csrc, i+1, cdest, j+1, hander) ;  
            int temp4 = Math.max(temp1, temp2);  
            score += Math.max(temp3, temp4);  
        }  
        return score;  
    }  
    public static void main(String[] args) {  
//        System.out.println(match("神啊救救我是","神啊救救我吧"));  
        //75%匹配可以接受  
    	long a=System.currentTimeMillis();
        System.out.println(match("神啊救救我吧sdfsdfefsdf123123","神啊救救我吧sdfsdfewfdsvsdfsd2132131cxvsdfaaasd123123"));  
        System.out.println((System.currentTimeMillis()-a));
    }  
}  