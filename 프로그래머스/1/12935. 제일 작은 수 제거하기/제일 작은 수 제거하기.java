class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        int temp = Integer.MAX_VALUE;
        for(int i : arr){
            temp = Math.min(temp,i);
        }
        if(answer.length == 0){
            answer = new int[]{-1};
            return answer;
        }
        int count =0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == temp){
                continue;
            }
            answer[count++] = arr[i];
        }
        return answer;
    }
}