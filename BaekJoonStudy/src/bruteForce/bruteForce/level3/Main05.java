package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main05 {

	static int N;
	static int M;
	static int H;
	static int[][] line;
	
	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean check(int[][] line) {
		for(int n=0; n<N; n++) {
			int l = n;
			for(int h=0; h<H; h++) {
				if(line[h][l] == 1) l++;
				else if(line[h][l] == 2) l--;
			}
			if(l != n) return false;
		}
		return true;
	}
	
	static int go(int[][] line, List<Pair> list) {
		if(check(line)) return 0;
		int answer = -1;
		int len = list.size();
		for(int i=0; i<len; i++) {
			int x1 = list.get(i).x;
			int y1 = list.get(i).y;
			if(line[x1][y1] != 0 || line[x1][y1+1] != 0) continue;
			line[x1][y1] = 1;
			line[x1][y1+1] = 2;
			if(check(line))	{
				if(answer == -1 || answer > 1) 
					answer = 1;
			}
			for(int j=i+1; j<len; j++) {
				int x2 = list.get(j).x;
				int y2 = list.get(j).y;
				if(line[x2][y2] != 0 || line[x2][y2+1] != 0) continue;
				line[x2][y2] = 1;
				line[x2][y2+1] = 2;
				if(check(line))	{
					if(answer == -1 || answer > 2) 
						answer = 2;
				}
				for(int k=j+1; k<len; k++) {
					int x3 = list.get(k).x;
					int y3 = list.get(k).y;
					if(line[x3][y3] != 0 || line[x3][y3+1] != 0) continue;
					line[x3][y3] = 1;
					line[x3][y3+1] = 2;
					if(check(line))	{
						if(answer == -1 || answer > 3) 
							answer = 3;
					}
					line[x3][y3] = 0;
					line[x3][y3+1] = 0;
				}
				line[x2][y2] = 0;
				line[x2][y2+1] = 0;
			}
			line[x1][y1] = 0;
			line[x1][y1+1] = 0;
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		line = new int[H][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken())-1;
			int n = Integer.parseInt(st.nextToken())-1;
			line[h][n] = 1;
			line[h][n+1] = 2;
		}
		List<Pair> list = new ArrayList<>();
		for(int h=0; h<H; h++) {
			for(int n=0; n<N-1; n++) {
				if(line[h][n] == 0) list.add(new Pair(h, n));
			}
		}
		bw.write(go(line, list) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
