import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Word implements Comparable<Word> {
    char[] word_char;
    int value;

    Word(char[] word_char, int value){
        this.word_char = word_char;
        this.value = value;
    }

    @Override
    public int compareTo(Word o) {
        if (value == o.value) {
            String thisWord = new String(word_char).trim(); // char[]를 String으로 변환
            String otherWord = new String(o.word_char).trim(); // char[]를 String으로 변환
            return thisWord.compareTo(otherWord); // String의 compareTo 메소드 사용
        }
        return value - o.value;
    }
}

public class Main {
    static List<Word> word_list;
    static char[][] keyboard = {{'q','w','e','r','t','y','u','i','o','p'}, {'a','s','d','f','g','h','j','k','l', ' '}, {'z','x','c','v','b','n','m',' ',' ',' '}};
    static char[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String t = bf.readLine();
        int T = Integer.parseInt(t);

        for(int l=0; l<T; l++){
            word_list = new ArrayList<>();
            String[] sa = bf.readLine().split(" ");
            target = new char[sa[0].length()];
            char[] temp = sa[0].toCharArray();
            for(int i=0; i<sa[0].length(); i++){
                target[i] = temp[i];
            }

            int word_count = Integer.parseInt(sa[1]);

            for(int i=0; i<word_count; i++){
                String s = bf.readLine();
                temp = s.toCharArray();
                int result = 0;
                for(int j=0; j<sa[0].length(); j++){
                    int search = search(target[j], temp[j]);
                    result += search;
                }
                Word word = new Word(temp, result);
                word_list.add(word);
            }
            Collections.sort(word_list);

            for(int i=0; i<word_list.size(); i++){
                StringBuilder sb = new StringBuilder();
                int len = word_list.get(i).word_char.length;
                for(int j=0; j<len; j++){
                    sb.append(word_list.get(i).word_char[j]);
                }
                sb.append(" ").append(word_list.get(i).value).append("\n");
                System.out.print(sb.toString());
            }
        }

    }

    // (목표, 현재)
    public static int search(char N, char M){
        int N_x = 0;
        int N_y = 0;
        int M_x = 0;
        int M_y = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<10; j++){
                if(keyboard[i][j] == N){
                    N_x = j;
                    N_y = i;
                }
                if(keyboard[i][j] == M){
                    M_x = j;
                    M_y = i;
                }
            }
        }
        return Math.abs(N_x - M_x) + Math.abs(M_y - N_y);
    }
}