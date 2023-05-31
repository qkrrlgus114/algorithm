import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class swea_한솔이의택배아르바이트 {
	public static void main(String[] args) {
		// 주석 빼먹어서 다시 올림다!
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int q = 1; q <= T; q++) {
			int N = sc.nextInt();
			int[] box = new int[N];
			// 박스 옮긴 횟수를 저장하는 count 변수!
			int count = 0;
			// 입력을 야무지게 받음
			for (int i = 0; i < box.length; i++) {
				box[i] = sc.nextInt();
			}
			// 야무지게 정렬
			Arrays.sort(box);
			// 배열의 뒤에서부터 50 이상인지 확인하는데
			// 50이 안넘는 인덱스를 저장하기 위한 idx 선언
			int idx = 0;
			for (int i = box.length - 1; i >= 0; i--) {
				// box[i]가 50보다 크거나 같으면 count++ 해주고 그 위치를 0으로 만들어줌.
				if (box[i] >= 50) {
					count++;
					box[i] = 0;
				} else { // 아니라면 idx에 i+1로 인덱스를 저장하고 뿌레이크
					idx = i + 1;
					break;
				}
			}
			// 큐에 넣어서 문제를 풀겠다~
			Queue<Integer> qu = new LinkedList<Integer>();
			// 1,3,6,8,9,17,50,51이 입력으로 들어왔다고 치자.
			// 51과 50을 제거하고 count=2가 된다. 그럼 배열은 [1,3,6,8,9,17,0,0]이 되고 idx는 6이 된다.
			// 그리고 k를 0으로 우선 두고 while 안에서 k를 1씩 더해준다.
			// 배열을 검사하는데 qu.add(box[idx-k])를 하면 배열의 17을 큐에 넣어준다.
			// 배열중에 가장 큰 값을 넣었다면 이제는 작은 값인 1부터 for문으로 하나씩 넣으면서 17 * qu.size()를 해서 50이 넘는지 확인한다.
			// 50이 안넘는다면 그 다음인 3을넣으면 현재 큐에는 [17,1,3]이 들어가있고 size는 3이다.
			// 17 * qu.size()를 하면 50이 넘으므로 큐를 초기화시키고 count를 더해준다.
			// 남은 수를 넣어보면 큐가[9,6,8]이 남는데 9 * qu.size() 하면 50을 안넘으므로 그냥 종료시킨다.(남은 박스의 무게가 50이 넘어야만 옮기는 게 가능하므로)
			int k = 0;
			while (idx-k!=0) {
				k++;
				// 0이 아닌 배열의 값만 넣기위해서.
				if(box[idx-k]!=0) {
					qu.add(box[idx - k]);
					box[idx-k] = 0;
				}
				else break;
				if (qu.peek() * qu.size() >= 50) {
					count++;
					qu.clear();
				}
				else if(qu.peek() * qu.size() < 50){
					for(int i=0; i<idx-k; i++) {
						// 0이 아닌 배열의 값만 넣기위해서.
						if(box[i]!=0) {
							qu.add(box[i]);							
							box[i] = 0;
						}
						if (qu.peek() * qu.size() >= 50) {
							count++;
							qu.clear();
							break;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", q, count);
		}
	}
}

