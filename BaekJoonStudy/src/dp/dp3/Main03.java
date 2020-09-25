/*
 * BinSin
 * https://www.acmicpc.net/problem/12869
 */

package dp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main03 {
	static int N;
	static int[] scv;
	static int[][][] d = new int[61][61][61];
	
	public static int go(int a, int b, int c) {
		if(a < 0) return go(0, b, c);
		if(b < 0) return go(a, 0, c);
		if(c < 0) return go(a, b, 0);
		if(a == 0 && b == 0 && c == 0) return 0;
		if(d[a][b][c] != -1) return d[a][b][c];
		int answer = Integer.MAX_VALUE;
		if(answer > go(a-1, b-3, c-9)) {
			answer = go(a-1, b-3, c-9);
		}
		if(answer > go(a-1, b-9, c-3)) {
			answer = go(a-1, b-9, c-3);
		}
		if(answer > go(a-3, b-1, c-9)) {
			answer = go(a-3, b-1, c-9);
		}
		if(answer > go(a-3, b-9, c-1)) {
			answer = go(a-3, b-9, c-1);
		}
		if(answer > go(a-9, b-3, c-1)) {
			answer = go(a-9, b-3, c-1);
		}
		if(answer > go(a-9, b-1, c-3)) {
			answer = go(a-9, b-1, c-3);
		}
		answer++;
		d[a][b][c] = answer;
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		scv = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<=60; i++) {
			for(int j=0; j<=60; j++) {
				Arrays.fill(d[i][j], -1);
			}
		}
		bw.write(go(scv[0], scv[1], scv[2]) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
