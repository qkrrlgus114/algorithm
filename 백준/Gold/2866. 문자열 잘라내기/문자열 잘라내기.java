import java.io.BufferedReader;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int R = Integer.parseInt(sa[0]);
        int C = Integer.parseInt(sa[1]);

        char[][] arr = new char[R][C];

        for(int i=0; i<R; i++){
            char[] temp = bf.readLine().toCharArray();
            for(int j=0; j<C; j++){
                arr[i][j] = temp[j];
            }
        }

        // 정답
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        String[] str = new String[C];

        for(int i=0; i<C; i++){
            for(int j=0; j<R; j++){
                sb.append(arr[j][i]);
            }
            str[i] = sb.toString();
            sb.setLength(0);
        }

        outer: for(int i=1; i<R; i++){
            Map<String, Integer> map = new HashMap<>();
            for(int j=0; j<C; j++){
                String word = str[j].substring(i, str[j].length());
                if(map.containsKey(word)) break outer;
                map.put(word, 1);
            }
            answer++;
        }

        System.out.println(answer);

    }
}

