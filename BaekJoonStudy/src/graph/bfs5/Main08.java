/*
 * BinSin
 * https://www.acmicpc.net/problem/2234
 */

package graph.bfs5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main08 {

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
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[m][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer1 = 0;
		int answer2 = 0;
		int answer3 = 0;
		
		int[] room = new int[n*m+1];
		int rn = 1;
		int[][] s = new int[m][n];
		boolean[][] check = new boolean[m][n];
		Pair[] next = {new Pair(0, -1), new Pair(-1, 0), new Pair(0, 1), new Pair(1, 0)};
		int[] nexti = {1, 2, 4, 8};
		String[] nexts = {"1", "10", "100", "1000"};
		Queue<Pair> q = new LinkedList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(check[i][j]) continue;
				answer1++;
				int count = 1;
				s[i][j] = rn; // s에 room number 저장
				check[i][j] = true;
				q.add(new Pair(i, j));
				while(!q.isEmpty()) {
					Pair p = q.remove();
					for(int k=0; k<4; k++) {
						int nx = p.x + next[k].x;
						int ny = p.y + next[k].y;
						if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
						if(check[nx][ny]) continue;
						if(Integer.toBinaryString(map[p.x][p.y]&nexti[k]).equals(nexts[k])) continue;
						s[nx][ny] = rn;
						check[nx][ny] = true;
						q.add(new Pair(nx, ny));
						count++;
					}
				}
				room[rn++] = count; // room 에는 방 크기 저장
				if(answer2 < count) answer2 = count;
			}
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<4; k++) {
					int nx = i + next[k].x;
					int ny = j + next[k].y;
					if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
					if(s[i][j] == s[nx][ny]) continue;
					int sum = room[s[i][j]] + room[s[nx][ny]];
					if(answer3 < sum) answer3 = sum;
				}
			}
		}
		
		bw.write(answer1 + "\n");
		bw.write(answer2 + "\n");
		bw.write(answer3 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
