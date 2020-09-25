/*
 * https://www.acmicpc.net/problem/16194
 * BinSin
 */

package DynamicProgramming.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main7 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		dp[1] = card[1];
		for(int i=2; i<=N; i++) {
			dp[i] = card[i];
			for(int j=1; j<i; j++) {
				dp[i] = dp[i] < dp[i-j] + card[j] ? dp[i] : dp[i-j] + card[j]; 
			}
		}
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
