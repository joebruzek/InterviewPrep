public class answer {
	public static void main(String [] args)
	{
		int[][] img = new int[5][5];
		int count = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				img[i][j] = count; 
				count++;
			}
		}

		/*
		input
		| 0  | 1  | 2  | 3  | 4  |
		| 5  | 6  | 7  | 8  | 9  |
		| 10 | 11 | 12 | 13 | 14 |
		| 15 | 16 | 17 | 18 | 19 |
		| 20 | 21 | 22 | 23 | 24 |
		*/


		/* 
			NOTE
			THIS ANSWER CURRENTLY DOESN'T WORK
		*/

		int layers = img.length / 2;

		for (int i = 0; i < 1; i++) {
			int bound = img.length - i - 1;
			for (int j = 0; j < bound; j++) {
				System.out.println(i + " " + j + " " + bound);

				int temp = img[i][i + j];
				img[i][i + j] = img[bound - j][i];
				img[bound - j][i] = img[bound][bound - j];
				img[bound][bound - j] = img[i + j][bound];
				img[i + j][bound] = temp;
			}
		}

		for (int i = 0; i < 5; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("| ");
			for (int j = 0; j < 5; j++) {
				sb.append(img[i][j]);
				if (img[i][j] < 10) sb.append(" ");
				sb.append(" | ");
			}
			System.out.println(sb.toString()) ;
		}
	}
}