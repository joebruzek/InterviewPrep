public class answer { 

	public static void main(String [] args)
	{
		String str = args[0];

		if (str == null) return;
		if (str.length() < 2) return;

		char[] s = str.toCharArray();

		int tail = 1;

		for (int i = 0; i < s.length; i++) {
			int j;
			for (j = 0; j < tail; j++) {
				if(s[j] == s[i]) {
					break;
				}
			}

			if (j == tail) {
				s[tail] = s[i];
				tail++;
			}
		} 
		String result = new String(s);
		result = result.substring(0, tail);
		System.out.println(result);
	}
}