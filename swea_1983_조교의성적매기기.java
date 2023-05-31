import java.util.Arrays;
import java.util.Scanner;

public class swea_1983_조교의성적매기기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 학점 배열
		String[] grade = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
		double mid = 0;
		double last = 0;
		double assign = 0;
		for(int q=1; q<=T; q++) {
			// 학생 수
			int N = sc.nextInt();
			// 알고싶은 학생 번호
			int K = sc.nextInt();
			// 점수를 저장 할 배열
			double[] point = new double[N];
			// 점수 계산해서 배열에 넣는다.
			for(int i=0; i<N; i++) {
				mid = (Math.round(sc.nextInt()*35)) / 100.0;
				last = (Math.round(sc.nextInt()*45))/ 100.0;
				assign = (Math.round(sc.nextInt()*20))/ 100.0;
				point[i] = mid+last+assign;
			}
			// point 배열과 똑같은 배열을 만들어서 정렬.
			double[] bpoint = Arrays.copyOf(point, N);
			Arrays.sort(bpoint);
			System.out.printf("#%d ",q);
			for(int i=0; i<N; i++) {
				// 만약에 정렬 된 i번째와 우리가 찾고자하는 K-1번째의 값이 같으면
				if(bpoint[i]==point[K-1]) {
					// 출력한다.
					// N/10으로 i를 나눠주면 소수점 이하는 떨어지게 된다.
					System.out.println(grade[i/(N/10)]);
				}
			}
			
		}
	}
}
