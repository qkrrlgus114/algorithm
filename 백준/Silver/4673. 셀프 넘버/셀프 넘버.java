import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		boolean[] visitor = new boolean[10001];

		for (int i = 1; i <= 10000; i++) {
			String numStr = String.valueOf(i);
			char[] arr = numStr.toCharArray();
			int sum = i + calculatorLoop(arr);

			if (sum > 10000)
				continue;
			visitor[sum] = true;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10000; i++) {
			if (!visitor[i])
				sb.append(i).append("\n");
		}

		System.out.println(sb);
	}

	private static int calculatorLoop(char[] arr) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			num += arr[i] - '0';
		}

		return num;
	}
}