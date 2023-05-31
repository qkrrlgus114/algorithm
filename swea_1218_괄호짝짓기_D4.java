import java.util.Arrays;
import java.util.Scanner;

public class swea_1218_괄호짝짓기_D4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int q = 1; q <= 10; q++) {
			int N = sc.nextInt();
			String map = sc.next();
			int[] count = new int[8];
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				switch (map.charAt(i)) {
				case 123:
					count[0]++;
					break;
				case 91:
					count[2]++;
					break;
				case 40:
					count[4]++;
					break;
				case 60:
					count[6]++;
					break;
				case 62:
					count[7]++;
					break;
				case 41:
					count[5]++;
					break;
				case 93:
					count[3]++;
					break;
				case 125:
					count[1]++;
					break;
				}
			}
			for(int i=1; i<8; i+=2) {
				if(count[i]!=count[i-1]) {
					flag=false;
					break;
				}
			}
			if(flag==false) System.out.printf("#%d %d\n",q,0);
			else System.out.printf("#%d %d\n",q,1);
		}
	}
}
