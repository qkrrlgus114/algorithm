import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = br.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]) - 1;

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int count = 0;
        while(!q.isEmpty()){
            if(count == K){
                count = 0;
                sb.append(q.poll());
                if(q.isEmpty()){
                    sb.append(">");
                    break;
                }
                else sb.append(", ");
            }else{
                int temp = q.poll();
                q.add(temp);
                count++;
            }
        }

        System.out.println(sb);

    }

}
