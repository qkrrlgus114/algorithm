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
            String[] si = bf.readLine().split(" ");
            int H = Integer.parseInt(si[0]);
            int W = Integer.parseInt(si[1]);
            int M = Integer.parseInt(si[2]);

            outer: for(int j=1; j<=W; j++){
                for(int i=1; i<=H; i++){
                    M--;
                    if(M == 0){
                        if(j < 10){
                            sb.append(i).append(0).append(j);
                        }else{
                            sb.append(i).append(j);
                        }
                        break outer;
                    }
                }
            }

            System.out.println(sb);
        }


    }
}
