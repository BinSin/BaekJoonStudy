package bruteForce.bitmask.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] score = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				score[i][j] = s.charAt(j) - '0';
			}
		}
		
		int answer = 0;
		// 0 : 가로, 1 : 세로
		for(int s=0; s<(1<<(N*M)); s++) { // 가로
			int sum = 0;
			for(int i=0; i<N; i++) {
				int num = 0;
				for(int j=0; j<M; j++) {
					int k = i*M + j;
					if((s&(1<<k)) == 0) {
						num = num * 10 + score[i][j];
					} else {
						sum += num;
						num = 0;
					}
				}
				sum += num;
			}
			for(int j=0; j<M; j++) { // 세로
				int num = 0;
				for(int i=0; i<N; i++) {
					int k = i*M + j;
					if((s&(1<<k)) != 0) {
						num = num * 10 + score[i][j];
					} else {
						sum += num;
						num = 0;
					}
				}
				sum += num;
			}
			answer = Math.max(answer, sum);
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
