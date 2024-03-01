import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int T = Integer.parseInt(input);

        for(int t=0; t<T; t++){
            String[] inputs = br.readLine().split(" ");
            int count = 0;

            for(int i=1; i<inputs.length; i++){
                for(int j=1; j < i; j++){
                    if(Integer.parseInt(inputs[j]) > Integer.parseInt(inputs[i])){
                        count++;
                    }
                }
            }
            System.out.println(inputs[0] + " " + count);
        }
    }


}
