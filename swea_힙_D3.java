import java.util.Arrays;
import java.util.Scanner;

public class swea_힙_D3 {
	public static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			arr = new int[200001]; // 1번부터 넣기 위해서 N+1로 선언
			int lastIdx = 0;
			System.out.printf("#%d",tc);
			boolean flag = true;
			for(int i=0; i<N; i++) {
				flag = true;
				int c = sc.nextInt();
				if(c==1) { // 삽입의 경우
					int num = sc.nextInt();
					arr[++lastIdx] = num;
					int cur = lastIdx;
					while(true) {
						if(cur!=1 && arr[cur/2] < arr[cur]) {
							swap(cur/2, cur);
							cur = cur/2;
						} else {
							break;
						}
					}
				}
				else if(c==2) { // 삭제의 경우
					if(arr[1]!=0) {
						System.out.print(" "+arr[1]);
						arr[1] = 0;
						arr[1] = arr[lastIdx];
						arr[lastIdx] = 0;
						lastIdx -=1;
					} else {
						System.out.print(" "+-1);
						flag = false;
						
					}
					if(flag == true) {
						int cur = 1;
						int child = cur*2;
						if(arr[child] < arr[child+1]) child = child+1;
						while(true) {
							if(arr[cur]<arr[child]) {
								swap(cur, child);
								cur = child;
								child *= 2;
								if(arr[child] < arr[child+1]) child=child+1;
							}
							else break;
							
						}
					}
				}
//				System.out.println(Arrays.toString(arr));
			}
			System.out.println();
		}
	}
	
	
	static void swap(int parent, int child) {
		int temp = arr[child];
		arr[child] = arr[parent];
		arr[parent] = temp;
	}
}
