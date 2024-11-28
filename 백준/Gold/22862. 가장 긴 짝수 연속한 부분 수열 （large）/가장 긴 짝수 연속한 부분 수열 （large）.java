import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int S, K = 0;
		String[] sa = bf.readLine().split(" ");
		S = Integer.parseInt(sa[0]);
		K = Integer.parseInt(sa[1]);

		int l = 0;
		int r = 0;
		int evenCnt = 0;
		int result = 0;

		int[] arr = new int[S];
		sa = bf.readLine().split(" ");
		for (int i = 0; i < S; i++) {
			arr[i] = Integer.parseInt(sa[i]);
		}

		while (r < S) {
			if (arr[r] % 2 == 0) {
				evenCnt++;
				r++;
				result = Math.max(result, evenCnt);
			} else {
				if (K == 0) {
					while (l < r) {
						if (arr[l] % 2 == 0) {
							evenCnt--;
							l++;
						} else {
							K++;
							l++;
							break;
						}
					}
				} else {
					K--;
					r++;
				}
			}
		}

		System.out.println(result);

	}

}