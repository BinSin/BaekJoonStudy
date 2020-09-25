/*
 * BinSin
 * https://www.acmicpc.net/problem/15486
 */

package DynamicProgramming.dp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main01 {

	static int N;
	static Work[] work;
	static int[] dp;
	
	static class Work {
		int p;
		int b;
		Work(int p, int b) {
			this.p = p;
			this.b = b;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		work = new Work[N];
		dp = new int[N+50];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			work[i] = new Work(p, b);
		}
		for(int i=0; i<N; i++) {
			dp[work[i].p + i] = Math.max(dp[work[i].p + i], dp[i] + work[i].b);
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
