import java.util.Scanner;
import java.util.Stack;

public class swea_제로_스택을이용함 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 스택 생성
		int T = sc.nextInt();
		for(int k=1; k<=T; k++) {
			Stack<Integer> list = new Stack<>();
			// 입력이 들어갈 횟수
			int K = sc.nextInt();
			for(int i=0; i<K; i++) {
				// x를 입력받아서
				int x = sc.nextInt();
				// x가 0이 아니면 스택에 추가
				if(x!=0) {
					list.push(x);
				}
				// 0이면 최근 들어 온 값을삭제
				else {
					if(!list.isEmpty()) {
						list.pop();
					}
				}
			}
			int sum = 0;
			// 합을 계산
//			while(!list.isEmpty())
//				sum += list.pop();
			
			for(int i=0; i<list.size(); i++) {
				sum += list.get(i);
			}
			
			System.out.printf("#%d %d\n",k,sum);
		}
	
	}
}
