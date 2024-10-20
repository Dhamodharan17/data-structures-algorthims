
public class Main
{
    static final int P = 31;
    
    public static void main(String[] args) {
     
     String text1 = "abc";
     String text2 = "abc";
     if(rollingHash(text1) == 
     rollingHash(text2)) System.out.print("Same");
     else System.out.print("Not Equal");
     
    }
    
   static long rollingHash(String text){
   
       long hashValue = 0;
       long pPower = 1;
       
       for(char c: text.toCharArray()){
           long current = c-'a'+1;
           hashValue+=current;
           pPower = pPower*P;//1,31,31*31,31*31*31 i.e pPower
       }
   return hashValue;
  }// end of method
}
