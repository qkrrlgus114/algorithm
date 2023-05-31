import java.util.Arrays;
import java.util.Scanner;

public class baek_3085_사탕게임_실버2 {
	static int max = Integer.MIN_VALUE;
	static int count = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][N];
		for(int i=0; i<map.length; i++) {
			String str = sc.next();
			for(int j=0; j<map.length; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 가로부터 바꿔보자.
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length-1; j++) {
				if(map[i][j]!=map[i][j+1]) {
					char temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
					
					arrCheck(map);
					
					temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
				}
			}
		}
		
		// 세로를 바꿔보자
		for(int j=0; j<map.length; j++) {
			for(int i=0; i<map.length-1; i++) {
				if(map[i][j]!=map[i+1][j]) {
					char temp = map[i][j];
					map[i][j] = map[i+1][j];
					map[i+1][j] = temp;
					
					arrCheck(map);
					
					temp = map[i][j];
					map[i][j] = map[i+1][j];
					map[i+1][j] = temp;
				}
			}
		}
		System.out.println(max);
	}
	
	public static void arrCheck(char[][] map) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length-1; j++) {
				if(map[i][j]==map[i][j+1]) {
					count++;
				}else {
					count=1;
				}
				if(max<count) max = count;
			}
			count=1;
		}
		
		for(int j=0; j<map.length; j++) {
			for(int i=0; i<map.length-1; i++) {
				if(map[i][j] == map[i+1][j]) {
					count++;
				}else {
					count=1;
				}
				if(max<count) max = count;
			}
			count=1;
		}
	}
}
