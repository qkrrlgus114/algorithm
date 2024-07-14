import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        parents = new int[N + 1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            int c = Integer.parseInt(sa[2]);

            if (a == 0) {
                union(b, c);
            } else {
                if(findParent(b) == findParent(c)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void union(int b, int c) {
        int px = findParent(b);
        int py = findParent(c);
        if(px != py) parents[py] = px;
    }

    private static int findParent(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findParent(parents[a]);
    }
}
