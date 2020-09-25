/*
 * BinSin
 * https://www.acmicpc.net/problem/15989
 */

package DynamicProgramming.dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[10001];
		dp[0] = 1;
		for(int i=1; i<=10000; i++) {
			dp[i] += dp[i-1];
		}
		for(int i=2; i<=10000; i++) {
			dp[i] += dp[i-2];
		}
		for(int i=3; i<=10000; i++) {
			dp[i] += dp[i-3];
		}
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
