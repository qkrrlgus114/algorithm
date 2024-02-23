
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        Stack<String> s = new Stack<>();

        int sum = 1;
        int result = 0;
        for(int i=0; i<input.length(); i++){
            String temp = input.substring(i, i+1);
            // 여는 괄호면
            if(temp.equals("(") || temp.equals("[")){
                s.push(temp);
                sum *= temp.equals("(") ? 2 : 3;
            }
            else{
                if(s.isEmpty()){
                    result = 0;
                    break;
                }
                else{
                    String pop = s.pop();
                    if(temp.equals(")")){
                        if(!pop.equals("(")){
                            result = 0;
                            break;
                        }else{
                            if(input.charAt(i - 1) == '(') result += sum;
                            sum /= 2;
                        }
                    }else{
                        if(!pop.equals("[")){
                            result = 0;
                            break;
                        }else{
                            if(input.charAt(i - 1) == '[') result += sum;
                            sum /= 3;
                        }
                    }
                }
            }
        }

        if(!s.isEmpty()){
            result = 0;
        }
        System.out.println(result);

    }


}
