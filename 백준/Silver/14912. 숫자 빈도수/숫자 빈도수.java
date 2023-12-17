
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int result = 0;

        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);

        for(int i=1; i<=n; i++){
            String temp = String.valueOf(i);
            char[] arr = temp.toCharArray();
            for(int j=0; j<arr.length; j++){
                if ((arr[j] - 48) == d){
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
