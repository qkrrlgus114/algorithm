import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String[] sa = bf.readLine().split(" ");

        Stack<int[]> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<sa.length; i++){
            int value = Integer.parseInt(sa[i]);
            if(s.isEmpty()){
                sb.append(0).append(" ");
                s.push(new int[]{value, i + 1});
            }else if(s.peek()[0] < value){
                while(!s.isEmpty()){
                    int[] temp = s.peek();
                    if(temp[0] >= value){
                        sb.append(temp[1]).append(" ");
                        s.push(new int[]{value, i + 1});
                        break;
                    }else{
                        s.pop();
                    }
                }
                if(s.isEmpty()){
                    sb.append(0).append(" ");
                    s.push(new int[]{value, i + 1});
                }
            }else if(s.peek()[0] >= value){
                sb.append(s.peek()[1]).append(" ");
                s.push(new int[]{value, i + 1});
            }
        }

        System.out.println(sb);
    }
}