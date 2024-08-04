import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            String[] sa = bf.readLine().split(" ");
            int N = Integer.parseInt(sa[0]);
            long L = Long.parseLong(sa[1]);
            long W = Long.parseLong(sa[2]);
            long H = Long.parseLong(sa[3]);
            double min = L;
            min = Math.min(L, W);
            min = Math.min(min, H);

            double l = 0;
            double h = min;
            double mid;

            for(int i=0; i<1000; i++){
                mid = (l + h) / 2;

                if((long)(L/mid) * (long)(W/mid) * (long)(H/mid) < N){
                    h = mid;
                }else{
                    l = mid;
                }
            }

            System.out.println(l);
        }
    }