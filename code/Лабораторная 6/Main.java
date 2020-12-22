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
			System.out.print("1 - Занесение информации. \n"
		        		+ "2 - Сохранение контейнера.\n"
		        		+ "3 - Чтение контейнера.\n"
		        		+ "4 - Вывод содержимого контейнера.\n"
		        		+ "5 - Добавление элемента. \n"
		        		+ "6 - Удаление элемента. \n"
		        		+ "7 - Очистка контейнера.\n"
		        		+ "8 - Проверка наличия элемента в контейнере.\n"
		        		+ "9 - Сортировка\n"
		        		+ "10 - Поиск слова\n"
		        		+ "11 - Демонстрация работы Кирилла Христофоровa\n"
		        		+ "12 - Выход из программы. \n");
		   System.out.print("Выберете команду: \n");
		   int number = Integer. parseInt(in.nextLine());
	       switch (number) {
	       case 1:
	    	   System.out.println("Введите текст:");
	    		text = in.nextLine();
	    		cont = new Container(text);
	    		break;
	       case 2:
	    	   System.out.println("Выберите файл для записи:");
	    		fileName = in.nextLine();
	       		Ser.writeContainer(cont, fileName);
	       		break;
	       case 3:
	    	   System.out.println("Выберете файл для чтения:");
	        	fileName = in.nextLine();
	        	cont = Ser.readContainer(cont, fileName);
	        	break;
	       case 4:
	       		System.out.println(cont.toString());
	       		break;
	       case 5:
	    	   System.out.println("Введите текст:");
	    	   	text = in.nextLine();
	       		cont.add(text);
	       		break;
	       case 6:
	    	   System.out.println("Введите текст:");
	          	text = in.nextLine();
	          	cont.remove(text);
	          	break;
	       case 7:
	    	   cont.clear();
	    	   break;
	       case 8:
	    	  System.out.println("Введите текст:");
	    	   text = in.nextLine();
	    	   if (cont.containsAll(new Container(text))) System.out.println("Контейнер содержит указанные слова");
	    	   else System.out.println("Контейнер не содержит все указанные слова");
	    	   break;
	       case 9:
	    	   cont.sort();
	    	   break;
	       case 10:
	    	  System.out.println("Введите текст:");
	    	   text = in.nextLine();
	    	   if(cont.contains(text) != -1) System.out.println("Указанное слово на " + cont.contains(text) + " месте в контейнере");
	    	   else System.out.println("Нет такого єлемента в контейнере");
	    	   break;
	       case 11:
	    	   laba3_jv.Main.main(null);
	       case 12:
	    	   return;
	       }
       }
	}
}
