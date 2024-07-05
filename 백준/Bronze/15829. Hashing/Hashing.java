import java.io.*;
import java.util.*;

public class Main {

    static Long[] arr = new Long[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        preCheck();

        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();

        Long answer = 0L;

        for(int i=0; i<N; i++){
            char c = s.charAt(i);
            int value = c - 'a' + 1;
            answer += value * arr[i];
        }

        System.out.println(answer);
    }

    private static void preCheck(){
        Long value = 31L;

        arr[0] = 1L;
        arr[1] = 31L;
        for(int i=2; i<=50; i++){
            arr[i] = (value * arr[i-1]) % 1234567891;
        }
    }

}
