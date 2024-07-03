import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int t=0; t<T; t++){
            // 정답
            int answer = 1;

            int N = Integer.parseInt(bf.readLine());
            List<int[]> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                String[] sa = bf.readLine().split(" ");
                list.add(new int[]{Integer.parseInt(sa[0]), Integer.parseInt(sa[1])});
            }
            Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);

            int index = 1;
            while(true){
                if(list.get(index)[0] > list.get(index-1)[0] && list.get(index)[1] > list.get(index-1)[1]) {
                    list.remove(index);
                }else{
                    answer++;
                    index++;
                }
                if(index == list.size()) break;
            }

            System.out.println(answer);
        }
    }
    /*
    * 1 4
    * 2 5
    * 3 6
    * 4 2
    * 5 7
    * 6 1
    * 7 3*/

}
