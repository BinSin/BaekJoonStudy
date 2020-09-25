/*
 * BinSin
 * https://www.acmicpc.net/problem/11058
 */

package DynamicProgramming.dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main8 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		for(int i=1; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			for(int j=1; j<=i-3; j++) {
				long c = dp[i-(j+2)] * (j+1); // ctrl+a, ctrl+c -> j+2
				dp[i] = c > dp[i] ? c : dp[i];
			}
		}
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
