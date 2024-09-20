import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] days;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        days = new int[N];
        long max = 0;
        long maxPrice = 0;
        for(int i=0; i<N; i++){
            days[i] = Integer.parseInt(bf.readLine());
            max += days[i];
            maxPrice = Math.max(maxPrice, days[i]);
        }

        long result = binarySearch(maxPrice, max);

        System.out.println(result);
    }

    public static long binarySearch(long l, long r){
        long result = Long.MAX_VALUE;

        while(l <= r){
            long K = (l + r) / 2;
            int drawCnt = 0;
            long money = 0;

            for(int i=0; i<N; i++){
                int price = days[i];
                // 돈이 부족할 경우 무조건 통장에 넣고 K원 인출해야함.
                if(money < price){
                    money = K;
                    money -= price;
                    drawCnt++;
                }
                // 돈이 남아도는 경우
                else{
                    if(N - i == M - drawCnt){
                        money = K;
                        money -= price;
                        drawCnt++;
                    }else{
                        money -= price;
                    }
                }
            }

            if(M >= drawCnt){
                r = K - 1;
                result = Math.min(result, K);
            }else{
                l = K + 1;
            }


        }

        return result;
    }
}
