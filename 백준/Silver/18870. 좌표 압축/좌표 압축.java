import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		int[] arr = new int[N];
		int[] sortArr = new int[N];
		String[] sa = bf.readLine().split(" ");

		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(sa[i]);
			sortArr[i] = Integer.parseInt(sa[i]);
		}

		Arrays.sort(sortArr);

		StringBuilder sb = new StringBuilder();
		int idx = 0;

		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++){
			if(!map.containsKey(sortArr[i])){
				map.put(sortArr[i], idx++);
			}
		}

		for(int i=0; i<N; i++){
			sb.append(map.get(arr[i])).append(" ");
		}

		System.out.println(sb);
	}

}