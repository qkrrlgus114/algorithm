import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(s);

        for(int t=0; t<T; t++){
            char[] command = bf.readLine().toCharArray();
            List<Character> list = new LinkedList<>();
            int cursor = 0;

            for(int i=0; i<command.length; i++){
                char com = command[i];
                if(com == '<' && cursor != 0) cursor--;
                else if(com == '>' && cursor != list.size()) cursor++;
                else if(com == '-' && !list.isEmpty()){
                    // 커서가 0이면 못지움
                    if(cursor == 0) continue;
                    cursor--;
                    list.remove(cursor);
                }else if((com >= 'a' && com <= 'z') || (com >= 'A' && com <= 'Z') || (com >= '0' && com <= '9')){
                    list.add(cursor, com);
                    cursor++;
                }
            }

            for(char c : list){
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}