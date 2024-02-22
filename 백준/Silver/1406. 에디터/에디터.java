
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = bf.readLine();

        // 왼쪽 단어
        Stack<Character> left = new Stack<>();
        // 오른쪽 단어
        Stack<Character> right = new Stack<>();

        for(int i=0; i<word.length(); i++){
            left.push(word.charAt(i));
        }

        String m = bf.readLine();
        int M = Integer.parseInt(m);

        for(int i=0; i<M; i++){
            String[] inputs = bf.readLine().split(" ");

            // 왼쪽
            if(inputs[0].equals("L")){
                if(left.isEmpty()) continue;
                right.push(left.pop());
            }
            // 오른쪽
            else if(inputs[0].equals("D")){
                if(right.isEmpty()) continue;
                left.push(right.pop());
            }
            // 삭제
            else if(inputs[0].equals("B")){
                if(left.isEmpty()) continue;
                left.pop();
            }
            // 추가
            else{
                char add_word = inputs[1].charAt(0);
                left.push(add_word);
            }
        }

        for(char c : left){
            sb.append(c);
        }
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);

    }
}
