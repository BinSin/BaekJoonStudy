/*
 * https://www.acmicpc.net/problem/11054
 * BinSin
 */

package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main19 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] perm = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = -1001;
		int[] dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			if(perm[i] <= dp[i-1] + perm[i])
				dp[i] = dp[i-1] + perm[i];
			else
				dp[i] = perm[i];
			
			max = Math.max(max, dp[i]);
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
