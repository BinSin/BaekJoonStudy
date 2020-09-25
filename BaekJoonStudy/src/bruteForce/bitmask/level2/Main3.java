package bruteForce.bitmask.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3 {

	static int count(int mask, int[] words) {
		int count = 0;
		for(int word : words) {
			// 내가 배운 단어가 word에 있으면 0
			if((word & ((1<<26)-1-mask)) == 0) {
				count++;
			}
		}
		return count;
	}
	
	// 단어 추가되면 mask에 추가
	static int go(int index, int k, int mask, int[] words) {
		if(k < 0) return 0;
		
		if(index == 26) {
			return count(mask, words);
		}
		
		int answer = 0;
		int next = go(index+1, k-1, mask | (1 << index), words);
		if(answer < next) answer = next;
		
		if(index != 'a'-'a' && index != 'n'-'a' && index != 't'-'a' && index != 'i'-'a' && index != 'c'-'a') {
			next = go(index+1, k, mask, words);
			if(answer < next) answer = next;
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] words = new int[N];
		for(int i=0; i<N; i++) {
			char[] word = br.readLine().toCharArray();
			for(char s : word) {
				words[i] |= (1 << s - 'a');
			}
		}
		
		bw.write(go(0, K, 0, words) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
