import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int R = Integer.parseInt(sa[0]);
        int C = Integer.parseInt(sa[1]);

        char[][] arr = new char[R][C];

        for(int i=0; i<R; i++){
            char[] temp = bf.readLine().toCharArray();
            for(int j=0; j<C; j++){
                arr[i][j] = temp[j];
            }
        }

        // 정답
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        String[] str = new String[C];

        for(int i=0; i<C; i++){
            for(int j=0; j<R; j++){
                sb.append(arr[j][i]);
            }
            str[i] = sb.toString();
            sb.setLength(0);
        }

        Arrays.sort(str);
        boolean check = true;

        for(int i=1; i<R; i++){
            for(int j=0; j<C; j++){
                str[j] = str[j].substring(1, str[j].length());
            }
            Arrays.sort(str);

            for(int j=0; j<C; j++){
                String word = str[j];

                if(j == 0){
                    if(word.equals(str[j+1])){
                        check = false;
                        break;
                    }
                }else if(j == C - 1){
                    if(word.equals(str[j-1])){
                        check = false;
                        break;
                    }
                }else if(j != 0 && j != C-1){
                    if(word.equals(str[j+1])){
                        check = false;
                        break;
                    }
                    if(word.equals(str[j-1])){
                        check = false;
                        break;
                    }
                }
            }

            if(check) answer++;
            else break;
        }

        System.out.println(answer);
    }
}

