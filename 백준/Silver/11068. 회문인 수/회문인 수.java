import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int T = Integer.parseInt(s);

        for(int t=0; t<T; t++){
            StringBuilder sb = new StringBuilder();
            s = bf.readLine();
            boolean check = false;
            int N = Integer.parseInt(s);
            sb.append(N);
            if(s.contentEquals(sb.reverse())){
                check = true;
            }else{
                for(int i=2; i<=64; i++){
                    sb.setLength(0);
                    String s1 = binaryChange(N, i);
                    sb.append(s1);
                    if(s1.contentEquals(sb.reverse())) {
                        check = true;
                        break;
                    }
                }
            }
            System.out.println(check ? 1 : 0);
        }

    }

    public static String binaryChange(int N, int M){
        String result = "";
        while(N != 0){
            int temp = N % M;
            N /= M;
            if(temp < 10) result += temp;
            else result += (char)(temp - 10 + 'A');
        }

        return result;
    }


}
