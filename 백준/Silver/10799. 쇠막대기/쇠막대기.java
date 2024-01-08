import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> s = new Stack<>();
        char[] temp = bf.readLine().toCharArray();
        int sum = 0;

        for(int i=0; i<temp.length; i++){
            if(temp[i] == '('){
                s.push(0);
            }else{
                if(temp[i-1] == '('){
                    s.pop();
                    sum += s.size();
                }else{
                    s.pop();
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}