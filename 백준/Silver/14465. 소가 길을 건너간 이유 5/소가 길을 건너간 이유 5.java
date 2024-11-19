import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");
		int N = Integer.parseInt(sa[0]);
		int K = Integer.parseInt(sa[1]);
		int B = Integer.parseInt(sa[2]);

		boolean[] arr = new boolean[N];
		int result = 0;

		for (int i = 0; i < B; i++) {
			arr[Integer.parseInt(bf.readLine()) - 1] = true;
		}

		int tempResult = 0;
		int l = 0;
		int r = 0;
		for (r = 0; r < K; r++) {
			if (arr[r])
				tempResult++;
		}
		r--;

		result = tempResult;
		while (r < N - 1) {
			r++;
			if (arr[r])
				tempResult++;

			if (arr[l])
				tempResult--;
			l++;

			result = Math.min(result, tempResult);
		}

		System.out.println(result);

	}

}