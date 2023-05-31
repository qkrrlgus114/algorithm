import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baek_18870_좌표압축_실버2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer,Integer> map = new HashMap<>();
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] sarr= new int[N];
		for(int i=0; i<N; i++) {
			sarr[i] =arr[i] = sc.nextInt();
		}
		Arrays.sort(sarr);
		int cnt = 0;
		map.put(sarr[0], 0);
 		for(int i=1; i<N; i++) {
			if(sarr[i]==sarr[i-1]) {
				map.put(sarr[i], cnt);
			}else if(!map.containsKey(sarr[i])) {
				map.put(sarr[i], ++cnt);
			}
		}
 		// 스트링 빌더 써야 시초 안 나는 개같으 ㄴ문제
 		StringBuilder sb = new StringBuilder();
 		for(int i=0; i<N; i++) {
 			sb.append(map.get(arr[i])).append(' ');
 		}
 		System.out.println(sb.toString());
		
	}
}
