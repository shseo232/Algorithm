class Solution
{
    static int cal (int a, int b,int answer){
        if(a == b){
            return answer;
        }
        
        return cal((a+1)/2,(b+1)/2,answer+1);
    }
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        answer = cal(a,b,answer);
        return answer;
    }
}