import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String n = bf.readLine();
        int N = Integer.parseInt(n);

        for(int q=0; q<N; q++){
            Stack<Integer> s = new Stack<>();
            char[] temp = bf.readLine().toCharArray();
            boolean check = false;
            for(int i=0; i<temp.length; i++){
                if(temp[i] == '('){
                    s.push(0);
                }else{
                    if(s.isEmpty()){
                        System.out.println("NO");
                        check = true;
                        break;
                    }else{
                        s.pop();
                    }
                }
            }
            if(!check){
                if(s.isEmpty()){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}