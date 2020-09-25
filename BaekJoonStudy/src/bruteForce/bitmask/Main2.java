/*
 * https://www.acmicpc.net/problem/1182
 * BinSin
 */

package bruteForce.bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int count = 0;
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<(1<<N); i++) { // i == 0, 공집합
			int sum = 0;
			for(int j=0; j<N; j++) {
				if((i & (1 << j)) != 0)
					sum += arr[j];
			}
			
			if(S == sum) count++;
		}
		
		bw.write(count + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
