import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        Deque<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            q.add(i);
        }

        while(q.size() != 1){
            q.pop();
            if(q.size() == 1){
                break;
            }
            q.addLast(q.pop());
        }

        System.out.println(q.pop());


    }
}