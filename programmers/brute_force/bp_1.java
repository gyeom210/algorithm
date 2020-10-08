import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] people = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] cnt = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < 3; j++){
                if(answers[i] == people[j][i % people[j].length]){
                    cnt[j]++;
                }
            }
        }
        int max = 0;
        for(int a : cnt) {
            if(max < a)
                max = a;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(max == cnt[i]){
                list.add((i+1));
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}