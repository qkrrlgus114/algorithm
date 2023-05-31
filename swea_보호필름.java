import java.util.Arrays;
import java.util.Scanner;

public class swea_보호필름 {
	static int[][] map;
	static int[] copy;
	static int[] A; // 0인 배열
	static int[] B; // 1인 배열
	static int D;
	static int W;
	static int K;
	static int min;
	static int minin;
	static int count;
	static int cnt;
	static boolean flag = true;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			cnt = 0;
			count = 0;
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			A = new int[W];
			B = new int[W];
			for(int i=0; i<W; i++) {
				B[i] = 1;
			}
			min = K;
			minin = Integer.MAX_VALUE;
			map = new int[D][W];
			for(int i=0; i<D; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			injection(0, 0);
			System.out.println(minin);
			
		}
	}
	
	public static void injection(int idx, int input) {
		cnt++;
		if(search(idx)) {
			if(cnt==1) {
				minin = 0;
			}
			return;
		}
		if(idx == D) {
			return;
		}
		if(input==min) {
			if(minin>input) {
				minin = input;
			}
		}
		
		// 재귀 조건
		copy = new int[W];
		for(int i=0; i<W; i++) {
			copy[i] = map[idx][i];
		}
		//안넣었을 때
		injection(idx+1, input);
		
		//A 주입
		map[idx] = A;
//		System.out.println(idx);
//		System.out.println(Arrays.deepToString(map));
		injection(idx+1, input+1);
		
		map[idx] = B;
		injection(idx+1, input+1);
		
		map[idx] = copy;
		
	}
	
	public static boolean search(int idx) {
		// 우선 검사를 해보자
		for(int i=0; i<W; i++) {
			int acnt = 0;
			int bcnt = 0;
			for(int j=1; j<D; j++) {
				// 두 개가 같으면
				if(map[j-1][i] == 1 && map[j][i] == 1) {
					if(acnt!=0 && acnt<K-1) {
						acnt = 0;					
					}
					bcnt++;
				}
				if(map[j-1][i] == 0 && map[j][i] == 0 ) {
					if(bcnt!=0 && bcnt<K-1) {
						bcnt = 0;						
					}
					acnt++;
				}
				if(acnt >= K-1 || bcnt >= K-1) { 
					count++;
					break;
				}
			}
		}
		if(count==W) {
			return true;
		}
		return false;
	}
	
	
}
