import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static int[] positions;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        C = Integer.parseInt(sa[1]);

        positions = new int[N];

        for(int i=0; i<N; i++){
            positions[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(positions);

        binarySearch(1, 1000000000);
        System.out.println(result);
    }

    public static void binarySearch(int l, int r){
        while(l <= r){
            // 공유기 설치 개수
            int count = 0;
            int mid = (l + r) / 2;
            // 이전 설치 좌표
            int position = 0;

            for(int i=0; i<N; i++){
                // 공유기를 전부 채웠으면 종료
                if(count == C) break;

                if(position == 0){
                    count++;
                    position = positions[i];
                }else{
                    if(positions[i] - position >= mid){
                        count++;
                        position = positions[i];
                    }
                }
            }

            if(C == count){
                result = Math.max(result, mid);
                l = mid + 1;
            }else if(C > count){
                r = mid - 1;
            }
        }
    }

}
