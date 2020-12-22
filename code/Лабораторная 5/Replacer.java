package task05;

public class Replacer {
	public static StringBuilder replace(String text, int length, String replacement) {
		StringBuilder newText = new StringBuilder(text);
		int start = 0;
		int end;
		 for(int i = 0; i < newText.length(); i++) {
			char cur = newText.charAt(i);
			if(cur == ' ' || cur == ',' || cur == ';' || cur == '-' || cur == ':' || cur == '.' || cur == '?' || cur == '!' || i == newText.length()) {
				end = i;
				if (end - start == length) {
					newText.replace(start, end, replacement);
				}
				start = i+1;
			}
		}
		return newText;
	}
}
