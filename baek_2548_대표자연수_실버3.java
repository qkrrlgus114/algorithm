import java.util.Arrays;
import java.util.Scanner;

public class baek_2548_대표자연수_실버3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int sum = 0;
		int idx = N-1;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			sum = 0;
			for(int j=0; j<N; j++) {
				sum+=Math.abs(arr[i]-arr[j]);
			}
			if(min>sum) {
				min = sum;
				idx = i;
			} else if(min==sum) {
				if(arr[idx]>arr[i]) idx=i;
			}
		}
		System.out.println(arr[idx]);
	}
}
