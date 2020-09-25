/*
 * BinSin
 * https://www.acmicpc.net/problem/1495
 */

package DynamicProgramming.dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main11 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] volumn = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) volumn[i] = Integer.parseInt(st.nextToken());
		boolean[][] dp = new boolean[N+1][M+1];
		dp[0][S] = true;
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=M; j++) {
				if(j-volumn[i] >= 0 && dp[i-1][j-volumn[i]]) {
					dp[i][j] = true;
				}
				if(j+volumn[i] <= M && dp[i-1][j+volumn[i]]) {
					dp[i][j] = true;
				}
			}
		}
		int answer = -1;
		for(int i=M; i>=0; i--) {
			if(dp[N][i]) {
				answer = i;
				break;
			}
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
