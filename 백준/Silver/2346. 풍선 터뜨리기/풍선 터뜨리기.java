import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);
        List<Integer> list = new ArrayList<>();

        Deque<int[]> dq = new ArrayDeque<>();
        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            dq.add(new int[]{i + 1, Integer.parseInt(sa[i])});
        }

        int[] temp = dq.pollFirst();
        int index = temp[0];
        int value = temp[1];
        list.add(index);

        while(!dq.isEmpty()){
            if(value > 0){
                for(int i=0; i<value - 1; i++){
                    dq.add(dq.pollFirst());
                }
            }else{
                for(int i=value; i<0; i++){
                    dq.addFirst(dq.pollLast());
                }
            }
            temp = dq.pollFirst();
            index = temp[0];
            value = temp[1];
            list.add(index);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : list){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }


}



