package 단계별문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class baek_24954_물약구매__실버1 {
	static int[] potion;
	static int min = Integer.MAX_VALUE;
	static int sum;
	static boolean[] visited;
	static List<Integer>[] list;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		potion = new int[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			potion[i] = sc.nextInt();
		}
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=1; i<N+1; i++) {
			int x = sc.nextInt();
			for(int j=0; j<x; j++) {
				int th = sc.nextInt(); // 할인하는 물약의 번호
				int dis = sc.nextInt(); // 할인 가격
				list[i].add(th);
				list[i].add(dis);
			}
		}
		back(0);
		System.out.println(min);
		
	}
	
	public static void back(int depth ) {
		// 종료
		// 전부 골랐다면
		if(depth==N) {
			min = Math.min(min, sum);
			return;
		}
		
		// 재귀
		for(int i=1; i<N+1; i++) {
			// 내가 포션을 골랐는지부터 확인.
			if(visited[i]) continue;
			
			// 우선 포션을 골라보자
			sum+=potion[i];
			int[] copypotion = Arrays.copyOf(potion, N+1);
		
			for(int j=0; j<list[i].size(); j+=2) {
				int pick = list[i].get(j); // 내가 고른 번호
				int discount = list[i].get(j+1); // 할인 금액
				sale(pick, discount);
			}
			visited[i] = true;
			back(depth+1);
			visited[i] = false;
			sum-=potion[i];
			for(int q=0; q<N+1; q++) {
				potion[q] = copypotion[q];
			}
		}
	}
	
	public static void sale(int pick, int discount) {
		int temp = potion[pick]; // 임시로 포션 가격 저장
		if(temp-discount>1) { // 현재 가격에서 할인금액을 뺐더니 1 초과면
			potion[pick] -= discount; // 뺀다.
		} else { // 아니면 1이하라는 소리니 
			potion[pick] = 1; // 1로 둔다(1이하로는 못내려가서)
		}
	}
}
