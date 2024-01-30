import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 암호의 길이
    static int L;
    // 주어진 알파벳의 수
    static int C;
    // 주어진 알파벳
    static char[] secret;
    // 임시 비밀번호
    static char[] password;
    // 방문체크
    static boolean[] visited;
    static List<String> list = new ArrayList<>();
    static char[] check = {'a', 'e', 'i', 'o', 'u'};
;



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        L = Integer.parseInt(sa[0]);
        C = Integer.parseInt(sa[1]);

        secret = new char[C];
        visited = new boolean[C];
        password = new char[L];
        String a = bf.readLine().replace(" ", "");
        secret = a.toCharArray();

        dfs(0, ' ');
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int depth, char a){
        // 종료 조건
        if(depth == L) {

            // 자음의 개수 확인
            int count = 0;
            for(int i=0; i<5; i++){
                for(int j=0; j<password.length; j++){
                    if(password[j] == check[i]){
                        count++;
                        break;
                    }
                }
            }

            if(count != 0 && count < L -1){
                list.add(String.valueOf(password));
            }
            return;
        }

        for(int i=0; i<C; i++){
            if(!visited[i] && a < secret[i]){
                password[depth] = secret[i];
                visited[i] = true;
                dfs(depth + 1, secret[i]);
                password[depth] = ' ';
                visited[i] = false;
            }
        }
    }

}