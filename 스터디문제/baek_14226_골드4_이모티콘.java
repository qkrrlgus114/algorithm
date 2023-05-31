package 스터디문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_14226_골드4_이모티콘 {
	public static class emoticon{
		int screen;
		int clipboard;
		int time;
		public emoticon(int screen, int clipboard, int time) {
			this.screen = screen;
			this.clipboard = clipboard;
			this.time = time;
		}
	}
	
	static int S;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();
		visited = new boolean[2001][2001];
		
		System.out.println(BFS(1,0,0));
	}
	
	public static int BFS(int screen, int clip, int time) {
		Queue<emoticon> q = new LinkedList<>();
		q.add(new emoticon(screen, clip, time));
		visited[screen][clip] = true;
		
		while(!q.isEmpty()) {
			emoticon curr = q.poll();
			int scremo = curr.screen;
			int clipemo = curr.clipboard;
			int timeemo = curr.time;
			
			// 화면의 이모티콘이 S와 같으면 시간을 돌려준다.
			if(scremo == S) {
				return timeemo;
			}
			
			// 클립보드를 현재 화면으로 복사.
			// 현재 스크린은 S보다 작아야 하며 해당 배열을 방문하지 않아야 한다.
			if(scremo<S && !visited[scremo+clipemo][clipemo]) {
				visited[clipemo+scremo][clipemo] = true;
				q.add(new emoticon(scremo+clipemo, clipemo, timeemo+1));
			}
			
			// 화면의 이모티콘을 클립보드로 복사.
			// 그러면 화면의 이모티콘이 클립보드보다 커야 의미가 있다. 그리고 이모티콘은 0보다 커야한다.
			if(scremo>0 && scremo>clipemo && !visited[scremo][scremo]) {
				visited[scremo][scremo] = true;
				q.add(new emoticon(scremo, scremo, timeemo+1));
			}
			
			
			// 화면의 이모티콘을 하나 삭제
			if(scremo>0 && !visited[scremo-1][clipemo]) {
				visited[scremo-1][clipemo] = true;
				q.add(new emoticon(scremo-1, clipemo, timeemo+1));
			}
		}
		return -1;
	}
}
