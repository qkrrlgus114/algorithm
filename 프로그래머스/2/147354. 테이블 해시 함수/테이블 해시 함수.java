import java.util.*;

class Solution {
    static int staticCol = 0;
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        staticCol = col - 1;
        
        for(int i=0; i<data.length; i++){
            Arrays.sort(data, new Comparator<int[]>(){
                public int compare(int[] o1, int[] o2){
                    if(o1[staticCol] == o2[staticCol]){
                        return o2[0] - o1[0];
                    }
                    return o1[staticCol] - o2[staticCol];
                }
            });
        }
        
        row_begin -= 1;
        row_end -= 1;
        
        List<Integer> list = new ArrayList<>();
        for(int i=row_begin; i<=row_end; i++){
            int sum = 0;
            for(int j=0; j<data[i].length; j++){
                sum += data[i][j] % (i + 1);
            }
            list.add(sum);
        }
        
        int answer = list.get(0);
        if(list.size() >= 2){
            for(int i=1; i<list.size(); i++){
                answer ^= list.get(i);
            }
        }
        
        return answer;
    }
}