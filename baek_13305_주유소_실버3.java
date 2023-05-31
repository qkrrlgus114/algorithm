import java.util.Scanner;

public class baek_13305_주유소_실버3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 도시의 개수
		long[] distance = new long[N-1]; // 도시의 거리
		long[] city = new long[N]; // 도시(마지막은 있으나 마나)
		long sum = 0; // 도시의 길이를 저장할 변수
		// 거리를 입력 받음
		for(int i=0; i<distance.length; i++) {
			distance[i] = sc.nextInt();
		}
		// 도시의 리터 가격을 입력 받음
		for(int i=0; i<city.length; i++) {
			city[i] = sc.nextInt();
		}
		
		int count = 0; // 인덱스 번호
		int temp = 0; // 임시 인덱스 번호
		boolean flag = true; // 임시 플래그
		while(true) {
			// count부터 도시의 길이까지 for문을 돈다.
			for(int i=count; i<city.length; i++) {
				if(city[count]>city[i]) { // count도시보다 다음 도시가 크다면
					flag = false; // 플래그 false로 바꾸고
					temp = i; // 임시변수에 i 저장
					for(int j=count; j<temp; j++) { // count부터 temp까지 돌면서
						sum += distance[j]*city[count]; // count도시부터 거리를 곱해준다.
					}
					count = i; // 끝나면 count를 i로 바꿔서 도시의 위치를 정해주고
					temp = N; // 임시변수를 다시 N으로 바꿔서 도시 끝으로 초기화
					break; // 끝났으니 브레이크
				}	
			}
			// 만약에 flag가 true면 count번째 도시보다 싼 곳이 없다는 소리
			if(flag==true) {
				for(int i=count; i<city.length-1; i++) {
					sum+=distance[i]*city[count]; // 거리를 전부 곱해서 더해준다
				}
				// while문 탈출
				break;
			}
			// 위 조건을 못돌았으면 flag 다시 true로 초기화
			flag = true;
		}
		System.out.println(sum);
		
	}
}
