import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int[][] arr = new int[skill_trees.length][skill.length()];
        for(int i=0; i<arr.length; i++){
            Arrays.fill(arr[i], -1);
        }
        
        for(int i=0; i<skill.length(); i++){
            char preSkill = skill.charAt(i);
            for(int j=0; j<skill_trees.length; j++){
                String skill_tree = skill_trees[j];
                for(int k=0; k < skill_tree.length(); k++){
                    if(preSkill == skill_tree.charAt(k)){
                        arr[j][i] = k;
                        break;
                    }
                }
                
            }
        }
        int count = 0;
        // 스킬이 잘 찍혔는지 확인
        for(int i=0; i<arr.length; i++){
            boolean check = true;
            for(int j=1; j<arr[i].length; j++){ 
                // 이전 값이 -1이면 종료, 이전 값이 더 크면 종료
                if(arr[i][j] != -1 && (arr[i][j - 1] == -1 || arr[i][j] < arr[i][j-1])){
                    check = false;
                    break;
                } 
            }
            if(check) count++;
        }

        return count;
    }
}