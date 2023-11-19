import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        boolean check = false;

        for (int i = 0; i < str.length(); i++) {
            char word = str.charAt(i);
            if (word == 'X') {
                count++;
                if (count == 4) {
                    sb.append("AAAA");
                    count = 0;
                }
            } else if (word == '.') {
                if (count == 4) {
                    sb.append("AAAA");
                    count = 0;
                } else if (count == 2) {
                    sb.append("BB");
                    count = 0;
                } else if (count != 0){
                    System.out.println(-1);
                    check = true;
                    break;
                }
                sb.append(".");
            }
        }

        if(count == 2){
            sb.append("BB");
            System.out.println(sb.toString());
        }else if (!check && count != 0){
            System.out.println(-1);
        }else if (!check){
            System.out.println(sb.toString());
        }


    }

}