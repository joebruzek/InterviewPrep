public class answer {
	public static void main(String [] args)
	{
		char[] str = args[0].toCharArray();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				sb.append("%20");
			}
			else {
				sb.append(str[i]);
			}
		}
		System.out.println(sb.toString());
	}
}