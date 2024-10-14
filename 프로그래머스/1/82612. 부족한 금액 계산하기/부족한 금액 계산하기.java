class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long num =0;
        for(int i=1; i<=count; i++){
            num += price*i; 
        }
        answer = num - money >= 0 ? num - money : 0;
        return answer;
    }
}