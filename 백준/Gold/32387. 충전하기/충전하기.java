import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	// <포트 번호, 순서>
	static TreeMap<Integer, Integer> sequence1 = new TreeMap<>();
	static Map<Integer, Integer> sequence2 = new TreeMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");
		int N = Integer.parseInt(sa[0]);
		int Q = Integer.parseInt(sa[1]);

		for (int i = 1; i <= N; i++) {
			sequence1.put(i, 0);
		}

		for (int i = 1; i <= Q; i++) {
			sa = bf.readLine().split(" ");
			int command = Integer.parseInt(sa[0]);
			int portNum = Integer.parseInt(sa[1]);

			// System.out.println(sequence1);
			// System.out.println(sequence2);
			if(command == 1){
				commandOne(portNum, i);
			}else{
				commandTwo(portNum);
			}
		}

		System.out.println(sb);

	}

	// 포트에 꼽는 경우
	public static void commandOne(int portNum, int seq) {
		if (sequence1.containsKey(portNum)) {
			sequence1.remove(portNum);
			sequence2.put(portNum, seq);
			sb.append(portNum).append("\n");
		}else{
			Integer port = sequence1.ceilingKey(portNum);
			if(port == null) sb.append("-1").append("\n");
			else{
				sequence1.remove(port);
				sequence2.put(port, seq);
				sb.append(port).append("\n");
			}
		}
	}

	// 포트에서 빼는 경우
	public static void commandTwo(int portNum) {
		if(sequence1.containsKey(portNum)){
			sb.append("-1").append("\n");
		}else{
			sb.append(sequence2.get(portNum)).append("\n");
			sequence2.remove(portNum);
			sequence1.put(portNum, 0);
		}
	}

}