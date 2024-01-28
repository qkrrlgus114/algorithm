import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Long[] distance;
    static Long[] oil;
    static int N;
    static Long sum = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        N = Integer.parseInt(n);

        distance = new Long[N-1];
        oil = new Long[N];

        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N-1; i++){
            distance[i] = Long.parseLong(sa[i]);
        }

        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            oil[i] = Long.parseLong(sa[i]);
        }

        two(0, 0);
        System.out.println(sum);

    }

    public static void two(int left, int right){
        if(right == N - 1){
            for(int i=left; i<right; i++){
                sum += oil[left] * distance[i];
            }
            return;
        }

        if(oil[left] > oil[right]){
            for(int i=left; i<right; i++){
                sum += oil[left] * distance[i];
            }
            left = right;
        }

        two(left, right + 1);
    }

}
