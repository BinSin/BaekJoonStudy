package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main01 {

	public static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	//  2
	//4 1 3
	//  5
	//  6
	public static void move(int[] dice, int command) {
		if(command == 1) { // 4 1 3 6 -> 6 4 1 3
			int tmp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tmp;
		} else if(command == 2) { // 4 1 3 6 -> 1 3 6 4
			int tmp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
		} else if(command == 3) { // 2 1 5 6 -> 1 5 6 2
			int tmp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
		} else { // 2 1 5 6 -> 6 2 1 5
			int tmp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		Pair point = new Pair(x, y);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Pair[] next = {new Pair(0, 1), new Pair(0, -1), new Pair(-1, 0), new Pair(1, 0)};
		int[] dice = new int[7];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int command = Integer.parseInt(st.nextToken());
			Pair n = next[command-1];
			int nextX = point.x + n.x;
			int nextY = point.y + n.y;
			if(0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
				point = new Pair(nextX, nextY);
				int value = map[nextX][nextY];
				move(dice, command);
				if(value == 0) {
					map[nextX][nextY] = dice[1];
				} else {
					dice[1] = value;
					map[nextX][nextY] = 0;
				}
				bw.write(dice[6] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}