package task04;

import java.util.Scanner;

import task03.Replacer;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean have_info = false;
		String text = "";
		int line_length = 0;
		String replace_line = "";
		StringBuilder result = null;
		String command;
		while(true) {
			System.out.println("Enter command(-h or -help for help):");
			command = sc.nextLine();
			if (command.equals("-h") | command.equals("help")) {
				System.out.println("1.h or help for help"
						+ "\n2.e or exit for exit"
						+ "\n3.enter to enter info"
						+ "\n4.calculate to calculate gcd"
						+ "\n5.result to see results");
			}
			else if (command.equals("e") | command.equals("exit")) {
				break;
			}
			else if (command.equals("enter")) {
				System.out.println("Enter text:");
				text = sc.nextLine();
				System.out.println("Enter length of words to replace(integer):");
				line_length = Integer.parseInt(sc.nextLine());
				System.out.println("Enter a line to replace with:");
				replace_line = sc.nextLine();
				have_info = true;
			}
			else if (command.equals("calculate")) {
				if(have_info) {
					result = Replacer.replace(text, line_length, replace_line);
				}
				else {
					System.out.println();
				}
			}
			else if (command.equals("result")) {
				if (result != null) {
					System.out.println(result);
				}
			}
		}
	}
}