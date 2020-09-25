/*
 * BinSin
 * https://www.acmicpc.net/problem/1600
 */

package graph.bfs5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main07 {

	public static class Pair {
		int x, y, k;
		Pair(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][][] d = new int[H][W][K+1];
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				Arrays.fill(d[i][j], -1);
			}
		}
		Pair[] next = {
				new Pair(0, 1, 0), new Pair(1, 0, 0), new Pair(0, -1, 0), new Pair(-1, 0, 0),
				new Pair(1, -2, 1), new Pair(1, 2, 1), new Pair(2, 1, 1), new Pair(2, -1, 1),
				new Pair(-1, -2, 1), new Pair(-1, 2, 1), new Pair(-2, 1, 1), new Pair(-2, -1, 1)
		};
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, 0));
		d[0][0][0] = 0;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(Pair n : next) {
				int nx = p.x + n.x;
				int ny = p.y + n.y;
				int nk = p.k + n.k;
				if(nx < 0 || nx >= H || ny < 0 || ny >= W || nk > K) continue;
				if(map[nx][ny] == 1) continue;
				if(d[nx][ny][nk] != -1) continue;
				q.add(new Pair(nx, ny, nk));
				d[nx][ny][nk] = d[p.x][p.y][p.k] + 1; 
			}
		}
		int answer = -1;
		for(int k=0; k<=K; k++) {
			int n = d[H-1][W-1][k];
			if(n == -1) continue;
			if(answer == -1 || answer > n)	answer = n;
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
