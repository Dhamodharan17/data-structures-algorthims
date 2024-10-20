/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static final int P = 31;
    
	public static void main (String[] args) {
	    
	    stringEquals("abc","abc");
	    boolean isSub = containsSubString("abc","c");
	    System.out.println(isSub);

	}
	
	//check string equals O(n)
	static void stringEquals(String text1,String text2){
	    
	  System.out.println(rollingHash(text1) == rollingHash(text2) ? "Equals" : "Not Equals");
	   
	}
	
	//check substring Equals O(n+m)
	static boolean containsSubString(String text,String pattern){
	    long patternHash = rollingHash(pattern);
	    long textHash = 0;
	    
	    for(int i=0;i<text.length();i++){
	        
	        String currentSubString = text.substring(i,i+pattern.length());
	        textHash = rollingHash(currentSubString);
	        if(patternHash == textHash && pattern.equals(currentSubString)) return true;
	        
	    }
	    return false;
	}
	
	//hash function
	static long rollingHash(String text){
	       
	   long hashValue = 0;
	   long pPower = 1;
	   
	   for(char c:text.toCharArray()){
	       long current = c-'a'+1;
	       hashValue += current * pPower;
	       pPower = pPower*P;
	   }
	   return hashValue;
	    
	}
	
}

