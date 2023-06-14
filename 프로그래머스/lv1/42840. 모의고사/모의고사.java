import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        int[] st1 = new int[] {1,2,3,4,5};
        int[] st2 = new int[] {2,1,2,3,2,4,2,5};
        int[] st3 = new int[] {3,3,1,1,2,2,4,4,5,5};
        int count1=0;
        int count2=0;
        int count3=0;
        int temp1=0;
        int temp2=0;
        int temp3=0;
        for(int i=0; i<answers.length; i++){
            if(temp1==5) temp1=0;
            if(temp2==8) temp2=0;
            if(temp3==10) temp3=0;
            if(answers[i] == st1[temp1++]) count1++;
            if(answers[i] == st2[temp2++]) count2++;
            if(answers[i] == st3[temp3++]) count3++;
        }
        List<Integer> result = new ArrayList<>();
        int max = Math.max(Math.max(count1, count2), count3);
        if(max==count1) result.add(1);
        if(max==count2) result.add(2);
        if(max==count3) result.add(3);
        Collections.sort(result);
        return result;
    }
}