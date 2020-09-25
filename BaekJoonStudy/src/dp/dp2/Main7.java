/*
 * BinSin
 * https://www.acmicpc.net/problem/2294
 */

package dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main7 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		for(int i=0; i<n; i++) coin[i] = Integer.parseInt(br.readLine());
		int[] dp = new int[k+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for(int i=0; i<n; i++) {
			int c = coin[i];
			for(int j=0; j<=k; j++) {
				if(j-c < 0 || dp[j-c] == -1) continue;
				if(dp[j] == -1 || dp[j] > dp[j-c]+1) {
					dp[j] = dp[j-c] + 1;
				}
			}
		}
		bw.write(dp[k] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
