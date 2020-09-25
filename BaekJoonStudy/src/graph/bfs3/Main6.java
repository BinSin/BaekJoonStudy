/*
 * BinSin
 * https://www.acmicpc.net/problem/9376
 */

package graph.bfs3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6 {

	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] bfs(char[][] cell, Pair a, int h, int w) {
		int[][] check = new int[h][w];
		for(int i=0; i<h; i++)
			Arrays.fill(check[i], -1);
		check[a.x][a.y] = 0;
		ArrayDeque<Pair> dq = new ArrayDeque<>();
		dq.add(a);
		while(!dq.isEmpty()) {
			Pair p = dq.poll();
			int px = p.x;
			int py = p.y;
			Pair[] np = {new Pair(px-1, py), new Pair(px, py-1), new Pair(px+1, py), new Pair(px, py+1)};
			for(Pair n : np) {
				int nx = n.x;
				int ny = n.y;
				if(0 <= nx && nx < h && 0 <= ny && ny < w) {
				if(check[nx][ny] != -1) continue;
					if(cell[nx][ny] == '*') continue;
					if(cell[nx][ny] == '#'){
						dq.addLast(n);
						check[nx][ny] = check[px][py] + 1;
					} else {
						dq.addFirst(n);
						check[nx][ny] = check[px][py];
					}
				}
			}
		}
		return check;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			h += 2;
			w += 2;
			
			char[][] cell = new char[h][w];
			for(int i=1; i<h-1; i++) {
				char[] ch = br.readLine().toCharArray();
				cell[i][0] = cell[i][w-1] = '.';
				int k = 0;
				for(int j=1; j<w-1; j++) {
					cell[i][j] = ch[k++];
				}
			}
			for(int j=0; j<w; j++) {
				cell[0][j] = cell[h-1][j] = '.';
			}
			
			boolean e = false;
			int ax = 0, ay = 0, bx = 0, by = 0;
			for(int i=1; i<h-1; i++) {
				for(int j=1; j<w-1; j++) {
					if(cell[i][j] == '$' && !e) {
						ax = i;
						ay = j;
						e = true;
					} else if(cell[i][j] == '$' && e) {
						bx = i;
						by = j;
					}
				}
			}
			
			Pair a = new Pair(ax, ay);
			Pair b = new Pair(bx, by);
			Pair c = new Pair(0, 0);
			int[][] ac = bfs(cell, a, h, w);
			int[][] bc = bfs(cell, b, h, w);
			int[][] cc = bfs(cell, c, h, w);
			
			int ans = h * w;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					char ce = cell[i][j];
					if(ce == '*') continue;
					int cur = ac[i][j] + bc[i][j] + cc[i][j];
					if(ce == '#') cur -= 2;
					if(ans > cur) ans = cur;
				}
			}
			bw.write(ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
