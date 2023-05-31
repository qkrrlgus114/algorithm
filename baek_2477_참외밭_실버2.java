import java.util.Arrays;
import java.util.Scanner;

public class baek_2477_참외밭_실버2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] count = new int[4];
		int[] map = new int[12];
		for(int i=0; i<12; i++) {
			map[i] = sc.nextInt();
			if(i%2==0) {
				count[map[i]-1]++;			
			}
		}
		// 넓이 변수
		int width = 0;
		// 1,2의 최대
		int otmax = 0;
		// 3,4의 최대
		int tfmax = 0;
		for(int i=0; i<12; i+=2) {
			if(map[i]==1||map[i]==2) {
				if(map[i+1]>otmax) otmax = map[i+1];
			} else if(map[i]==3||map[i]==4) {
				if(map[i+1]>tfmax) tfmax = map[i+1];
			}
		}
		width = otmax*tfmax;
		// count가 2인 값의 방향을 저장
		int a=0;
		int b=0;
		for(int i=0; i<12; i++) {
			if(map[i]==otmax&&(map[i-1]==1||map[i-1]==2)) {
				 if(i!=1&&i!=11) a=Math.abs(map[i-2]-map[i+2]);
				 else if(i==1) a=Math.abs(map[3]-map[11]);
				 else if(i==11) a=Math.abs(map[9]-map[1]);
			}else if(map[i]==tfmax&&(map[i-1]==3||map[i-1]==4)) {
				 if(i!=1&&i!=11) b=Math.abs(map[i-2]-map[i+2]);
				 else if(i==1) b=Math.abs(map[3]-map[11]);
				 else if(i==11) b=Math.abs(map[9]-map[1]);
			}
		}
		width = width-(a*b);
		System.out.println(width*T);
	}
}
