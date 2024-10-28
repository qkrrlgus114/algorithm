
import java.io.*;
import java.util.*;

public class Main {

	static int[] cnt = new int[12];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for(int i=1; i<=11; i++){
			dfs(i, 0);
		}

		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++){
			int num = Integer.parseInt(bf.readLine());
			sb.append(cnt[num]).append("\n");
		}

		System.out.println(sb);

	}

	private static void dfs(int num, int cur){
		if(num == cur){
			cnt[num]++;
			return;
		}

		if(num < cur){
			return;
		}

		for(int i=1; i<=3; i++){
			dfs(num, cur + i);
		}
	}
}