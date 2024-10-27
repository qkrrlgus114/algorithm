
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		List<String> list = new ArrayList<>();
		// 듣도 못한 사람 set
		Set<String> set = new HashSet<>();


		String[] sa = bf.readLine().split(" ");
		int N = Integer.parseInt(sa[0]);
		int M = Integer.parseInt(sa[1]);

		for(int i=0; i<N; i++){
			set.add(bf.readLine());
		}

		for(int i=0; i<M; i++){
			String name = bf.readLine();
			if(set.contains(name)){
				list.add(name);
			}
		}

		System.out.println(list.size());
		StringBuilder sb = new StringBuilder();
		Collections.sort(list);
		for(int i=0; i<list.size(); i++){
			sb.append(list.get(i)).append("\n");
		}

		System.out.println(sb);

	}
}
