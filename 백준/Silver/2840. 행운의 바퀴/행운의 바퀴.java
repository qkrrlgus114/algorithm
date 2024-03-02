import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static boolean check = true;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        // 알파벳 나왔는지 체크 필요
        boolean[] alpha = new boolean[26];
        String[] arr = new String[N];
        Arrays.fill(arr, "?");

        // 현재 위치
        int cur = 0;

        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            int next = Integer.parseInt(sa[0]);
            String word = sa[1];

            next %= N;
            if(cur - next < 0){
                cur = N - (next - cur);
            }else{
                cur -= next;
            }
            if(arr[cur].equals("?")){
                if(alpha[word.charAt(0) - 65]){
                    System.out.println("!");
                    break;
                }
                arr[cur] = word;
                alpha[word.charAt(0) - 65] = true;
            }else if(!arr[cur].equals(word)){
                System.out.println("!");
                break;
            }

            if(i == M-1){
                StringBuilder sb = new StringBuilder();
                for(int q=0; q<arr.length; q++){
                    sb.append(arr[cur++]);
                    if(cur == N) cur = 0;
                }
                System.out.println(sb);
            }
        }
    }
}
