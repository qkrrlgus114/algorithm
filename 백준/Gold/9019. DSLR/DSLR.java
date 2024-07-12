import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for(int t=0; t<T; t++){
            visited = new boolean[10000];
            String[] sa = bf.readLine().split(" ");

            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);

            String answer = bfs(start, end);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static String bfs(int start, int end){
        Queue<String[]> q = new LinkedList<>();
        visited[start] = true;
        q.add(new String[]{String.valueOf(start), ""});

        while(!q.isEmpty()){
            String[] temp = q.poll();
            start = Integer.parseInt(temp[0]);

            for(int i=0; i<4; i++){
                String command = temp[1];
                int num = DSLR(start, i);

                if(visited[num]) continue;
                visited[num] = true;
                if(i == 0) command += "D";
                else if(i == 1) command += "S";
                else if(i == 2) command += "L";
                else if(i == 3) command += "R";
                if(num == end) return command;


                q.add(new String[]{String.valueOf(num), command});
            }
        }

        return null;
    }

    private static int DSLR(int value, int dir){
        int num = 0;
        if(dir == 0){
            value *= 2;
            if(value > 9999) value %= 10000;
        }else if(dir == 1){
            if(value == 0) return 9999;
            value -= 1;
        }else if(dir == 2){
            num += value / 1000;
            num += (value % 10) * 10;
            num += ((value % 100) / 10) * 100;
            num += ((value % 1000) / 100) * 1000;
            return num;
        }else if(dir == 3){
            num += (value % 100) / 10;
            num += ((value % 1000) / 100) * 10;
            num += (value / 1000) * 100;
            num += (value % 10) * 1000;
            return num;
        }

        return value;
    }
}
