
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		long[] memo = new long[101];
		memo[1] = memo[2] = memo[3] = 1;

		for (int i = 4; i <= 100; i++) {
			memo[i] = memo[i - 2] + memo[i - 3];
		}

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(bf.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(bf.readLine());
			sb.append(memo[N]).append("\n");
		}

		System.out.println(sb);

	}

}