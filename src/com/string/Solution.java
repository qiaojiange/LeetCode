package com.string;

public class Solution {
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
