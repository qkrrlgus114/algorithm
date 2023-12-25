import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for (int i = N; i >= 1; i--) {
            s2.push(i);
        }

        StringBuilder sb = new StringBuilder();
        boolean check = false;

        while(!s1.isEmpty() || !s2.isEmpty()){
            s = bf.readLine();
            int M = Integer.parseInt(s);

            while(true){
                if(!s1.isEmpty() && s1.peek() == M){
                    sb.append("-\n");
                    s1.pop();
                    break;
                } else if (s2.isEmpty() && s1.peek() != M) {
                    System.out.println("NO");
                    s1.clear();
                    s2.clear();
                    check = true;
                    break;
                } else if(!s2.isEmpty() && s2.peek() == M){
                    sb.append("+\n");
                    sb.append("-\n");
                    s2.pop();
                    break;
                }else if(!s2.isEmpty() && s2.peek() > M){
                    System.out.println("NO");
                    s1.clear();
                    s2.clear();
                    check = true;
                    break;
                }else if(!s2.isEmpty() && s2.peek() < M){
                    s1.push(s2.pop());
                    sb.append("+\n");
                }
            }
        }

        if(!check){
            System.out.println(sb.toString());
        }
    }
}