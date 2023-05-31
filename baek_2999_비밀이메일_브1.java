import java.util.Arrays;
import java.util.Scanner;

public class baek_2999_비밀이메일_브1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String key = sc.next();
		int N = key.length();
		int[] R = new int[100];
		int[] C = new int[100];
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(i*j==N) {
					R[cnt] = i;
					C[cnt++] = j;
				}
			}
		}
		int realR = 0;
		int realC = 0;
		cnt = 0;
		for(int i=0; i<100; i++) {
			if(R[i]<=C[i]) {
				if(R[i]>realR) {
					realR = R[i];
					realC = C[i];
					cnt=i;					
				}
			}
		}
		int count = 0;
		char[][] map = new char[R[cnt]][C[cnt]];
		for(int i=0; i<C[cnt]; i++) {
			for(int j=0; j<R[cnt]; j++) {
				map[j][i] = key.charAt(count++);
			}
		}	
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<R[cnt]; i++) {
			for(int j=0; j<C[cnt]; j++) {
				sb.append(map[i][j]);
			}
		}
		System.out.println(sb);
	}
}