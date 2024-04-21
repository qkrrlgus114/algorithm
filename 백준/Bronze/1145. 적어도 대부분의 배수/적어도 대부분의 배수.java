import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int[] arr = new int[5];
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        int answer = 1;

        while(true){
            int count = 0;
            for(int i=0; i<5; i++){
                if(answer % arr[i] == 0) count++;
            }

            if(count >= 3){
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }
}