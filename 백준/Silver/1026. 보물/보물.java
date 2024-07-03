import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        List<Integer> A = new ArrayList<>();

        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            A.add(Integer.parseInt(sa[i]));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(sa[i]));
        }

        int answer = 0;
        Collections.sort(A, Collections.reverseOrder());
        for(int i=0; i<N; i++){
            answer += A.get(i) * pq.poll();
        }

        System.out.println(answer);
    }
}
