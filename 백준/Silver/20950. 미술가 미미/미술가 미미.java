import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Mulgam> mulgamList = new ArrayList<>();
    static int N;
    static int answer = Integer.MAX_VALUE;
    static Mulgam gomduri;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            mulgamList.add(new Mulgam(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), Integer.parseInt(sa[2])));
        }
        String[] sa = bf.readLine().split(" ");
        gomduri = new Mulgam(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), Integer.parseInt(sa[2]));

        combination(0, 0);

        System.out.println(answer);

    }

    public static void combination(int depth, int choice) {
        if (choice >= 2 && choice <= 7) {
            int R = 0;
            int G = 0;
            int B = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    R += mulgamList.get(i).R;
                    G += mulgamList.get(i).G;
                    B += mulgamList.get(i).B;
                }
            }
            R /= choice;
            G /= choice;
            B /= choice;

            int sum = Math.abs(gomduri.R - R) + Math.abs(gomduri.G - G) + Math.abs(gomduri.B - B);
            answer = Math.min(answer, sum);

            if (choice == 7) return;
        }


        for (int i = depth; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            combination(i, choice + 1);
            visited[i] = false;
        }
    }


}

class Mulgam {
    int R;
    int G;
    int B;

    public Mulgam(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }
}

