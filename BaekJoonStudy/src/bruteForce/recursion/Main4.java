/*
 * https://www.acmicpc.net/problem/1182
 * BinSin
 */

package bruteForce.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main4 {

	public static int go(int[] arr, int sum, int S, int i) {
		if(i == arr.length) {
			if(sum == S)
				return 1;
			else
				return 0;
		}
		
		return go(arr, sum + arr[i], S, i+1) + go(arr, sum, S, i+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = go(arr, 0, S, 0);
		if(S == 0) count--; // 공집합의 경우 count가 1 증가된다.
		bw.write(count + "");
		br.close();
		bw.flush();
		bw.close();
	}
}
