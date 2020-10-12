/*
 * BinSin
 * https://www.acmicpc.net/problem/14891
 */

package graph.bfs6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] geer = new int[4][8];
		for(int i=0; i<4; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				geer[i][j] = s.charAt(j) - '0';
			}
		}
		int[] ansNum = new int[4];
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			if(dir == 1) { // 반시계
				if(ansNum[n-1] == 0) ansNum[n-1] = 7;
				else ansNum[n-1]--;
			}
			else { // 시계
				if(ansNum[n-1] == 7) ansNum[n-1] = 0;
				else ansNum[n-1]++;
				
			}
		}
		int ans = 0;
		int num = 1;
		for(int i=0; i<4; i++) {
			if(geer[i][ansNum[i]] == 1) ans += num;
			num *= 2;
			System.out.println(geer[i][ansNum[i]] + " ");
		}
		for(int i=0; i<4; i++) {
			System.out.println(ansNum[i] + " ");
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
