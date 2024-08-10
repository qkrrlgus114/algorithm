import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int[] remainMoneys = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int money = 1000 - n;
        int answer = cal(money);

        System.out.println(answer);
    }

    public static int cal(int money){
        int answer = 0; // 잔돈의 매수
        for(int remainMoney : remainMoneys){
            answer += money / remainMoney;
            money %= remainMoney;
        }

        return answer;
    }
}