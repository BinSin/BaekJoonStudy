/*
 * BinSin
 * https://www.acmicpc.net/problem/3190
 */

package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main05 {

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
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		int L = Integer.parseInt(br.readLine());
		int[] mod = new int[10001];
		mod[0] = 2;
		for(int i=1; i<=L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			mod[X] = d == 'L' ? 1 : 2;
		}
		
		Pair[] nd = {new Pair(0, 1), new Pair(-1, 0), new Pair(0, -1), new Pair(1, 0)};
		int dir = 1;
		Queue<Pair> snake = new LinkedList<Pair>();
		Pair point = new Pair(0, 0);
		map[0][0] = 2;
		snake.add(point);
		int time = 0;
		for(time=0; time<=10000; time++) {
			if(mod[time] == 1) dir = (dir+1) % 4;
			else if(mod[time] == 2) dir = (dir+3) % 4;
			
			int nx = point.x + nd[dir].x;
			int ny = point.y + nd[dir].y;
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) { // 맵 벗어날 때
				break;
			} else {
				if(map[nx][ny] == 0) { // 먹이 없을 때
					Pair r = snake.remove();
					map[r.x][r.y] = 0;
				} else if(map[nx][ny] == 1) { // 먹이 있을 때
					
				} else { // 자신과 부딪혔을 때
					break;
				}
				snake.add(new Pair(nx, ny));
				map[nx][ny] = 2;
				point = new Pair(nx, ny);
			}
		}
		bw.write(time+1 + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
