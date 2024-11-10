import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		String[] sa = bf.readLine().split(" ");

		int[] check = new int[10];
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sa[i]);
		}

		int l = 0;
		int r = 0;
		int result = 1; // 탕후루 최대 개수
		int type = 1; // 탕후루 종류 개수
		check[arr[r]]++;

		while (r < N - 1) {
			r++;
			check[arr[r]]++;
			if(check[arr[r]] != 1){
				result = Math.max(result, r - l + 1);
			}else{
				type++;
				if(type <= 2){
					result = Math.max(result, r - l + 1);
				}else{
					while(l < r){
						check[arr[l]]--;
						if(check[arr[l]] == 0){
							type--;
							l++;
							break;
						}
						l++;
					}
				}
			}
		}

		System.out.println(result);

	}

}