import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* add -> x 추가, 이미 있으면 무시
* remove -> x 제거, 없으면 무시
* check -> x 있으면 1, 없으면 0
* toggle -> x 있으면 x 제거, 없으면 x 추가
* all -> S를 1 ~ 20으로 바꾼다
* empty -> S를 공집합으로 변경
 */

public class Main {

    static int[] arr = new int[21];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            String command = sa[0];
            int x = 0;
            if(!command.equals("all") && !command.equals("empty")){
                x = Integer.parseInt(sa[1]);
            }

            check(command, x);
        }

        System.out.println(sb);

    }

    private static void check(String command, int x){
        if(command.equals("add")){
            arr[x] = 1;
        }else if(command.equals("remove")){
            arr[x] = 0;
        }else if(command.equals("check")){
            if(arr[x] == 1) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }else if(command.equals("toggle")){
            if(arr[x] == 1) arr[x] = 0;
            else arr[x] = 1;
        }else if(command.equals("all")){
            Arrays.fill(arr, 1);
        }else if(command.equals("empty")){
            Arrays.fill(arr, 0);
        }
    }
}