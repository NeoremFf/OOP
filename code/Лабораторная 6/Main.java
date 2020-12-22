package task06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Container cont = new Container();
		String fileName;
		String text;
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("1 - ��������� ����������. \n"
		        		+ "2 - ���������� ����������.\n"
		        		+ "3 - ������ ����������.\n"
		        		+ "4 - ����� ����������� ����������.\n"
		        		+ "5 - ���������� ��������. \n"
		        		+ "6 - �������� ��������. \n"
		        		+ "7 - ������� ����������.\n"
		        		+ "8 - �������� ������� �������� � ����������.\n"
		        		+ "9 - ����������\n"
		        		+ "10 - ����� �����\n"
		        		+ "11 - ������������ ������ ������� �����������a\n"
		        		+ "12 - ����� �� ���������. \n");
		   System.out.print("�������� �������: \n");
		   int number = Integer. parseInt(in.nextLine());
	       switch (number) {
	       case 1:
	    	   System.out.println("������� �����:");
	    		text = in.nextLine();
	    		cont = new Container(text);
	    		break;
	       case 2:
	    	   System.out.println("�������� ���� ��� ������:");
	    		fileName = in.nextLine();
	       		Ser.writeContainer(cont, fileName);
	       		break;
	       case 3:
	    	   System.out.println("�������� ���� ��� ������:");
	        	fileName = in.nextLine();
	        	cont = Ser.readContainer(cont, fileName);
	        	break;
	       case 4:
	       		System.out.println(cont.toString());
	       		break;
	       case 5:
	    	   System.out.println("������� �����:");
	    	   	text = in.nextLine();
	       		cont.add(text);
	       		break;
	       case 6:
	    	   System.out.println("������� �����:");
	          	text = in.nextLine();
	          	cont.remove(text);
	          	break;
	       case 7:
	    	   cont.clear();
	    	   break;
	       case 8:
	    	  System.out.println("������� �����:");
	    	   text = in.nextLine();
	    	   if (cont.containsAll(new Container(text))) System.out.println("��������� �������� ��������� �����");
	    	   else System.out.println("��������� �� �������� ��� ��������� �����");
	    	   break;
	       case 9:
	    	   cont.sort();
	    	   break;
	       case 10:
	    	  System.out.println("������� �����:");
	    	   text = in.nextLine();
	    	   if(cont.contains(text) != -1) System.out.println("��������� ����� �� " + cont.contains(text) + " ����� � ����������");
	    	   else System.out.println("��� ������ �������� � ����������");
	    	   break;
	       case 11:
	    	   laba3_jv.Main.main(null);
	       case 12:
	    	   return;
	       }
       }
	}
}
