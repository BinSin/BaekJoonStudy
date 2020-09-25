/*
 * https://www.acmicpc.net/problem/2156
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

public class Main14 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] perm = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=i-1; j>=0; j--) {
				if(perm[i] > perm[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		bw.write(Arrays.stream(dp).max().getAsInt() + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
