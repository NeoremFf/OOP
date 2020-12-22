package task03;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter text:");
		String text = sc.nextLine();
		System.out.println("Enter length of words to replace(integer):");
		int line_length = Integer.parseInt(sc.nextLine());
		System.out.println("Enter a line to replace with:");
		String replace_line = sc.nextLine();
		System.out.println(text + " " + line_length + " " + replace_line);
		System.out.println(Replacer.replace(text, line_length, replace_line));
	}
}