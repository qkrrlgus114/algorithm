
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int[] memo = new int[1001];

		memo[1] = 1;
		memo[2] = 2;

		for (int i = 3; i <= 1000; i++) {
			memo[i] = (memo[i - 1] + memo[i - 2]) % 10007;
		}

		int n = Integer.parseInt(bf.readLine());

		System.out.println(memo[n]);
	}

}