import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 자기 앞ㅇ*/

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] sa = bf.readLine().split(" ");
            List<Integer> line = new ArrayList<>();
            sb.append(sa[0]).append(" ");

            int answer = 0;
            for (int i = 1; i < sa.length; i++) {
                int num = Integer.parseInt(sa[i]);
                line.add(num);
                Collections.sort(line);

                // 몇 번째 서있는지 확인하기
                for (int j = 0; j < line.size(); j++) {
                    if(line.get(j) == num){
                        answer += line.size() - (j + 1);
                        break;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}