import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        
        List<Integer> mat = new ArrayList<>();
        for(int i=0; i<mats.length; i++){
            mat.add(mats[i]);
        }
        
        Collections.sort(mat, Collections.reverseOrder());
        
        for(int z=0; z<mat.size(); z++){
            int size = mat.get(z);
            for(int i=0; i<park.length; i++){
                for(int j=0; j<park[0].length; j++){
                    if(!park[i][j].equals("-1")){
                        continue;
                    }
                    
                    int count = 0;
                    outer: for(int k=i; k<Math.min(park.length, i+size); k++) {
                        for(int l=j; l<Math.min(park[0].length, j+size); l++) {
                           if (!park[k][l].equals("-1")) {
                               break outer;
                           }
                            count++;
                        }
                    }
                    
                    if(count == size * size){
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
}