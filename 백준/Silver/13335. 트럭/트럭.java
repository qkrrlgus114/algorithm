import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int W = Integer.parseInt(sa[1]);
        int L = Integer.parseInt(sa[2]);
        int[] truck = new int[N];

        Queue<Integer> q = new LinkedList<>();
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            truck[i] = Integer.parseInt(sa[i]);
        }

        for (int i = 0; i < W; i++) {
            q.add(0);
        }

        int time = 0;
        // 현재 다리 위의 트럭의 합
        int sum = 0;
        int index = 0;
        while(index < N){
            time++;
            Integer poll = q.poll();
            if(poll != 0){
                sum -= poll;
            }
            // 트럭을 넣을 수 있으면
            if(L >= sum + truck[index]){
                q.add(truck[index]);
                sum += truck[index];
                index++;
            }else{
                q.add(0);
            }
        }

        while(!q.isEmpty()){
            time++;
            q.poll();
        }

        System.out.println(time);

    }
}