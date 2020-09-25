package bruteForce.bitmask.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] skill = new int[N][N];
		for(int i=0; i<N; i++) {
			int j = 0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				skill[i][j++] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<(1<<N); i++) {
			int count = 0; // 절반으로 나눠지는지 검사
			for(int j=0; j<N; j++) {
				if((i&(1<<j)) == 0) {
					count++;
				}
			}
			if(count != N/2) continue;
			
			ArrayList<Integer> first = new ArrayList<>();
			ArrayList<Integer> second = new ArrayList<>();
			for(int j=0; j<N; j++) {
				if((i&(1<<j)) == 0) {
					first.add(j);
				} else {
					second.add(j);
				}
			}
			
			int firstSum = 0;
			int secondSum = 0;
			for(int x=0; x<N/2; x++) {
				for(int y=0; y<N/2; y++) {
					if(x == y) continue;
					firstSum += skill[first.get(x)][first.get(y)];
					secondSum += skill[second.get(x)][second.get(y)];
				}
			}
			int dif = Math.abs(firstSum - secondSum);
			if(dif < ans)
				ans = dif;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
