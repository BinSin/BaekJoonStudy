/*
 * BinSin
 * https://www.acmicpc.net/problem/2251
 */

package graph.bfs3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4 {

	static class Pair {
		int x, y, z;
		Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean[][] check = new boolean[C+1][C+1];
		boolean[] answer = new boolean[C+1];
		check[0][0] = true;
		answer[C] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, C});
		while(!q.isEmpty()) {
			int[] bottle = q.poll();
			Pair[] p = {new Pair(0, 1, 2), new Pair(0, 2, 1), new Pair(1, 0, 2), new Pair(1, 2, 0), new Pair(2, 0, 1), new Pair(2, 1, 0)};
			for(Pair np : p) {
				int x = np.x;
				int y = np.y;
				int z = np.z;
				int bx = bottle[x];
				int by = bottle[y];
				int bz = bottle[z];
				
				if(bx == 0) continue;
				
				int max;
				if(y == 0) max = A;
				else if(y == 1) max = B;
				else max = C;
				
				int nx, ny;
				if(by == max) continue;
				else if(bx + by <= max) {
					nx = 0;
					ny = bx + by;
				}
				else {
					nx = bx - (max - by);
					ny = max;
				}
				
				int a = 0, b = 0, c = 0;
				
				if(x == 0) a = nx;
				else if(x == 1) b = nx;
				else c = nx;
				
				if(y == 0) a = ny;
				else if(y == 1) b = ny;
				else c = ny;
				
				if(z == 0) a = bz;
				else if(z == 1) b = bz;
				else c = bz;
				
				if(!check[a][b]) {
					q.add(new int[] {a, b, c});
					check[a][b] = true;
				}
				if(a == 0) {
					answer[c] = true;
				}
			}
		}
		
		for(int i=0; i<answer.length; i++) {
			if(answer[i]) bw.write(i + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
