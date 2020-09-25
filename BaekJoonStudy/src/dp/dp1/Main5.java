/*
 * https://www.acmicpc.net/problem/9095
 * BinSin
 */

package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] dp = new long[1000001];
		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		for(int i=4; i<=1000000; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
		}
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
