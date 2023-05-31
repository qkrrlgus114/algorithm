import java.util.Arrays;
import java.util.Scanner;

public class baek_2563색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int papercount = sc.nextInt();
		int count = 0;
		int[][] map = new int[100][100];
		for(int i=0; i<papercount; i++) {
			int q = sc.nextInt();
			int w = sc.nextInt();
			count = 0;
			for(int j=100-w; j>100-w-10; j--) {
				for(int k=0+q; 0+q+10>k; k++){
					map[j][k] = 1;
				}
			}
		}
		for(int j=0; j<100; j++) {
			for(int k=0; k<100; k++) {
				if(map[j][k] != 0)
					count++;
			}
		}
		System.out.println(count);
	}
}
