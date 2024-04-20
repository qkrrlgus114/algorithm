import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    * 1. 산술 평균 = N개의 합을 N으로 나눈 값
    * 2. 중앙값 = N개를 증가하는 순으로 두었을 때 중앙 값
    * 3. 최빈값 = N개의 수 중 가장 많이 나타나는 값
    * 4. 범위 = N개의 수 중 최소, 최대의 차이
    * */

    static int numSum = 0;
    static int[] centerArr;
    static int[] countArr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);
        centerArr = new int[N];
        countArr = new int[8002];

        for(int t=0; t<N; t++){
            s = bf.readLine();
            int num = Integer.parseInt(s);

            numSum += num;
            max = Math.max(num, max);
            min = Math.min(num, min);
            centerArr[t] = num;
            countArr[4000 + num]++;
        }

        Arrays.sort(centerArr);

        System.out.println((int) Math.round((double) numSum / N));
        System.out.println(centerArr[N/2]);

        List<Integer> list = new ArrayList<>();
        int maxCount = 0;
        for(int i=0; i<countArr.length; i++){
            if(countArr[i] > maxCount){
                maxCount = countArr[i];
                list.clear();
                list.add(i - 4000);
            }else if(countArr[i] == maxCount){
                list.add(i - 4000);
            }
        }
        Collections.sort(list);

        System.out.println(list.size() > 1 ? list.get(1) : list.get(0));
        System.out.println(max - min);


    }

}