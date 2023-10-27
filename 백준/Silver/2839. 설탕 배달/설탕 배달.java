import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 설탕 N킬로 배달해야함.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int sugar = Integer.parseInt(bf.readLine());

        int answer = 0;
        int namerge = 0;

        if(sugar != 4 && sugar != 7 && sugar != 3){
            answer += sugar / 5;
            namerge = sugar % 5;
            if(namerge == 0) {
                System.out.println(answer);
            }else{
                while(true){
                    if(namerge % 3 == 0){
                        answer += namerge / 3;
                        System.out.println(answer);
                        break;
                    }
                    answer -= 1;
                    namerge += 5;
                }
            }
        }else if(sugar == 4 || sugar == 7){
            System.out.println(-1);
        }else if(sugar == 3){
            System.out.println(1);
        }

    }
}