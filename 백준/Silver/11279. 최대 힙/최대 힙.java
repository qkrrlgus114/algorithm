import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            int value = Integer.parseInt(bf.readLine());
            if(value == 0 && !pq.isEmpty()){
                sb.append(pq.poll()).append("\n");
            }else if(value == 0 && pq.isEmpty()){
                sb.append(0).append("\n");
            }else{
                pq.add(value);
            }
        }

        System.out.println(sb);

    }
}
