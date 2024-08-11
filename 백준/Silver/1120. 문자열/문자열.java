import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * A와 B를 같게 만들었을 때 차이를 계산해야함.
     * A의 앞이나 뒤에 알파벳을 추가할 수 있음. -> 최소한의 차이를 만들어야 한다.
     * 만약에 A가 B에 포함되어있다면 -> 0이 정답이 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        String A = sa[0];
        String B = sa[1];

        int length = Integer.MAX_VALUE;
        for (int i = 0; i <= B.length() - A.length(); i++) {
            String temp = B.substring(i, A.length() + i);
            int tempLength = 0;
            for (int j = 0; j < A.length(); j++) {
                if(temp.charAt(j) != A.charAt(j)) tempLength++;
            }
            if(length > tempLength) length = tempLength;
        }

        System.out.println(length);
    }
}