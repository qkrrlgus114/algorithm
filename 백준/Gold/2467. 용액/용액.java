import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		String[] sa = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sa[i]);
		}

		int resultOne = 0;
		int resultTwo = 0;
		int resultSum = Integer.MAX_VALUE;

		int l = 0;
		int r = N - 1;

		while (l < r) {
			int one = arr[l];
			int two = arr[r];
			int sum = one + two;
			int absSum = Math.abs(sum);

			if (resultSum > absSum) {
				resultOne = one;
				resultTwo = two;
				resultSum = absSum;
			}

			if (sum > 0) {
				r--;
			} else {
				l++;
			}

		}

		int realResultOne = Math.min(resultOne, resultTwo);
		int realResultTwo = Math.max(resultOne, resultTwo);

		System.out.println(realResultOne + " " + realResultTwo);

	}

}