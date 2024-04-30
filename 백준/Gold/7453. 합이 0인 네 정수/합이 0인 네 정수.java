import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        long[][] arr = new long[N][4];

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            arr[i][0] = Long.parseLong(sa[0]);
            arr[i][1] = Long.parseLong(sa[1]);
            arr[i][2] = Long.parseLong(sa[2]);
            arr[i][3] = Long.parseLong(sa[3]);
        }

        // A+B, C+D의 모든 경우의수를 구해서 배열로 만듦.
        // 이래야 N^2의 시간으로 해결 가능
        long[] fi = new long[N*N];
        long[] se = new long[N*N];
        int index = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                fi[index] = arr[i][0] + arr[j][1];
                se[index++] = arr[i][2] + arr[j][3];
            }
        }

        // 투포인터를 돌리기 위해 정렬
        Arrays.sort(fi);
        Arrays.sort(se);

        // 정답
        long answer = 0;
        // 포인터 위치
        int l = 0;
        int r = se.length - 1;

        while(l < fi.length && r >= 0){
            // 합 계산
            long sum = fi[l] + se[r];

            // 양수면 right--
            if(sum > 0){
                r--;
            }
            // 음수면 left++
            else if(sum < 0){
                l++;
            }
            // 같으면 현재 원소의 개수를 전부 파악해야함.
            // left 동일한 원소, right 동일한 원소를 전부 구해서 left 개수 * right 개수 계산
            else{
                long leftCount = 1;
                long rightCount = 1;
                while(l + 1 < fi.length && fi[l + 1] == fi[l]){
                    leftCount++;
                    l++;
                }
                while(r - 1 >= 0 && se[r - 1] == se[r]){
                    rightCount++;
                    r--;
                }
                answer += leftCount * rightCount;
                l++;
                r--;
            }
        }

        System.out.println(answer);
    }

}

