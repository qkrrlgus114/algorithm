import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 0;
        String[] arr = new String[3];

        for(int i=0; i<3; i++){
            String s = br.readLine();
            arr[i] = s;
            boolean check = true;
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                if(c < '0' || c > '9'){
                    check = false;
                    break;
                }
            }

            if(check){
                index = i;
            }
        }

        int value = Integer.parseInt(arr[index]);
        value += 3 - index;
        if(value % 3 == 0 & value % 5 == 0) System.out.println("FizzBuzz");
        else if(value % 3 == 0) System.out.println("Fizz");
        else if(value % 5 == 0) System.out.println("Buzz");
        else System.out.println(value);
    }
}
