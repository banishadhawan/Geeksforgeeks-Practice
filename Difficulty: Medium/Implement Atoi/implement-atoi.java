class Solution {
    public int myAtoi(String s) {
        // code here
        int n = s.length();
        int i=0, ans=0;
        int sign=1;
        
        //1. skip space
        while(i<n && s.charAt(i)==' ') i++;   
        
        //2. sign
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign = (s.charAt(i) =='-')?-1:1;
            i++;
        }
        
        //3. digits conversion
       while(i<n && Character.isDigit(s.charAt(i))){
           int digit = s.charAt(i)-'0';
           
           //4. overflow handle
           if(ans > (Integer.MAX_VALUE-digit)/10){
               return (sign==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
           }
           
           ans = ans*10 + digit;
           i++;
       } 
        return sign*ans;
    }
            
       
}