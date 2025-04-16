import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	// 저장해야 하는 위치가 저장되어있는 리스트
	static List<Node> nodeList = new ArrayList<>();
	static char[][] arr = new char[5][9];
	static int[][] intArr = new int[5][9];
	static boolean[] visited = new boolean[12];

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		// 탐색해야 하는 노드의 위치를 저장
		nodeList.add(new Node(0, 4));
		nodeList.add(new Node(1, 1));
		nodeList.add(new Node(1, 3));
		nodeList.add(new Node(1, 5));
		nodeList.add(new Node(1, 7));
		nodeList.add(new Node(2, 2));
		nodeList.add(new Node(2, 6));
		nodeList.add(new Node(3, 1));
		nodeList.add(new Node(3, 3));
		nodeList.add(new Node(3, 5));
		nodeList.add(new Node(3, 7));
		nodeList.add(new Node(4, 4));

		for(int i=0; i<5; i++){
			arr[i] = bf.readLine().toCharArray();
		}

		for(int i=0; i<5; i++){
			Arrays.fill(intArr[i], -1);
		}

		for(int i=0; i<5; i++){
			for(int j=0; j<9; j++){
				if(arr[i][j] != 'x' && arr[i][j] != '.'){
					intArr[i][j] = arr[i][j] - 'A' + 1;
				}
			}
		}

		int cnt = 0;
		// 이미 사용한 알파벳은 사용 처리
		for(int i=0; i<5; i++){
			for(int j=0; j<9; j++){
				if(arr[i][j] != 'x' && arr[i][j] != '.'){
					visited[arr[i][j] - 'A'] = true;
					cnt++;
				}
			}
		}

		combination(0, 0);
	}

	public static boolean combination(int depth, int nodeIdx){
		// 12개를 전부 선택했으면 계산 진행
		if(depth >= 12 || nodeIdx >= 12){
			// 노드 탐색 진행
			if(calculation()){
				for (char[] row : arr) {
        			System.out.println(new String(row));
				}
				System.exit(0);
			}
			return false;
		}

		Node node = nodeList.get(nodeIdx);
		boolean status = false;
		// 이미 선택한 노드라면
		if(intArr[node.y][node.x] != -1){
			status = combination(depth, nodeIdx + 1);
		}
		// 선택하지 않은 노드라면
		else{
			for(int i=0; i<12; i++){
				if(visited[i]) continue;
				visited[i] = true;
				intArr[node.y][node.x] = i + 1;
				arr[node.y][node.x] = (char) (i + 'A');
				status = combination(depth + 1, nodeIdx + 1);
				visited[i] = false;
				intArr[node.y][node.x] = -1;
				arr[node.y][node.x] = 'x';
			}
		}

		return status;
	}

	// 모든 노드 돌면서 계산하기
	public static boolean calculation(){
		if(intArr[1][1] + intArr[1][3] + intArr[1][5] + intArr[1][7] != 26){
			return false;
		}
		if(intArr[0][4] + intArr[1][3] + intArr[2][2] + intArr[3][1] != 26){
			return false;
		}
		if(intArr[0][4] + intArr[1][5] + intArr[2][6] + intArr[3][7] != 26){
			return false;
		}
		if(intArr[1][1] + intArr[2][2] + intArr[3][3] + intArr[4][4] != 26){
			return false;
		}
		if(intArr[1][7] + intArr[2][6] + intArr[3][5] + intArr[4][4] != 26){
			return false;
		}
		if(intArr[3][1] + intArr[3][3] + intArr[3][5] + intArr[3][7] != 26){
			return false;
		}

		return true;
	}
}

class Node{
	int y;
	int x;

	public Node(int y, int x){
		this.y = y;
		this.x = x;
	}
}