/*
 * BinSin
 * https://www.acmicpc.net/problem/6087
 */

package graph.bfs3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9 {
	
	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		boolean check = false;
		Pair start, end;
		start = end = new Pair(0, 0);
		for(int h=0; h<H; h++) {
			String s = br.readLine();
			for(int w=0; w<W; w++) {
				char c = s.charAt(w);
				map[h][w] = c;
				if(c == 'C') {
					if(!check) {
						start = new Pair(h, w);
						check = true;
					} else {
						end = new Pair(h, w);
					}
				}
			}
		}
		
		int[][] count = new int[H][W];
		for(int h=0; h<H; h++) Arrays.fill(count[h], -1);
		Queue<Pair> q = new LinkedList<>();
		int sx = start.x;
		int sy = start.y;
		count[sx][sy] = 0;
		q.add(new Pair(sx, sy));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int px = p.x;
			int py = p.y;
			
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};
			for(int i=0; i<4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				int c = count[px][py];
				while(0 <= nx && nx < H && 0 <= ny && ny < W) {
					if(map[nx][ny] == '*') break;
					if(count[nx][ny] == -1) {
						count[nx][ny] = c + 1;
						q.add(new Pair(nx, ny));
					}
					nx += dx[i];
					ny += dy[i];
				}
			}
		}
		
		bw.write(count[end.x][end.y]-1 + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
