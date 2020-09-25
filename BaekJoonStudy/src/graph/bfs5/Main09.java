/*
 * BinSin
 * https://www.acmicpc.net/problem/3197
 */

package graph.bfs5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main09 {

	public static class Pair {
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
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[R][C];
		Queue<Pair> water = new LinkedList<>();
		Queue<Pair> nwater = new LinkedList<>();
		boolean[][] wcheck = new boolean[R][C];
		Pair swan1, swan2;
		swan1 = swan2 = new Pair(0, 0);
		boolean flag = false;
		for(int r=0; r<R; r++) {
			String s = br.readLine();
			for(int c=0; c<C; c++) {
				char ch = s.charAt(c);
				if(ch == 'X') map[r][c] = false; // 얼음은 false
				else {
					map[r][c] = true; 
					water.add(new Pair(r, c));
					wcheck[r][c] = true;
					if(ch == 'L' && !flag) {
						swan1 = new Pair(r, c);
						flag = true;
					} else if(ch == 'L' && flag) {
						swan2 = new Pair(r, c);
					}
				}
			}
		}
		
		flag = false;
		Pair[] next = {new Pair(0, 1), new Pair(1, 0), new Pair(0, -1), new Pair(-1, 0)};
		// 반복
		int answer = 0;
		while(true) {
			Queue<Pair> q = new LinkedList<>();
			boolean[][] check = new boolean[R][C];
			q.add(swan1);
			check[swan1.x][swan1.y] = true;
			while(!q.isEmpty()) {
				Pair p = q.remove();
				for(Pair n : next) {
					int nx = n.x + p.x;
					int ny = n.y + p.y;
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					if(check[nx][ny]) continue;
					if(!map[nx][ny]) continue;
					if(nx == swan2.x && ny == swan2.y) {
						flag = true;
						break;
					}
					q.add(new Pair(nx, ny));
					check[nx][ny] = true;
				}
				if(flag) break;
			}
			if(flag) break;
			
			// 빙판 녹음
			for(Pair w : water) {
				for(Pair n : next) {
					int nx = n.x + w.x;
					int ny = n.y + w.y;
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					if(wcheck[nx][ny]) continue;
					if(!map[nx][ny]) {
						nwater.add(new Pair(nx, ny));
						wcheck[nx][ny] = true;
					}
				}
			}
			
			for(Pair w : nwater) {
				map[w.x][w.y] = true; 
			}
			answer++;
			
			water = nwater;
			nwater = new LinkedList<>();
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
