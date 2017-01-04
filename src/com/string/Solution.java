package com.string;

public class Solution {
	 public boolean repeatedSubstringPattern(String str) {
		 if(str==null || str.equals("")) return false;
		 
		 int start = 0;
		 boolean flag = false;
		 StringBuilder sb = new StringBuilder(str);
		 for(int i = 0;i<str.length();i++){
			 int curr = i;
			 //加上这句确实可以优化许多，解决了超时问题
			 if(sb.length()%(curr+1)!=0) continue;
			 String strTemp = str.substring(start, curr+1);
			 int j = strTemp.length();
			 if(j == sb.length()) return false;
			 for(;j<sb.length();){
				 if(j!=sb.indexOf(strTemp,j)){
					 break;
				 }
				 j+=strTemp.length();
			 }
			 if(j>=sb.length()){
				 return true;
			 }
		 }
		 return false;
	 }
	 public int countSegments(String s) {
		 if(s==null || s=="") return 0;
		 boolean preFlag = false;
		 char ch = ' ';
		 int count = 0;
		 for(int i = 0;i< s.length();i++){
			 ch = s.charAt(i);
			 if(ch != ' ' && !preFlag){
				 count++;
				 preFlag = true;
			 }
			 
			 if(ch ==' ' && preFlag){
				 preFlag=false;
			 }
		 }
		 
		 return count;
	 }
}
