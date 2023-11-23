import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
* 거꾸로 계산을 진행함
* 만약에 뒤에 1이 있으면 1을 제거.
* 그리고 2로 나눠서 A가 되는지 확인
* A보다 작아지면 불가능하므로 -1이 됨.
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        Long A = Long.parseLong(s[0]);
        String B = s[1];

        int count = 1;

        while(true){
            if (A == Long.parseLong(B)){
                System.out.println(count);
                break;
            }else if (A > Long.parseLong(B)){
                System.out.println(-1);
                break;
            }

            // 만약에 끝자리가 1이면
            char temp = B.charAt(B.length() - 1);
            if(temp == '1'){
                B = B.substring(0, B.length() - 1);
                count++;
            }else if(temp == '0' || temp == '2' || temp == '4' || temp == '6' || temp == '8'){
                Long i = Long.parseLong(B);
                i = i / 2;
                B = String.valueOf(i);
                count++;
            }else{
                System.out.println(-1);
                break;
            }
        }
    }


}
