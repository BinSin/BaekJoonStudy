/*
 * BinSin
 * https://www.acmicpc.net/problem/2933
 */

package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main07 {

	static int R;
	static int C;
	static boolean[][] map;
	static boolean[][] check;
	static ArrayList<Pair> list;
	static Pair[] next = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
	
	public static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void dfs(int x, int y) {
		if(!map[x][y] || check[x][y]) return;
		check[x][y] = true;
		list.add(new Pair(x, y));
		for(Pair n : next) {
			int nx = x + n.x;
			int ny = y + n.y;
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			dfs(nx, ny);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		list = new ArrayList<>();
		for(int r=0; r<R; r++) {
			String s = br.readLine();
			for(int c=0; c<C; c++) {
				if(s.charAt(c) == 'x') map[r][c] = true;
			}
		}
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		boolean d = false;
		while(N-- > 0) {
			int h = Integer.parseInt(st.nextToken());
			if(!d) { // 왼쪽
				for(int i=0; i<C; i++) {
					if(map[R-h][i]) {
						map[R-h][i] = false;
						break;
					}
				}
			} else { // 오른쪽
				for(int i=C-1; i>=0; i--) {
					if(map[R-h][i]) {
						map[R-h][i] = false;
						break;
					}
				}
			}
			d = !d;
			
			check = new boolean[R][C];
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(!map[i][j]) continue;
					if(check[i][j]) continue;
					list.clear();
					dfs(i, j);
					
					int[] low = new int[C];
					Arrays.fill(low, -1);
					for(Pair p : list) {
						low[p.y] = Math.max(low[p.y], p.x);
						map[p.x][p.y] = false;
					}
					int lowest = R;
					for(int x, y=0; y<C; y++) {
						if(low[y] == -1) continue;
						for(x=low[y]; x<R && !map[x][y]; x++);
						lowest = Math.min(lowest, x-low[y]-1);
					}
					for(Pair p : list) {
						map[p.x+lowest][p.y] = true;
						check[p.x+lowest][p.y] = true;
					}
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]) bw.write("x");
				else bw.write(".");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
