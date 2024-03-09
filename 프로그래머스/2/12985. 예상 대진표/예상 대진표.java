import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        Queue<int[]> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(i == a || i == b) q.add(new int[]{i, 1});
            else q.add(new int[]{i, 0});
        }
        
        int result = 0;
        int[] one = new int[2];
        int[] two = new int[2];
        boolean check = false;
        while(true){
            result++;
            System.out.println(q.size());
            int loop = q.size();
            for(int i=0; i<loop / 2; i++){
                one = q.poll();
                two = q.poll();
                if(one[1] == 1 && two[1] == 1){
                    check = true;
                    break;
                } 

                if(one[1] == 1 && two[1] != 1){
                    if(one[0] % 2 == 0) one[0] /= 2;
                    else one[0] = (one[0] / 2) + 1;
                    q.add(one);
                }else if(two[1] == 1 && one[1] != 1){
                    if(two[0] % 2 == 0) two[0] /= 2;
                    else two[0] = (two[0] / 2) + 1;
                    q.add(two);
                }else{
                    if(one[0] % 2 == 0) one[0] /= 2;
                    else one[0] = (one[0] / 2) + 1;
                    q.add(one);
                }
            }
            if(check) break;
        }

        return result;
    }
}