import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        int bird = Integer.parseInt(s[0]);
        int birdLength = Integer.parseInt(s[1]);

        s  = bf.readLine().split(" ");
        int[] fruit = new int[s.length];
        for(int i=0; i<s.length; i++){
            fruit[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(fruit);

        for(int i=0; i<fruit.length; i++){
            if (fruit[i] <= birdLength){
                birdLength += 1;
            }else{
                break;
            }
        }
        System.out.println(birdLength);
    }
}