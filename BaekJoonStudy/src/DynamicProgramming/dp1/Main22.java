/*
 * https://www.acmicpc.net/problem/2225
 * BinSin
 */

package DynamicProgramming.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main22 {
	
	public static void main(String[] args) throws IOException {
		final long mod = 1000000000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[K+1][N+1];
		dp[0][0] = 1;
		for(int i=1; i<=K; i++) {
			for(int j=0; j<=N; j++) {
				for(int k=0; k<=j; k++) {
					dp[i][j] += dp[i-1][j-k];
					dp[i][j] %= mod;
				}
			}
		}
		
		bw.write(dp[K][N] + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
