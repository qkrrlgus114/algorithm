import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        /*
        * N개의 기타줄이 끊어짐
        * 6개가 세트로 팔거나 낱개로 사야함.
        * 6이하면 6개의 가격과 낱개의 가격을 비교하면 됨.
        * 7이상이면 (N/6)+1의 세트 가격과 낱개가격 * N을 비교하면 됨.
        * min 값 갱신하면서 for문으로 비교.
        * */

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int answer = Integer.MAX_VALUE;

        int[] setPrice = new int[M];
        int[] singlePrice = new int[M];
        for(int i=0; i<M; i++){
            str = bf.readLine().split(" ");
            setPrice[i] = Integer.parseInt(str[0]);
            singlePrice[i] = Integer.parseInt(str[1]);
            }
        Arrays.sort(setPrice);
        Arrays.sort(singlePrice);

        int min = Math.min(((N/6) + 1) * setPrice[0], singlePrice[0] * N);
        min = Math.min(min, ((N/6) * setPrice[0]) + (N % 6) * singlePrice[0]);
        System.out.println(min);
    }

    }