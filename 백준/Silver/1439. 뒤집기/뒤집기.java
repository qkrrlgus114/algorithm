import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;

public class Main {

    /**
     * 0과 1을 뒤집어야함.
     * 0의 그룹 개수와 1의 그룹 개수 중 가장 경우를 선택하면 됨.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int zeroCount = 0;
        int oneCount = 0;
        boolean status = false; // false면 0, true면 1을 나타냄

        String str = bf.readLine();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(i == 0){
                if(c == '1') status = true;
            }else{
                if(status && c == '0'){
                    status = false;
                    oneCount++;
                }else if(!status && c == '1'){
                    status = true;
                    zeroCount++;
                }
            }
        }

        if(status) oneCount++;
        else zeroCount++;

        System.out.println(Math.min(oneCount, zeroCount));
    }
}