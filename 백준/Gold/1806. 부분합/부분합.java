import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");

		int N = Integer.parseInt(sa[0]);
		int S = Integer.parseInt(sa[1]);

		int[] arr = new int[N];
		sa = bf.readLine().split(" ");
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(sa[i]);
		}

		int result = Integer.MAX_VALUE;
		int l = 0;
		int r = 0;
		long sum = 0;

		while(true){
			if(sum >= S){
				result = Math.min(result, r - l);
				sum -= arr[l++];
				if(l >= N) break;
				continue;
			}else{
				if(r >= N) break;
			}

			if(N > r){
				sum += arr[r++];
			}

		}

		if(result == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(result);

	}

}
