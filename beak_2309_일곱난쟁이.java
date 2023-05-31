import java.util.Arrays;
import java.util.Scanner;

public class beak_2309_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nan = new int[9];
		int[] realnan = new int[7];
		int sum = 0;
		for(int i=0; i<9; i++) {
			nan[i] = sc.nextInt();
			sum+=nan[i];
		}
		int fake = 0;
		int ri = 0;
		int rj = 0;
		for(int i=0; i<8; i++) {
			for(int j=1; j<9; j++) {
				fake = nan[i]+nan[j];
				if(sum-fake==100) {
					ri = i;
					rj = j;
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<9; i++) {
			if(i==ri||i==rj) {
			} else {
				realnan[cnt++] = nan[i];
			}
		}
		Arrays.sort(realnan);
		for(int i=0; i<7; i++) {
			System.out.println(realnan[i]);
		}
	}
}