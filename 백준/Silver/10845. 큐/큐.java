import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(bf.readLine());
        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            String command = sa[0];
            if(command.equals("push")){
                q.add(Integer.parseInt(sa[1]));
            }else if(command.equals("pop")){
                if(q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.poll()).append("\n");
            }else if(command.equals("size")){
                sb.append(q.size()).append("\n");
            }else if(command.equals("empty")){
                if(q.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if(command.equals("front")){
                if(q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.peekFirst()).append("\n");
            }else if(command.equals("back")){
                if(q.isEmpty()) sb.append(-1).append("\n");
                else {
                    sb.append(q.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
