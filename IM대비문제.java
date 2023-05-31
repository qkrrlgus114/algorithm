import java.util.Arrays;
import java.util.Scanner;

public class IM대비문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int w=1; w<=T; w++) {
			boolean flag = false;
			int N = sc.nextInt();
			int output = 100000;
			int Kmin = sc.nextInt();
			int Kmax = sc.nextInt();
			// 신입사원과 점수에 맞는 카운트 배열 선언
			int[] newbie = new int[N];
			int[] count = new int[100];
			for(int i=0; i<N; i++) {
				newbie[i] = sc.nextInt();
			}
			// 카운트 배열에 뉴비점수에 해당하는 배열 1씩 더해줍니다.
			for(int i=0; i<N; i++) {
				count[newbie[i]-1]++;
			}
			int T1 = 0;
			int T2 = 0;
			for(int i=0; i<100; i++) {
				// 카운트 배열을 전부 탐색하는데 0이 아니면 시작
				if(count[i]!=0) {
					// 그 위치를 T1으로 두고 i+1부터 for문을 또 돌린다.
					T1 = i+1;
					for(int j=i+1; j<100; j++) {
						// i+1부터 돌아서 0이 아니면 그 값을 T2로 설정.
						if(count[j]!=0) T2 = j+1;
						// 점수에 들어가는 인원 수를 위한 변수
						int A=0;
						int B=0;
						int C=0;
						// 뉴비를 전부 탐색해서 A,B,C 구간으로 나누기 위해
						// 조건을 주고 해당되면 그 등급에 수를 더해준다.
						for(int l=0; l<N; l++) {
							if(newbie[l] < T1) C++;
							else if(newbie[l]>=T1 && newbie[l]<T2) B++;
							else if(newbie[l]>=T2) A++;
						}
						// 만약에 A,B,C 전부 최소와 최대 인원이 만족하면
						if(A>=Kmin&&B>=Kmin&&C>=Kmin&&A<=Kmax&&B<=Kmax&&C<=Kmax) {
							// flag를 true로 바꿔서 값이 하나라도 있다고 표시
							flag = true;
							// 이게 분명 최선이 아닌데..
							// max와 min을 찾는다
							int max=Math.max(A, B);
							max=Math.max(max, C);
							int min=Math.min(A, B);
							min=Math.min(min, C);
							// 우리는 가장 최소를 찾아야하니깐 max-min이 output보다 최소면 덮어쓴다.
							// max-min!=0 이 조건은 카운트 배열을 탐색할 때 처음에는 T1=i, T2=i+1부터 시작하지만
							// 마지막에 0이 아닌 존재하는 값이 있으면 T1과 T2가 똑같아져서 둘이 빼면 0인 경우가 발생한다.
							// 이걸 제거해주기 위해 세운 조건
							if(output>max-min&&max-min!=0) output = max-min;
						}
					}
				}
			}
			// flag가 false면 조건에 해당하는 것이 하나도 없는 것이니 -1 출력
			if(flag==false) System.out.printf("#%d %d\n",w,-1);
			// 아니면 output 출력!
			else System.out.printf("#%d %d\n",w,output);
		}
	}
}
