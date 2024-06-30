import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        // 정렬
        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[col-1] == o2[col-1]){
                    return o2[0] - o1[0];
                }
                return o1[col-1] - o2[col-1];
            }
        });
        
        int result = 0;
        
        for(int i=row_begin - 1; i < row_end; i++){
            int value = 0;
            for(int j=0; j<data[i].length; j++){
                value += data[i][j] % (i+1);
            }
            result ^= value;
        }
        
        return result;
    }
}