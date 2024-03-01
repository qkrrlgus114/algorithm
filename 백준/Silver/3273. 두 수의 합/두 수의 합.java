import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);
        int[] arr = new int[N];
        boolean[] check = new boolean[1000001];
        int count = 0;

        String[] s1 = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s1[i]);
            check[Integer.parseInt(s1[i])] = true;
        }

        s = bf.readLine();
        int T = Integer.parseInt(s);

        for(int i=0; i<N; i++){
            int target = T - arr[i];
            if(target >= 1 && target <= 1000000){
                count += check[target] ? 1 : 0;
            }
        }

        System.out.println(count / 2);
    }


}
