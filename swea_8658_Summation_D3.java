import java.util.Scanner;

public class swea_8658_Summation_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int i=0; i<10; i++) {
				char[] num = new char[7];
				int sum = 0;
				String nums = sc.next();
				for(int j=0; j<nums.length(); j++) {
					num[j] = nums.charAt(j);
					sum += num[j]-'0';
				}
				if(sum>max) max = sum;
				if(sum<min) min = sum;
			}
			System.out.printf("#%d %d %d\n",tc,max,min);
		}
	}
}
