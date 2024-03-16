import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int P = Integer.parseInt(sa[1]);

        List<Integer>[] arr = new List[7];
        for(int i=0; i<arr.length; i++){
            arr[i] = new LinkedList<>();
        }

        int result = 0;

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            int N_num = Integer.parseInt(sa[0]);
            int P_num = Integer.parseInt(sa[1]);
            List<Integer> list = arr[N_num];

            while(true){
                // 프렛을 꺼내야 하면
                if(!list.isEmpty() && list.get(list.size() - 1) > P_num){
                    list.remove(list.remove(list.size() - 1));
                    result++;
                }else if((!list.isEmpty() && list.get(list.size() - 1) < P_num) || list.isEmpty()){
                    list.add(P_num);
                    result++;
                    break;
                }else if(!list.isEmpty() && list.get(list.size() - 1) == P_num) break;
            }
        }
        System.out.println(result);
    }
}