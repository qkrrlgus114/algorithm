import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        List<Character> list = new ArrayList<>();

        // 진법 표시
        char[] arr = new char[36];
        int index = 0;
        for(int i=48; i<58; i++){
            arr[index++] = (char) i;
        }
        for(int i=65; i<91; i++){
            arr[index++] = (char) i;
        }

        // 구할 값
        int N = Integer.parseInt(s[0]);
        // 나눌 값
        int M = Integer.parseInt(s[1]);

        // 나누면서 진법 계산
        while(N != 0){
            int remain = N % M;
            list.add(arr[remain]);
            N /= M;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=list.size() - 1; i>= 0; i--){
            sb.append(list.get(i));
        }

        System.out.println(sb);
    }


}
