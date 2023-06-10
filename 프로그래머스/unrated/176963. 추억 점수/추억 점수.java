import java.util.*;
class Solution {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        // 작품에 따라 점수를 2차배열로 설정해야함.
        String[][] point = new String[name.length][2];
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<name.length; i++){
            point[i][0] = name[i]; // 작품 이름과
            point[i][1] = yearning[i]+""; // 그 작품의 점수를 넣음
        }
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                for(int k=0; k<name.length; k++){
                    if(name[k].equals(photo[i][j])) sum+=Integer.parseInt(point[k][1]);
                }
            }
            list.add(sum);
            sum=0;
        }
        return list;
    }
}