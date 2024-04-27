import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static boolean[] sosu;
    static List<Integer> sosuList = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        N = Integer.parseInt(s);

        sosu = new boolean[N+1];
        Arrays.fill(sosu, true);

        checkSosu();

        int l = 0;
        int r = 0;
        int answer = 0;
        int sum = 0;
        if(sosuList.size() > 0){
            sum = sosuList.get(r);
        }

        while(sosuList.size() > 0 && (l != sosuList.size() - 1 || r != sosuList.size() - 1)){
            if(sum < N){
                r++;
                sum += sosuList.get(r);
            }else if(sum > N){
                l++;
                sum -= sosuList.get(l - 1);
            }else if(sum == N){
                answer++;
                l++;
                sum -= sosuList.get(l - 1);
            }
        }
        if(sosuList.size() > 0 ){
            if((sosuList.size() > 1 && sum - sosuList.get(l-1) == N) || sum == N) answer++;
        }

        System.out.println(answer);

    }

    public static void checkSosu(){
        sosu[0] = sosu[1] = false;

        for(int i=2; i<=Math.sqrt(N); i++){
            if(!sosu[i]) continue;
            for(int j=i*i; j<=N; j+=i){
                sosu[j] = false;
            }
        }

        for(int i=0; i<=N; i++){
            if(sosu[i]) sosuList.add(i);
        }
    }
}

