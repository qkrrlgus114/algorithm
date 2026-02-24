import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] waiting = new int[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) waiting[i] = Integer.parseInt(sa[i]);

        boolean[] isFriend = new boolean[N + 1];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < M; i++) isFriend[Integer.parseInt(sa[i])] = true;

        int answer = 0;
        for (int i = 0; i < M; i++) {
            if (!isFriend[waiting[i]]) answer++;
        }

        System.out.println(answer);
    }


}