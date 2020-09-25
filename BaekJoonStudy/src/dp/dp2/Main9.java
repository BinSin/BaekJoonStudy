/*
 * BinSin
 * https://www.acmicpc.net/problem/11066
 */

package dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9 {
	
	public static int go(int[] file, int[][] dp, int s, int e) {
		if(s == e) return 0;
		if(dp[s][e] != -1) return dp[s][e];
		
		int answer = -1;
		int sum = 0;
		for(int i=s; i<=e; i++) {
			sum += file[i];
		}
		for(int i=s; i<e; i++) {
			int tmp = go(file, dp, s, i) + go(file, dp, i+1, e) + sum;
			if(answer == -1 || answer > tmp) answer = tmp;
		}
		dp[s][e] = answer;
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int K = Integer.parseInt(br.readLine());
			int[] file = new int[K];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][] dp = new int[K][K];
			for(int i=0; i<K; i++) {
				file[i] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i], -1);
			} 
			bw.write(go(file, dp, 0, K-1) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
