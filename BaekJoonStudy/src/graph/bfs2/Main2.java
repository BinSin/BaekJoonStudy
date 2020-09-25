/*
 * https://www.acmicpc.net/problem/3055
 * BinSin
 */

package graph.bfs2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] dist = new int[R][C];
		int[][] water = new int[R][C];
		for(int i=0; i<R; i++) {
			Arrays.fill(water[i], -1);
			Arrays.fill(dist[i], -1);
		}
		String[] a = new String[R];
		Queue<int[]> q = new LinkedList<int[]>();
		int sr=0, sc=0, er=0, ec=0;
		for(int i=0; i<R; i++) {
			a[i] = br.readLine();
			for(int j=0; j<C; j++) {
				switch(a[i].charAt(j)) {
				case 'D' : er = i; ec = j; break;
				case 'S' : sr = i; sc = j; break;
				case '*' : water[i][j] = 0; q.add(new int[]{i, j}); break;
				}
			}
		}
		
		// first - water
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowR = now[0];
			int nowC = now[1];
			for(int[] next : new int[][] {{now[0]-1, now[1]}, {now[0]+1, now[1]}, {now[0], now[1]-1}, {now[0], now[1]+1}}) {
				int nr = next[0];
				int nc = next[1];
				if(0 > nr || nr >= R || 0 > nc || nc >= C) continue;
				if(a[nr].charAt(nc) == 'X') continue;
				if(a[nr].charAt(nc) == 'D') continue;
				if(water[nr][nc] != -1) continue;
				
				q.add(new int[] {nr, nc});
				water[nr][nc] = water[nowR][nowC] + 1;
			}
		}
		
		// next - hedgehog
		q.add(new int[] {sr, sc});
		dist[sr][sc] = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowR = now[0];
			int nowC = now[1];
			for(int[] next : new int[][] {{now[0]-1, now[1]}, {now[0]+1, now[1]}, {now[0], now[1]-1}, {now[0], now[1]+1}}) {
				int nr = next[0];
				int nc = next[1];
				if(0 > nr || nr >= R || 0 > nc || nc >= C) continue;
				if(a[nr].charAt(nc) == 'X') continue;
				if(dist[nr][nc] != -1) continue;
				
				int nd = dist[nowR][nowC] + 1;
				if(water[nr][nc] == -1 || nd < water[nr][nc]) {
					q.add(new int[] {nr, nc});
					dist[nr][nc] = nd;
				}
			}
		}
		
		String answer;
		if(dist[er][ec] == -1) answer = "KAKTUS";
		else answer = dist[er][ec] + "";
		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
	}
}
