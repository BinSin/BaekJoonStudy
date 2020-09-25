/*
 * https://www.acmicpc.net/problem/15649
 * BinSin
 */

package bruteForce.nandm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void go(int[] ans, boolean[] check, int N, int M, int index) throws IOException {
		if(index == M) {
			for(int i=0; i<M; i++) {
				bw.write(ans[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(check[i]) continue;
			check[i] = true;
			ans[index] = i;
			go(ans, check, N, M, index+1);
			check[i] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[N+1];
		int[] ans = new int[M];
		
		go(ans, check, N, M, 0);
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}
