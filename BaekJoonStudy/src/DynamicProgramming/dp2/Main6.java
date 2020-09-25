/*
 * BinSin
 * https://www.acmicpc.net/problem/2293
 */

package DynamicProgramming.dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[k+1];
		dp[0] = 1;
		for(int i=0; i<n; i++) {
			int c = coin[i];
			for(int j=c; j<=k; j++) {
				dp[j] += dp[j-c];
			}
		}
		
		bw.write(dp[k] + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
