import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // A C G T
    static int[] check = new int[4];
    static int[] count = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int S = Integer.parseInt(sa[0]);
        int P = Integer.parseInt(sa[1]);

        String word = bf.readLine();
        char[] sequence = word.toCharArray();

        sa = bf.readLine().split(" ");
        for(int i=0; i<4; i++){
            if(i==0) check[i] = Integer.parseInt(sa[i]);
            else if(i==1) check[i] = Integer.parseInt(sa[i]);
            else if(i==2) check[i] = Integer.parseInt(sa[i]);
            else if(i==3) check[i] = Integer.parseInt(sa[i]);
        }

        int result = 0;
        // 현재 비밀번호의 시퀀스
        count = new int[4];
        // 초기 비밀번호 설정
        for(int i=0; i <= P-1; i++){
            if(sequence[i] == 'A') count[0]++;
            else if(sequence[i] == 'C') count[1]++;
            else if(sequence[i] == 'G') count[2]++;
            else if(sequence[i] == 'T') count[3]++;
        }
        // 조건에 맞는지 확인
        if(successPassword(count)){
            result++;
        }
        // 앞자리 하나 삭제
        if(sequence[0] == 'A') count[0]--;
        else if(sequence[0] == 'C') count[1]--;
        else if(sequence[0] == 'G') count[2]--;
        else if(sequence[0] == 'T') count[3]--;

        // 모든 경우의 수 탐색
        for(int i=1; i<=S-P; i++){
            // 마지막 값 더해줌
            if(sequence[i+P-1] == 'A') count[0]++;
            else if(sequence[i+P-1] == 'C') count[1]++;
            else if(sequence[i+P-1] == 'G') count[2]++;
            else if(sequence[i+P-1] == 'T') count[3]++;

            if(successPassword(count)){
                result++;
            }

            // 앞자리 하나 삭제
            if(sequence[i] == 'A') count[0]--;
            else if(sequence[i] == 'C') count[1]--;
            else if(sequence[i] == 'G') count[2]--;
            else if(sequence[i] == 'T') count[3]--;
        }

        System.out.println(result);
    }

    public static boolean successPassword(int[] count){
        if(count[0] >= check[0] && count[1] >= check[1] &&
                count[2] >= check[2] && count[3] >= check[3]) return true;
        return false;
    }

}