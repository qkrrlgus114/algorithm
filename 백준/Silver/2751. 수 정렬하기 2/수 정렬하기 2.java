import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InterfaceAddress;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        Integer[] arr = new Integer[Integer.parseInt(s)];
        for(int i=0; i<arr.length; i++){
            s = bf.readLine();
            arr[i] = Integer.parseInt(s);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(Integer i : arr){
            sb.append(i).append("\n");
        }

        System.out.println(sb);

    }
}
