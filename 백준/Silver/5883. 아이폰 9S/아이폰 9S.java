import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

public class Main{

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);
        List<Integer> arr = new ArrayList<>();

        int[] waiting = new int[N];
        for(int i=0; i<N; i++){
            s = bf.readLine();
            waiting[i] = Integer.parseInt(s);
            if(!arr.contains(waiting[i])) arr.add(waiting[i]);
        }

        // 최대 인원 수
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<arr.size(); i++){
            int find = arr.get(i); // 빼려는 사람
            int count = 0; // 현재까지 연속된 인원
            int countNum = 0; // 현재 사람의 번호
            for(int j=0; j<waiting.length; j++){
                if(find == waiting[j]){
                    continue;
                }else{
                    if(countNum == 0){
                        count++;
                        countNum = waiting[j];
                    }else if(countNum == waiting[j]){
                        count++;
                    }else if(countNum != waiting[j]){
                        answer = Math.max(answer, count);
                        count = 1;
                        countNum = waiting[j];
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);

    }
}
