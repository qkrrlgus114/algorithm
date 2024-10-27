
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");
		int N = Integer.parseInt(sa[0]);
		int K = Integer.parseInt(sa[1]);

		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(bf.readLine());
		}

		int coinCnt = 0;
		int curCoin = 0;
		for (int i = N - 1; i >= 0; i--) {
			int coin = coins[i];

			if(coin > K - curCoin) continue;

			int a = (K - curCoin) / coin;
			coinCnt += a;
			curCoin = curCoin + (coin * a);
		}

		System.out.println(coinCnt);

	}
}
