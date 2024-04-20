import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] demical = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);
        String[] sa = bf.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        getDemical();

        int count = 0;

        for(int i=0; i<N; i++){
            if(!demical[arr[i]]) count++;
        }
        System.out.println(count);

    }

    public static void getDemical(){
        demical[0] = demical[1] = true;
        for(int i=2; i < demical.length; i++){
            if(demical[i]) continue;
            for(int j=i*i; j<demical.length; j+=i){
                demical[j] = true;
            }
        }
    }
}