import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;

public class Main {

    static int N;
    static int K;
    static long[] line;
    static long max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);
        line = new long[N];
        for (int i = 0; i < N; i++) {
            String n = bf.readLine();
            line[i] = Long.parseLong(n);
        }

        Arrays.sort(line);

        binarySearch(1L, line[N - 1]);
        System.out.println(max);
    }

    public static void binarySearch(long start, long end) {
        if(start > end){
            return;
        }
        long mid = (start + end) / 2;

        int sum = 0;
        for (int i = 0; i < line.length; i++) {
            sum += line[i] / mid;
        }

        if (sum < K) {
            binarySearch(start, mid - 1);
        } else {
            if(max < mid) max = mid;
            binarySearch(mid + 1, end);
        }
    }
}