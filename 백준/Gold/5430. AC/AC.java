import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        int T = Integer.parseInt(s);
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++){
            Deque<Integer> dq = new LinkedList<>();
            // 방향 설정(true = 정방향, false = 역방향)
            boolean dir = true;
            char[] command = bf.readLine().toCharArray();
            s = bf.readLine();
            int N = Integer.parseInt(s);
            s = bf.readLine();
            String[] num = new String[N];
            if(N != 0){
                s = s.substring(1, s.length() - 1);
                num = s.split(",");
            }
            for(int i=0; i<N; i++){
                dq.addLast(Integer.parseInt(num[i]));
            }
            boolean check = true;
            for(int i=0; i<command.length; i++){
                if(command[i] == 'R'){
                    dir = !dir;
                }else{
                    if(dq.size() == 0){
                        sb.append("error").append("\n");
                        check = false;
                        break;
                    }
                    if(dir) dq.removeFirst();
                    else dq.removeLast();
                }
            }

            if(!dq.isEmpty()){
                sb.append("[");
                while(!dq.isEmpty()){
                    int temp = 0;
                    if(dir) temp = dq.removeFirst();
                    else temp = dq.removeLast();
                    if(dq.isEmpty()){
                        sb.append(temp).append("]").append("\n");
                    }else sb.append(temp).append(",");
                }
            }else if(check){
                sb.append("[]").append("\n");
            }
        }
        System.out.println(sb);

    }
}