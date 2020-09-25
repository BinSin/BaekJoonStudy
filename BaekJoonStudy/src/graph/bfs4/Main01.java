package graph.bfs4;

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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		Pair red = new Pair(0, 0);
		Pair blue = new Pair(0, 0);
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				char c = s.charAt(j);
				board[i][j] = c;
				if(c == 'R') red = new Pair(i, j);
				if(c == 'B') blue = new Pair(i, j);
			}
		}
		
		int[][] count = new int[N][M];
		Arrays.fill(count, -1);
		Pair[] next = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
		Queue<Pair[]> q = new LinkedList<>();
		q.add(new Pair[]{red, blue});
		while(!q.isEmpty()) {
			Pair[] p = q.remove();
			Pair r = p[0];
			Pair b = p[1];
			for(Pair n : next) {
				int rx = r.x, ry = r.y, bx = b.x, by = b.y;
				while(true) {
					rx += n.x;
					ry += n.y;
					bx += n.x;
					by += n.y;
					if(board[rx][ry] == '#') {
						rx -= n.x;
					}
				}
			}
		}
		
		
	}
}
