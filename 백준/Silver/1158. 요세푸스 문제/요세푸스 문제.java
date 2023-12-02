import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        Queue<Integer> q = new LinkedList<>();
        int count = 1;

        for(int i=1; i<=N; i++){
            q.add(i);
        }

        while(q.size() != 1){
            if (count != K){
                count++;
                q.add(q.poll());
            } else {
                count = 1;
                sb.append(q.poll() + ", ");
            }
        }
        sb.append(q.poll() + ">");

        System.out.println(sb.toString());

    }
}
