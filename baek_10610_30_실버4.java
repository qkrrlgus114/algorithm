import java.util.Arrays;
import java.util.Scanner;

public class baek_10610_30_실버4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		int[] arr = new int[num.length()];
		int sum = 0;
		for(int i=0; i<num.length(); i++) {
			arr[i] = num.charAt(i)-'0';
			sum += arr[i];
		}
		Arrays.sort(arr);
		// 모든 합이 3으로 나눠져야 3의 배수이고, 첫 자릿수가 0이어야 30의 배수를 만족
		if(sum%3==0 && arr[0]==0) {
			for(int i=arr.length-1; i>=0; i--) {
				System.out.print(arr[i]);
			}
		}else {
			System.out.println(-1);
		}
	}
}
