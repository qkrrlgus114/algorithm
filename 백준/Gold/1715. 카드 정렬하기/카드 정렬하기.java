import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        int N = Integer.parseInt(n);

        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            n = bf.readLine();
            pq.add(Integer.parseInt(n));
        }

        while(pq.size() != 1){
            Integer poll = pq.poll();
            Integer poll1 = pq.poll();
            result += poll + poll1;
            pq.add(poll + poll1);
        }
        System.out.println(result);
    }

}