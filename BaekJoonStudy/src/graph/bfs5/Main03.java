/*
 * BinSin
 * https://www.acmicpc.net/problem/3184
 */

package graph.bfs5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main03 {

	static int R;
	static int C;
	static char[][] map;
	static List<Pair> animal;
	static int sc;
	static int wc;
	
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
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		animal = new ArrayList<>();
		for(int r=0; r<R; r++) {
			String s  = br.readLine();
			for(int c=0; c<C; c++) {
				char ch = s.charAt(c);
				map[r][c] = ch;
				if(ch == 'o') {
					animal.add(new Pair(r, c));
					sc++;
				} else if(ch == 'v') {
					animal.add(new Pair(r, c));
					wc++;
				}
			}
		}
		
		Pair[] next = {new Pair(0, 1), new Pair(1, 0), new Pair(0, -1), new Pair(-1, 0)}; 
		boolean[][] check = new boolean[R][C];
		for(int i=0; i<animal.size(); i++) {
			Queue<Pair> q = new LinkedList<>();
			Pair a = animal.get(i);
			if(check[a.x][a.y]) continue;
			int sn = 0;
			int wn = 0;
			if(map[a.x][a.y] == 'o') sn++;
			else wn++;
			q.add(a);
			check[a.x][a.y] = true;
			while(!q.isEmpty()) {
				Pair p = q.remove();
				for(Pair n : next) {
					int nx = p.x + n.x;
					int ny = p.y + n.y;
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					if(map[nx][ny] == '#' || check[nx][ny]) continue;
					else if(map[nx][ny] == 'o') sn++;
					else if(map[nx][ny] == 'v') wn++;
					q.add(new Pair(nx, ny));
					check[nx][ny] = true;
				}
			}
			if(sn <= wn) sc -= sn;
			else wc -= wn;
		}
		
		bw.write(sc + " " + wc);
		bw.flush();
		bw.close();
		br.close();
	}
}
