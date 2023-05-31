import java.util.Arrays;
import java.util.Scanner;

public class swea_5356_의석이의세로로말해요_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			char[][] word = new char[5][15];
			String sword;
			for(int i=0; i<5; i++) {
				sword = sc.next();
				for(int j=0; j<sword.length(); j++) {
					word[i][j] = sword.charAt(j);
				}
			}
			System.out.printf("#%d ",q);
			for(int j=0; j<15; j++) {
				for(int i=0; i<5; i++) {
					if(word[i][j]!='\u0000') System.out.printf("%c",word[i][j]);
				}
			}
			System.out.println();
		}
	}
}
