import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        long sum = 0;

        Queue<Integer>[] q = new Queue[21];
        for(int i=2; i<21; i++){
            q[i] = new LinkedList<>();
        }

        // 1등부터 N등까지 입력 받음.
        for(int i=1; i<=N; i++){
            // 현재 이름의 길이
            int cur = bf.readLine().length();
            // 큐가 비어있으면 넣음
            if(q[cur].isEmpty()) q[cur].add(i);
            else{
                // 아니라면 등수 비교
                while(!q[cur].isEmpty()){
                    // 현재 비교대상이랑 큐의 맨 앞 대상의 성적차가 K 이하면 큐에 있는 모두가 친구임.
                    if(i - q[cur].peek() <= K){
                        sum += q[cur].size();
                        q[cur].add(i);
                        break;
                    }
                    // 만약 큐 앞에 있는 등수와의 차가 K보다 크면 빼냄
                    q[cur].poll();
                }
                // 만약에 큐가 비었으면 현재 인원 넣어줌
                if(q[cur].isEmpty()) q[cur].add(i);
            }
        }

        System.out.println(sum);
    }
}
