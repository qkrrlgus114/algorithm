import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        List<String> baekjoons = new ArrayList<>();
        List<String> problems = new ArrayList<>();

        for(int i=0; i<N; i++){
            String s = bf.readLine();

            if(s.startsWith("boj.kr/")) baekjoons.add(s);
            else problems.add(s);
        }

        // 문제 정렬
        Collections.sort(problems, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        Collections.sort(baekjoons, new Comparator<String>() {
            public int compare(String o1, String o2) {
                int num1 = Integer.parseInt(o1.substring(7));
                int num2 = Integer.parseInt(o2.substring(7));
                return num1 - num2;
            }
        });

        StringJoiner sj = new StringJoiner("\n");
        for(String s : problems) sj.add(s);
        for(String s : baekjoons) sj.add(s);

        System.out.println(sj);
    }
}


