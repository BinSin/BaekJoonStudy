/*
 * BinSin
 * https://www.acmicpc.net/problem/15653
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

public class Main01 {

	static int N;
	static int M;
	static char[][] board;
	static Pair[] next = {new Pair(0, 1, false), new Pair(1, 0, false), new Pair(0, -1, false), new Pair(-1, 0, false)};
	
	static class Pair {
		int x, y;
		boolean m;
		Pair(int x, int y, boolean m) {
			this.x = x;
			this.y = y;
			this.m = m;
		}
	}
	
	static Pair checkHole(char[][] bc, int x, int y, int dir) {
		boolean m = false;
		if(dir == 0) {
			for(int i=y+1; i<M-1; i++) {
				char c = bc[x][i];
				if(c == 'O') return new Pair(0, 0, m);
				else if(c == '#') return new Pair(x, i-1, m);
				if(c == 'R' || c == 'B') m = true;
			}
			return new Pair(x, M-2, m);
		} else if(dir == 1) {
			for(int i=x+1; i<N-1; i++) {
				char c = bc[i][y];
				if(c == 'O') return new Pair(0, 0, m);
				else if(c == '#') return new Pair(i-1, y, m);
				if(c == 'R' || c == 'B') m = true;
			}
			return new Pair(N-2, y, m);
		} else if(dir == 2) {
			for(int i=y-1; i>0; i--) {
				char c = bc[x][i];
				if(c == 'O') return new Pair(0, 0, m);
				else if(c == '#') return new Pair(x, i+1, m);
				if(c == 'R' || c == 'B') m = true;
			}
			return new Pair(x, 1, m);
		} else {
			for(int i=x-1; i>0; i--) {
				char c = bc[i][y];
				if(c == 'O') return new Pair(0, 0, m);
				else if(c == '#') return new Pair(i+1, y, m);
				if(c == 'R' || c == 'B') m = true;
			}
			return new Pair(1, y, m);
		}
	}
	
	public static void main(String[] artgs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		Pair red = new Pair(0, 0, false);
		Pair blue = new Pair(0, 0, false);
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				char c = s.charAt(j);
				board[i][j] = c;
				if(c == 'R') red = new Pair(i, j, false);
				else if(c == 'B') blue = new Pair(i, j, false);
			}
		}
		Queue<Pair[]> q = new LinkedList<>();
		q.add(new Pair[]{red, blue});
		int[][][][] count = new int[N][M][N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {
					Arrays.fill(count[i][j][k], -1);
				}
			}
		}
		count[red.x][red.y][blue.x][blue.y] = 0;
		int answer = -1;
		boolean find = false;
		while(!q.isEmpty()) {
			Pair[] p = q.remove();
			Pair r = p[0];
			Pair b = p[1];
			for(int n=0; n<4; n++) {
				char[][] bc = new char[N][M];
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						char c = board[i][j];
						if(c == 'B' || c == 'R') bc[i][j] = '.';
						else bc[i][j] = c;
					}
				}
				bc[r.x][r.y] = 'R';
				bc[b.x][b.y] = 'B';
				Pair holeR = checkHole(bc, r.x, r.y, n);
				Pair holeB = checkHole(bc, b.x, b.y, n);
				int nrx = holeR.x;
				int nry = holeR.y;
				boolean nrm = holeR.m;
				int nbx = holeB.x;
				int nby = holeB.y;
				boolean nbm = holeB.m;
				
				if(nbx == 0 && nby == 0) { // 구멍
					continue;
				} else if(nrx == 0 && nry == 0) {
					find = true;
					answer = count[r.x][r.y][b.x][b.y] + 1;
					break;
				}
				
				if(nbm) {
					nbx = nrx - next[n].x;
					nby = nry - next[n].y;
				} else if(nrm) {
					nrx = nbx - next[n].x;
					nry = nby - next[n].y;
				}
				
				if(count[nrx][nry][nbx][nby] != -1) continue;
				System.out.println();
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						System.out.print(bc[i][j]);
					}
					System.out.println();
				}
				count[nrx][nry][nbx][nby] = count[r.x][r.y][b.x][b.y] + 1;
				q.add(new Pair[] {new Pair(nrx, nry, false), new Pair(nbx, nby, false)});
			}
			if(find) break;
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
