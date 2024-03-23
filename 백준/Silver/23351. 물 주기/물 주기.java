import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa =  bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int A = Integer.parseInt(sa[2]);
        int B = Integer.parseInt(sa[3]);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            q.add(K);
        }

        int day = 1;

        while(true){
            boolean dead = false;

            for(int i=0; i<A; i++){
                Integer poll = q.poll();
                q.add(poll + B);
            }

            for(int i=0; i<N; i++){
                Integer poll = q.poll();
                if(poll - 1 == 0){
                    dead = true;
                    break;
                }
                q.add(poll - 1);
            }

            if(dead) break;
            day++;
        }

        System.out.println(day);
    }
}

