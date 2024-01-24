import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

class Truck implements Comparable<Truck> {
    int start; // 시작 마을
    int end; // 도착 마을
    int box; // 박스

    public Truck(int start, int end, int box) {
        this.start = start;
        this.end = end;
        this.box = box;
    }

    public int compareTo(Truck t) {
        if (end == t.end) {
            return start - t.start;
        }
        return end - t.end;
    }
}


public class Main {

    static Truck[] trucks;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int limit = Integer.parseInt(sa[1]);

        String s = bf.readLine();
        int M = Integer.parseInt(s);

        trucks = new Truck[M + 1];

        for (int i = 1; i <= M; i++) {
            sa = bf.readLine().split(" ");
            trucks[i] = new Truck(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), Integer.parseInt(sa[2]));
        }

        Arrays.sort(trucks, 1, M + 1);

        int[] weight = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            weight[i] = limit;
        }

        for (int i = 1; i <= M; i++) {
            int min = Integer.MAX_VALUE;
            int box = trucks[i].box;
            for (int j = trucks[i].start; j < trucks[i].end; j++) {
                if (weight[j] - box < 0) {
                    if (min > weight[j]) min = weight[j];
                }
            }
            if(min == Integer.MAX_VALUE) min = box;

            for (int j = trucks[i].start; j < trucks[i].end; j++) {
                weight[j] -= min;
            }
            result += min;
        }
        
        System.out.println(result);
    }

}