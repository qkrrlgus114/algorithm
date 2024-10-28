
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");
		int N = Integer.parseInt(sa[0]);
		int M = Integer.parseInt(sa[1]);

		Map<String, String> map = new HashMap<>();

		for(int i=0; i<N; i++){
			sa = bf.readLine().split(" ");

			map.put(sa[0], sa[1]);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++){
			String url = bf.readLine();

			sb.append(map.get(url)).append("\n");
		}

		System.out.println(sb);
	}
}