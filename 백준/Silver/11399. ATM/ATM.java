
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		String[] sa = bf.readLine().split(" ");

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sa[i]);
		}

		Arrays.sort(arr);

		int sum = 0;
		int result = 0;

		for(int i=0; i<N; i++){
			sum += arr[i];
			result += sum;
		}

		System.out.println(result);

	}
}