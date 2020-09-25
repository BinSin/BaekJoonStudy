/*
 * BinSin
 * https://www.acmicpc.net/problem/14503
 */

package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main04 {

	public static class Pair {
		int r, c;
		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Pair[] dir = {new Pair(-1, 0), new Pair(0, 1), new Pair(1, 0), new Pair(0, -1)};
		map[r][c] = -1;
		int answer = 1;
		while(true) {
			
			if(map[r][c] == 0) {
				map[r][c] = -1;
				answer++;
			}
			
			boolean check = false;
			for(Pair np : dir) {
				if(map[r+np.r][c+np.c] == 0) check = true;
			}
			
			if(check) { // a
				d = (d+3) % 4;
				if(map[r+dir[d].r][c+dir[d].c] == 0) {
					r += dir[d].r;
					c += dir[d].c;
				} // b
			} else { // d
				if(map[r-dir[d].r][c-dir[d].c] == 1) {
					break;
				} else { // c
					r -= dir[d].r;
					c -= dir[d].c;
				}
			}
		}
		
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
