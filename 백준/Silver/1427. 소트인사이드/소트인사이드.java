import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        int[] arr = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        for(int i=0; i<arr.length - 1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }


}
