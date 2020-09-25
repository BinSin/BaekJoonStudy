/*
 * https://www.acmicpc.net/problem/2206
 * BinSin
 */

package graph.bfs2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Pair {
		int x, y, c;
		Pair(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int[][][] dist = new int[N][M][2];
		Queue<Pair> q = new LinkedList<Pair>();
		dist[0][0][0] = 1;
		q.add(new Pair(0, 0, 0));
		while(!q.isEmpty()) {
			Pair now = q.poll();
			for(Pair next : new Pair[] {new Pair(now.x-1, now.y, now.c), new Pair(now.x+1, now.y, now.c), new Pair(now.x, now.y-1, now.c), new Pair(now.x, now.y+1, now.c)}) {
				if(0 <= next.x && next.x < N && 0 <= next.y && next.y < M) {
					int nx = next.x;
					int ny = next.y;
					int nc = next.c;
					if(dist[nx][ny][nc] == 0) {
						if(map[nx][ny] == 0) {
							q.add(new Pair(nx, ny, nc));
							dist[nx][ny][nc] = dist[now.x][now.y][nc] + 1; 
						}
						if(map[nx][ny] == 1 && nc == 0) {
							q.add(new Pair(nx, ny, nc+1));
							dist[nx][ny][nc+1] = dist[now.x][now.y][nc] + 1;
						}
					}
				}
			}
		}
		int answer;
		int x = dist[N-1][M-1][0];
		int y = dist[N-1][M-1][1];
		if(x == 0 && y == 0) answer = -1;
		else if(x != 0 && y == 0) answer = x;
		else if(x == 0 && y != 0) answer = y;
		else answer = x < y ? x : y;
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
