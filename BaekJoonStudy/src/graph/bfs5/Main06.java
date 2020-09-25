/*
 * BinSin
 * https://www.acmicpc.net/problem/14442
 */

package graph.bfs5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main06 {

	static class Pair {
		int x, y, z;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][][] d = new int[N][M][K+1];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		Pair[] next = {new Pair(0, 1), new Pair(1, 0), new Pair(0, -1), new Pair(-1, 0)};
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, 0));
		d[0][0][0] = 1;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(Pair n : next) {
				int nx = p.x + n.x;
				int ny = p.y + n.y;
				int nz = p.z;
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(map[nx][ny] == 0 && d[nx][ny][nz] == 0) {
					d[nx][ny][nz] = d[p.x][p.y][nz] + 1;
					q.add(new Pair(nx, ny, nz));
				}
				if(nz+1 <= K && map[nx][ny] == 1 && d[nx][ny][nz+1] == 0) {
					d[nx][ny][nz+1] = d[p.x][p.y][nz] + 1;
					q.add(new Pair(nx, ny, nz+1));
				}
			}
		}
		
		int answer = -1;
		for(int i=0; i<=K; i++) {
			if(d[N-1][M-1][i] == 0) continue;
			if(answer == -1) {
				answer = d[N-1][M-1][i];
			} else {
				answer = Math.min(answer, d[N-1][M-1][i]);
			}
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
