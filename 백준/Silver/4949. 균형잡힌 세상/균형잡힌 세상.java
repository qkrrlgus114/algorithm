import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String s = bf.readLine();
            if(".".equals(s)) break;
            String[] sa = s.split(" ");
            boolean check = true;
            Stack<Character> stack = new Stack<>();
            outer: for(int i=0; i<sa.length; i++){
                char[] c = sa[i].toCharArray();
                for(int j=0; j<c.length; j++){
                    if(c[j] == '[') stack.add(c[j]);
                    else if(c[j] == '(') stack.add(c[j]);
                    else if(c[j] == ')') {
                        if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                        else {
                            sb.append("no").append("\n");
                            check = false;
                            break outer;
                        }
                    }else if(c[j] == ']') {
                        if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                        else {
                            sb.append("no").append("\n");
                            check = false;
                            break outer;
                        }
                    }
                }
            }
            if(check && stack.isEmpty()) sb.append("yes").append("\n");
            else if(check && !stack.isEmpty()) sb.append("no").append("\n");
        }

        System.out.println(sb);


    }
}