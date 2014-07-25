package offer;

import java.io.IOException;
import java.io.StreamTokenizer;

public class _32_NumberOf1 {

	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int low = (int) st.nval;
			st.nextToken();
			int high = (int) st.nval;
//			int result = numberOf1(low, high);
//			System.out.println(result);
		}
	}

//	private static int numberOf1(int low, int high) {
//
//		int tmp = high;
//		int count = 0;
//		while (tmp > 0) {
//			count++;
//			tmp /= 10;
//		}
//		
//	}
}
