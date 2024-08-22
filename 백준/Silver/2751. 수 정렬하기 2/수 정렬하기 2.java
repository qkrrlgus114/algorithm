import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(Integer num : arr){
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
