import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] card = new int[N];
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            card[i] = Integer.parseInt(sa[i]);
        }

        int result = 0;

        for(int i=0; i<card.length; i++){
            for(int j=i+1; j<card.length; j++){
                for(int k=j+1; k<card.length; k++){
                    int temp = card[i] + card[j] + card[k];
                    if(temp <= M) result = Math.max(result, temp);
                }
            }
        }

        System.out.println(result);
    }

}
