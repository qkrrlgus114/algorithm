package 단계별문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baek_1976_여행가자_골드4 {
	static List<Integer>[] list; // 입력을 저장하기 위한 리스트를 가진 배열
	static boolean[] visited; // 방문쳌
	static List<Integer> arr; // 마지막 도시의 번호를 저장
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		list = new ArrayList[N+1]; // 리스트를 담을 수 있는 int배열 생성
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>(); // 배열에 리스트 생성
		}
		
		visited = new boolean[N+1]; // 방문쳌 하기 위핼
		
		for(int i=1; i<N+1; i++) {
			for(int j=1;j<N+1; j++) {
				int temp = sc.nextInt(); // 변수를 하나 만들어서
				if(temp == 1) {
					list[i].add(j); // 무방향으로 입력
					list[j].add(i);					
				}
			}
		}
		
		arr = new ArrayList<>();
		
		for(int i=0; i<M; i++) { // 마지막 도시의 번호를 받음.
			int temp = sc.nextInt();
			arr.add(temp);
		}
		
		BFS(arr.get(0)); // 

		boolean flag = true;
		for(int i=0; i<M; i++) {
			//visited의 방문여부 확인. 
			if(!visited[arr.get(i)]) flag = false;
		}
		
		if(flag == false) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
		
	}
	
	
	public static void BFS(int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			visited[curr] = true;
			for(int i=0; i<list[curr].size(); i++) {
				int temp = list[curr].get(i);
				if(!visited[temp]) {
					visited[temp] = true;
					q.add(temp);
				}
			}
		}
	}
}
