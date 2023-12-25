import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int start = 1;
        int end = 1;
        int count = 1;
        int sum = 1;

        while(end != N){

            if(sum > N){
                sum -= start;
                start++;
            }else if(sum < N){
                end++;
                sum += end;
            }else{
                end++;
                sum += end;
                count++;
            }
        }

        System.out.println(count);

    }
}