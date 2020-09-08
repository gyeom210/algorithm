import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] xanswer = new int[array.length];
        int[] answer = new int[commands.length];
        ArrayList<Integer> num = new ArrayList<>();

        for(int i = 0; i < commands.length; i++){
            for(int j = 0; j < commands.length; j++){
                if(j==1){
                    for(int z = commands[i][0]-1; z < commands[i][j]; z++){
                        num.add(array[z]);
                    }
                }else if(j==2){
                    num.sort(Comparator.naturalOrder());
                    answer[i] = num.get(commands[i][j]-1);
                }
            }
            num.clear();
        }
        return answer;
    }
}
