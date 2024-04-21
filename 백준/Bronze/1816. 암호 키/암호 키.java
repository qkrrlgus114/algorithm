import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] isPrime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        getPrime();
        String s = bf.readLine();
        int N = Integer.parseInt(s);
        for(int t=0; t<N; t++){
            s = bf.readLine();
            long num = Long.parseLong(s);
            boolean check = true;
            for(int i=2; i<isPrime.length; i++){
                if(isPrime[i] && num % i == 0){
                    check = false;
                    break;
                }
            }
            System.out.println(check ? "YES" : "NO");
        }
    }

    public static void getPrime(){
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i<Math.sqrt(1000001); i++){
            if(isPrime[i]){
                for(int j=i*i; j<1000001; j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }
}