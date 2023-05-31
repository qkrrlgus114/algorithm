import java.util.Arrays;
import java.util.Scanner;

public class baek_10815_숫자카드_실버5 {
	static int key;
	static int[] card;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		card = new int[N];
		for(int i=0; i<N; i++) {
			card[i] = sc.nextInt();
		}
		Arrays.sort(card);
		
		int M = sc.nextInt();
		int[] check = new int[M];
		for(int i=0; i<M; i++) {
			check[i] = sc.nextInt();
		}
		
		for(int i=0; i<M; i++) {
			key = check[i];
			boolean flag = binarySearch(0, N-1);
			if(flag) {
				System.out.print(1+" ");
			}else {
				System.out.print(0+" ");
			}
		}
	}
	
	public static boolean binarySearch(int st, int ed) {
		if(st>ed) return false;
		
		int mid = (st+ed)/2;
		
		if(key==card[mid]) return true;
		
		if(key>card[mid]) {
			return binarySearch(mid+1 , ed);
		}
		
		if(key<card[mid]) {
			return binarySearch(st, mid-1);
		}
		return false;
	}
}
