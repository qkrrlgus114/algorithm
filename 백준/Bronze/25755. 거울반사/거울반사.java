import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        String dir = sa[0];
        int N = Integer.parseInt(sa[1]);
        String[][] arr = new String[N][N];

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                arr[i][j] = sa[j];
            }
        }
        StringBuilder sb = new StringBuilder();

        if(dir.equals("D") || dir.equals("U")){
            for(int i=N-1; i>=0; i--){
                for(int j=0; j<N; j++){
                    if(arr[i][j].equals("1")){
                        sb.append(arr[i][j]).append(" ");
                    }else if(arr[i][j].equals("2")){
                        sb.append("5").append(" ");
                    }else if(arr[i][j].equals("5")){
                        sb.append("2").append(" ");
                    }else if(arr[i][j].equals("8")){
                        sb.append("8").append(" ");
                    }else {
                        sb.append("?").append(" ");
                    }
                }
                sb.append("\n");
            }
        }else if(dir.equals("L") || dir.equals("R")){
            for(int i=0; i<N; i++){
                for(int j=N-1; j>=0; j--){
                    if(arr[i][j].equals("1")){
                        sb.append(arr[i][j]).append(" ");
                    }else if(arr[i][j].equals("2")){
                        sb.append("5").append(" ");
                    }else if(arr[i][j].equals("5")){
                        sb.append("2").append(" ");
                    }else if(arr[i][j].equals("8")){
                        sb.append("8").append(" ");
                    }else {
                        sb.append("?").append(" ");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}


