/*
 * BinSin
 * https://www.acmicpc.net/problem/2210
 */

package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main07 {

	static int[][] board;
	static Set<Integer> set;
	static Pair[] next = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
	
	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void go(int index, int s, int x, int y) {
		if(index == 6) {
			set.add(s);
			return;
		}
		for(Pair n : next) {
			int nx = x + n.x;
			int ny = y + n.y;
			if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
			go(index+1, s*10 + board[nx][ny], nx, ny);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		board = new int[5][5];
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		set = new HashSet<>();
		for(int x=0; x<5; x++) {
			for(int y=0; y<5; y++) {
				go(1, board[x][y], x, y);
			}
		}
		bw.write(set.size() + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
