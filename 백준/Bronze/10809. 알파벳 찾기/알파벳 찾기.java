import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] alpha = bf.readLine().toCharArray();
        int[] count = new int[26];
        for(int i=0; i<count.length; i++){
            count[i] = -1;
        }

        for(int i=0; i<alpha.length; i++){
            if(count[alpha[i] - 97] == -1){
                count[alpha[i] - 97] = i;
            }
        }

        for(int i=0; i<count.length; i++){
            System.out.print(count[i]+" ");
        }
    }
}