import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);


        // 1부터 증가하는 수
        int value = 1;
        // 현재까지 나온 666시리즈 개수
        int curSixCount = 0;

        while(true){
            // 6의 개수
            int sixCount = 0;
            char[] temp = String.valueOf(value).toCharArray();

            for(int i=0; i<temp.length; i++){
                if(temp[i] == '6'){
                    sixCount++;
                    if(sixCount == 3){
                        break;
                    }
                }else{
                    sixCount = 0;
                }
            }

            if(sixCount == 3){
                curSixCount++;
                if(curSixCount == N){
                    System.out.println(value);
                    break;
                }
            }
            value++;
        }

    }
}