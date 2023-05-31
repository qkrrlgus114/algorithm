import java.util.Arrays;
import java.util.Scanner;

public class baek_2217_로프_실버4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int max = 0;
		for(int i=0; i<N; i++) {
			int len = N-i;
			if(len*arr[i]>max) max = len*arr[i];
		}
		System.out.println(max);
	}
}
