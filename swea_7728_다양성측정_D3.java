import java.util.Arrays;
import java.util.Scanner;

public class swea_7728_다양성측정_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			String num = sc.next();
			char[] arr = new char[num.length()];
			int[] count = new int[10];
			for(int i=0; i<arr.length; i++) {
				arr[i] = num.charAt(i);
				count[arr[i]-'0']++;
			}
			int cnt = 0;
			for(int i=0; i<10; i++) {
				if(count[i]>=1) cnt++;
			}
			
			System.out.printf("#%d %d\n",tc,cnt);
		}
	}
}
