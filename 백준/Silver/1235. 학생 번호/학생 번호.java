import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        List<String> numbers = new ArrayList<>();

        for(int i=0; i<N; i++){
            numbers.add(bf.readLine());
        }

        int length = numbers.get(0).length();
        int answer = length;

        Set<String> number = new HashSet<>();
        outer: for(int i=1; i<length; i++){
            for(int j=0; j<numbers.size(); j++){
                String num = numbers.get(j);

                if(!number.add(num.substring(i, length))){
                    break outer;
                }
            }
            answer = length - i;
            number.clear();
        }

        System.out.println(answer);

    }
}