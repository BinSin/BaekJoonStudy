/*
 * BinSin
 * https://www.acmicpc.net/problem/5213
 */

package graph.bfs5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main02 {
	static int N;
	static int[][][] domino;
	static Pair2[] next0 = {
			new Pair2(-1, -1, 1), new Pair2(0, -1, 1), new Pair2(1, -1, 1),
			new Pair2(-1, 0, 0), new Pair2(0, 1, 0), new Pair2(1, 0, 0)
			};
	static Pair2[] next1 = {
			new Pair2(-1, 0, 1), new Pair2(0, -1, 1), new Pair2(1, 0, 1),
			new Pair2(-1, 1, 0), new Pair2(0, 1, 0), new Pair2(1, 1, 0)
			};
	
	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Pair2 {
		int x, y, z;
		Pair2(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		domino = new int[N][N][2];
		for(int i=0; i<N; i++) {
			for(int j=0; i%2==0 ? j<N : j<N-1; j++) {
				st = new StringTokenizer(br.readLine());
				domino[i][j][0] = Integer.parseInt(st.nextToken());
				domino[i][j][1]	= Integer.parseInt(st.nextToken());
			}
		}
		
		Pair[][] from = new Pair[N][N];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0));
		int[][] count = new int[N][N];
		count[0][0] = 1;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			Pair2[] next;
			if(x%2 == 0) {
				next = next0;
			} else {
				next = next1;
			}
			for(Pair2 n : next) {
				int nx = x + n.x;
				int ny = y + n.y;
				int nz = n.z;
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(count[nx][ny] != 0) continue;
				if(domino[x][y][(nz+1)%2] != domino[nx][ny][nz]) continue;
				count[nx][ny] = count[x][y] + 1;
				q.add(new Pair(nx, ny));
				from[nx][ny] = new Pair(x, y);
			}
		}
		
		int num = 0;
		boolean c = false;
		int x = N - 1;
		int y = N - 1;
		for(x=N-1; x>0; x--) {
			for(y = x%2 == 0 ? N-1 : N-2; y>0; y--) {
				if(count[x][y] != 0) {
					c = true;
					num = count[x][y];
					break;
				}
			}
			if(c) break;
		}
		
		bw.write(num + "\n");
		Stack<Integer> s = new Stack<>();
		while(!(x == 0 && y == 0)) {
			s.push(N * (x - x/2) + (N-1) * (x/2) + y + 1);
			Pair p = from[x][y];
			x = p.x;
			y = p.y;
		}
		s.push(1);
		
		while(!s.empty()) {
			bw.write(s.pop() + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
