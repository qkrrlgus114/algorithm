import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);

        PriorityQueue<Long> pq = new PriorityQueue<>();
        sa = bf.readLine().split(" ");
        for(int i=0; i<n; i++){
            pq.add(Long.parseLong(sa[i]));
        }
        for(int i=0; i<m; i++){
            Long num1 = pq.poll();
            Long num2 = pq.poll();
            pq.add(num1 + num2);
            pq.add(num1 + num2);
        }

        Long answer = 0L;
        int size = pq.size();
        for(int i=0; i<size; i++){
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}