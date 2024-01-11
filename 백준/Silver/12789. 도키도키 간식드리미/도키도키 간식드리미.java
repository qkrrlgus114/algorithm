import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String n = bf.readLine();
        int N = Integer.parseInt(n);

        Stack<Integer> s = new Stack<>();
        String[] sa = bf.readLine().split(" ");

        int temp = 1;
        int index = 0;
        while(index < sa.length){
            if(Integer.parseInt(sa[index]) == temp){
                index++;
                temp++;
            }else if(!s.isEmpty() && s.peek() == temp){
                temp++;
                s.pop();
            }else{
                s.push(Integer.parseInt(sa[index]));
                index++;
            }
        }

        if(!s.isEmpty()){
            while(true){
                if(!s.isEmpty() && s.peek() == temp){
                    s.pop();
                    temp++;
                }else if(s.isEmpty()){
                    System.out.println("Nice");
                    break;
                }else{
                    System.out.println("Sad");
                    break;
                }
            }
        }else{
            System.out.println("Nice");
        }
    }
}