import java.util.Arrays;
import java.util.Scanner;

public class baek_2775_부녀회장_브론즈1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[] house = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
			for(int i=1; i<=k; i++) {
				for(int j=1; j<n; j++) {
					house[j] = house[j]+house[j-1];
				}
			}
			System.out.println(house[n-1]);
		}
	}
}
