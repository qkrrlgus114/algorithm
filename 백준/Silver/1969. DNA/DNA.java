import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int resultCount = 0;

        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = bf.readLine();
        }

        for(int i=0; i<M; i++){
            int[] result = new int[4];
            for(int j=0; j<N; j++){
                char c = arr[j].charAt(i);
                if(c == 'A'){
                    result[0]++;
                }else if(c == 'C'){
                    result[1]++;
                }else if(c == 'G'){
                    result[2]++;
                }else{
                    result[3]++;
                }
            }
            int index = 0;
            int max = 0;
            for(int j=0; j<4; j++){
                if (max < result[j]){
                    index = j;
                    max = result[j];
                }
            }

            if(index == 0){
                sb.append('A');
            }else if(index == 1){
                sb.append('C');
            }else if(index == 2){
                sb.append('G');
            }else {
                sb.append('T');
            }
        }

        System.out.println(sb.toString());
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(sb.charAt(j) != arr[i].charAt(j)){
                    resultCount++;
                }
            }
        }
        System.out.println(resultCount);
    }
}