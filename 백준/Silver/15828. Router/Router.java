import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        Queue<Integer> q = new LinkedList<>();
        while(true){
            s = bf.readLine();
            int num = Integer.parseInt(s);
            if(num == -1) break;
            else if(num == 0 && !q.isEmpty()) q.poll();
            else if(q.size() != N) q.add(num);
        }

        StringBuilder sb = new StringBuilder();
        if(q.isEmpty()) System.out.println("empty");
        else{
            while(!q.isEmpty()){
                sb.append(q.poll()).append(" ");
            }
            System.out.println(sb);
        }
    }
}