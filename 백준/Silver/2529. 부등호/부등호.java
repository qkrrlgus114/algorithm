import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int K;
    static String[] arr; // 부등호
    static List<String> list = new ArrayList<>(); // 정답을 저장해놓을 리스트
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(bf.readLine());

        arr = new String[K];
        visited = new boolean[10];
        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            arr[i] = sa[i];
        }

        combination(0, new StringBuilder());

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));


    }

    public static void combination(int choice, StringBuilder sb) {
        // 종료 조건
        if (choice == K + 1) {
            list.add(sb.toString());
            return;
        }


        // 재귀
        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;
            if (choice > 0) {
                if (arr[choice - 1].equals(">") && sb.charAt(choice - 1) < (char) (i + '0')) continue;
                if (arr[choice - 1].equals("<") && sb.charAt(choice - 1) > (char) (i + '0')) continue;
            }
            visited[i] = true;
            sb.append(i);
            combination(choice + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

}

