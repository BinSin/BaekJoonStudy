/*
 * https://www.acmicpc.net/problem/1699
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

public class Main21 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			dp[i] = i;
			for(int j=1; j*j<=i; j++) {
				if(dp[i] > dp[i-j*j] +1)
					dp[i] = dp[i-j*j] + 1;
			}
		}
		
		bw.write(dp[N] + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
