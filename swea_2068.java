import java.util.Scanner;

public class swea_2068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int k = 1; k <= T; k++) {
			int[] num = new int[10];
			int max = 0;
			for(int i=0; i<num.length; i++) {
				num[i] = sc.nextInt();
				if(max<num[i])
					max = num[i];
			}
			System.out.printf("#%d %d\n",k,max);
		}
	}
}
