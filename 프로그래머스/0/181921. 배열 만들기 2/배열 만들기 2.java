import java.util.*;
class Solution {
    public List<Integer> solution(int l, int r) {
        int[] answer = {};
        List<Integer> list = new ArrayList();
        String reg = "[^1,2,3,4,6,7,8,9]*$";
        for(int i=l; i<=r; i++){
            if(String.valueOf(i).matches(reg)){
                list.add(i);
            }
        }
        if(list.size() == 0){
            list.add(-1);
        }
        return list;
    }
}