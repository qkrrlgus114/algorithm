import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");
		int N = Integer.parseInt(sa[0]);
		int M = Integer.parseInt(sa[1]);

		int[] arr = new int[N];
		sa = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sa[i]);
		}

		int cnt = 0;
		int s = 0;
		int e = 0;
		int sum = 0;

		while (e <= N) {
			if (sum < M) {
				if (e < N) {
					sum += arr[e];
					e++;
				} else {
					break;
				}
			} else if (sum > M) {
				sum -= arr[s];
				s++;
			} else {
				cnt++;
				sum -= arr[s];
				s++;
			}
		}

		System.out.println(cnt);
	}

}