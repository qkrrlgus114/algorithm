import java.util.*;
class Solution {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                if(map.containsKey(photo[i][j])){
                    sum+=map.get(photo[i][j]);
                }
            }
            result.add(sum);
            sum = 0;
        }
        return result;
    }
}