
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, String> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		int cnt = 1;

		String[] sa = bf.readLine().split(" ");
		int N = Integer.parseInt(sa[0]);
		int M = Integer.parseInt(sa[1]);

		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			map1.put(cnt, s);
			map2.put(s, cnt++);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String s = bf.readLine();
			try{
				int num = Integer.parseInt(s.toString());
				sb.append(map1.get(num)).append("\n");
			}catch (NumberFormatException e){
				sb.append(map2.get(s.toString())).append("\n");
			}
		}

		System.out.println(sb.toString());


	}
}
