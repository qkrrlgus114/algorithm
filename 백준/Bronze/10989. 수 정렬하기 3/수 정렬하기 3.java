import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(s);
        int[] arr = new int[10001];

        for(int i=0; i<N; i++){
            s = bf.readLine();
            arr[Integer.parseInt(s)]++;
        }

        for(int i=0; i<10001; i++){
            while(arr[i] != 0){
                sb.append(i).append("\n");
                arr[i]--;
            }
        }
        System.out.println(sb);

    }


}
