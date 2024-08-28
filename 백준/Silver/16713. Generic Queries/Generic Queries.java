import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] ori = new int[N + 1];
        int[] prefix = new int[N + 1];

        sa = bf.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            ori[i + 1] = Integer.parseInt(sa[i]);
        }

        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] ^ ori[i];
        }

        int result = 0;

        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);

            result ^= prefix[end] ^ prefix[start - 1];
        }

        System.out.println(result);
    }
}
