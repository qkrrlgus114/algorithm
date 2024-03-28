import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static String status;
    static int push_count, no_push_count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        N = Integer.parseInt(s);

        status = bf.readLine();
        List<Integer> cur_list = new ArrayList<>();
        cur_list = switchInput(cur_list);

        List<Integer> push_list = new ArrayList<>();
        push_list = switchInput(push_list);
        List<Integer> no_push_list = new ArrayList<>();
        no_push_list = switchInput(no_push_list);

        status = bf.readLine();
        List<Integer> target_list = new ArrayList<>();
        target_list = switchInput(target_list);

        push_count = 1;
        no_push_count = 0;

        switchOn(push_list, 0);

        for(int i=1; i<N; i++){
            if(check(push_list, target_list)) break;
            if(check(no_push_list, target_list)) break;

            if(push_list.get(i-1) != target_list.get(i-1)){
                switchOn(push_list, i);
                push_count++;
            }
            if(no_push_list.get(i-1) != target_list.get(i-1)){
                switchOn(no_push_list, i);
                no_push_count++;
            }
        }

        if(!check(push_list, target_list) && !check(no_push_list, target_list)) System.out.println("-1");
        else if(check(push_list, target_list) && check(no_push_list, target_list)) System.out.println(Math.min(push_count, no_push_count));
        else if(check(push_list, target_list)) System.out.println(push_count);
        else if(check(no_push_list, target_list)) System.out.println(no_push_count);
    }

    // 스위치 변경 함수
    public static void switchOn(List<Integer> list, int index){
        if(index > 0 && index < N - 1){
            for(int i=index-1; i<=index+1; i++){
                if(list.get(i) == 1) list.set(i, 0);
                else list.set(i, 1);
            }
        }else if(index == 0){
            for(int i=0; i<=1; i++){
                if(list.get(i) == 1) list.set(i, 0);
                else list.set(i, 1);
            }
        }else if(index == N-1){
            for(int i=N-2; i<=N-1; i++){
                if(list.get(i) == 1) list.set(i, 0);
                else list.set(i, 1);
            }
        }
    }

    // 스위치 입력
    public static List<Integer> switchInput(List<Integer> list){
        for(int i=0; i<status.length(); i++){
            list.add(status.charAt(i) - '0');
        }
        return list;
    }

    public static boolean check(List<Integer> input, List<Integer> target){
        for(int i=0; i<N; i++){
            if(input.get(i) != target.get(i)) return false;
        }
        return true;
    }
}


