import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int finalTemp = 0; // result에 넣기 위한 인덱스
        for(int i=0; i<commands.length; i++){
            int[] arr = new int[commands[i][1]-commands[i][0]+1];
            int temp = 0; // 잘라서 넣기 위한 임시 인덱스
            for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++){
                arr[temp++] = array[j];
            }
            temp = 0;
            Arrays.sort(arr);
            result[finalTemp++] = arr[commands[i][2]-1];
        }
        return result;
    }
}