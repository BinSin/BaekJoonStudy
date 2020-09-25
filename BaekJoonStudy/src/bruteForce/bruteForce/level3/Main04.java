/*
 * BinSin
 * https://www.acmicpc.net/problem/15683
 */

package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main04 {

	static int N;
	static int M;
	static int[][] map;
	static Pair[] next = {new Pair(0, 1), new Pair(1, 0), new Pair(0, -1), new Pair(-1, 0)};
	
	static class Pair {
		int x, y, dir;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		Pair(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static void check(int[][] cm, Pair c, int dir) {
		int x = c.x;
		int y = c.y;
		while(0 <= x && x < N && 0 <= y && y < M) {
			if(cm[x][y] == 6) break;
			cm[x][y] = map[c.x][c.y];
			x += next[dir].x;
			y += next[dir].y;
		}
	}
	
	static int go(int index, List<Pair> cctv) {
		if(index == cctv.size()) {
			int[][] cm = new int[N][M];
			for(int i=0; i<N; i++) cm[i] = map[i].clone();
			for(Pair c : cctv) {
				int type = map[c.x][c.y];
				int dir = c.dir;
				if(type == 1) {
					check(cm, c, dir);
				} else if(type == 2) {
					check(cm, c, dir);
					check(cm, c, (dir+2)%4);
				} else if(type == 3) {
					check(cm, c, dir);
					check(cm, c, (dir+1)%4);
				} else if(type == 4) {
					check(cm, c, dir);
					check(cm, c, (dir+1)%4);
					check(cm, c, (dir+2)%4);
				} else {
					check(cm, c, dir);
					check(cm, c, (dir+1)%4);
					check(cm, c, (dir+2)%4);
					check(cm, c, (dir+3)%4);
				}
			}
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(cm[i][j] == 0) count++;
				}
			}
			return count;
		}
		int answer = 100;
		for(int i=0; i<4; i++) {
			cctv.get(index).dir = i;
			int count = go(index+1, cctv);
			answer = Math.min(answer, count);
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		List<Pair> cctv = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if(n >= 1 && n <= 5) cctv.add(new Pair(i, j));
			}
		}
		bw.write(go(0, cctv) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
