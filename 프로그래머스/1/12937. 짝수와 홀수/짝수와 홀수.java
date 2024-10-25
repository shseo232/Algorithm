class Solution {
    public String solution(int num) {   
       if(num == 0){
           return "Even";
       }
       return num % 2 == 0 ? "Even" : "Odd" ;
    }
}