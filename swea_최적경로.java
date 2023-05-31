import java.util.Scanner;

public class swea_최적경로 {
	static int[] home; // 집
	static boolean[] visited; // 방문 여부
	static int[][] arr; // 배열
	static int N;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			min = Integer.MAX_VALUE;
//			sum = 0;
			N = sc.nextInt();
			arr = new int[N+2][2]; // arr에 다 때려박곘다.
			visited = new boolean[N+2];
			home = new int[2];
			arr[0][0] = sc.nextInt();
			arr[0][1] = sc.nextInt();
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();
			for(int i=1; i<=N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			arr[N+1][0] = home[0];
			arr[N+1][1] = home[1];
			perm(0, 0, 0);
			System.out.printf("#%d %d\n",tc,min);
		}
	}
	// depth는 현재까지 생성된 순열의 길이이다.
	// current는 이전에 선택한 원소의 인덱스로, 순열을 생성하는 과정에서 depth-1번째 고객의 인덱스를
	// 가리키게 된다.
	// distance 매개변수는 이동한 거리를 누적하는 변수다. 순열을 생성하는 과정에서 선택한 고객 사이의 거리를 계산하여 누적.
	public static void perm(int depth, int current, int distance) {
		// 종료
		if(depth==N) { // 순열의 길이가 N과 같아지면
			distance+=Math.abs(arr[current][0] - home[0]) + Math.abs(arr[current][1] - home[1]); // 집의 거리까지 더해
			if(distance<min) min = distance; // 비교
			return;
		}
		// 재귀
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			
			int sum = Math.abs(arr[current][0] - arr[i][0]) + Math.abs(arr[current][1] - arr[i][1]);
			if(sum+distance > min) continue; // 너 이미 min보다 크네? 그러면 가지치기 해버려.
			visited[i] = true;
			perm(depth+1, i, sum+distance);
			visited[i] = false;
		}
	}
}
