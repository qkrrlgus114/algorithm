import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int result = 0;
        int count = 0;

        boolean[] arr = new boolean[N+1];
        Arrays.fill(arr, true);

        outer: for(int i=2; i<=N; i++){
            if(arr[i]){
                count++;
                arr[i] = false;
                if(count == K){
                    result = i;
                    break;
                }
                for(int j=i*i; j<=N; j+=i){
                    if(!arr[j]) continue;
                    arr[j] = false;
                    count++;
                    if(count == K){
                        result = j;
                        break outer;
                    }
                }
            }

        }

        System.out.println(result);
    }


}


