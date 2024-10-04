class Solution {
    public boolean isMatch(String s, String p) {
        

        return function(s.length()-1,p.length()-1,s,p);


    }

    boolean isAllStarts(int idx,String p){
        for(int i=0;i<=idx;i++){
            if(p.charAt(i)!='*') return false;
        }
        return true;
    }

    boolean function(int i1,int i2,String s,String p){

        //base case
        if(i1<0 && i2<0) return true; //both string over together

        if(i2<0) return false;//still p exists to match

        if(i1<0) return isAllStarts(i2,p);

        if(s.charAt(i1) == p.charAt(i2) || p.charAt(i2) == '?'){
            return function(i1-1,i2-1,s,p);
        }else if(p.charAt(i2) == '*'){
             return function(i1-1,i2,s,p) || function(i1,i2-1,s,p);   
        }else{
            return false;
        }

    }
}
