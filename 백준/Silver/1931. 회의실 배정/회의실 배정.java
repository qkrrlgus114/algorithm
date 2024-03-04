import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Cop{
    private int start;
    private int end;

    public Cop(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart(){
        return this.start;
    }

    public int getEnd(){
        return this.end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);
        int result = 0;

        List<Cop> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            list.add(new Cop(Integer.parseInt(sa[0]), Integer.parseInt(sa[1])));
        }

        Collections.sort(list, (o1, o2)->{
            // 끝나는 시간이 같으면
            if(o1.getEnd() == o2.getEnd()){
                return o1.getStart() - o2.getStart();
            }
            return o1.getEnd() - o2.getEnd();
        });

        int cur_end = 0;


        for(Cop c : list){
            if(cur_end <= c.getStart()){
                cur_end = c.getEnd();
                result++;
            }
        }

        System.out.println(result);
    }
}
