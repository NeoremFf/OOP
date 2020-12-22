package task08;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import task06.Container;
import task06.Ser;

public class Main {
	private static ArrayList<Product> list = new ArrayList<Product>();
//	private static Path iopath = Paths.get("D://");
	private static String name, unitOfMeasurement, stats;
	private static int amount, price, yearOfArrival, monthOfArrival, dayOfArrival, num;
	private static Scanner in = new Scanner(System.in);
	String args[]; 
	public static void main(String[] args) {
		String text;
		while(true) {
			System.out.print("1 - Добавление єлемента. \n"
		        		+ "2 - Очистка списка.\n"
		        		+ "3 - Сохранение в XML.\n"
		        		+ "4 - Чтение из XML.\n"
		        		+ "5 - Вывод содержимого. \n"
		        		+ "6 - Выход. \n");
		   System.out.print("Выберете команду: \n");
		   int number = Integer. parseInt(in.nextLine());
	       switch (number) {
	       case 1:
	    	   System.out.println("Название продукта: ");
	    	   name = in.nextLine();
	    	   System.out.println("Единица измерения: ");
	    	   unitOfMeasurement = in.nextLine();
	    	   System.out.println("Количество: ");
	    	   amount = Integer.parseInt(in.nextLine());
	    	   System.out.println("Цена: ");
	    	   price = Integer.parseInt(in.nextLine());
	    	   System.out.println("Год поставки: ");
	    	   yearOfArrival = Integer.parseInt(in.nextLine());
	    	   System.out.println("Месяц поставки: ");
	    	   monthOfArrival = Integer.parseInt(in.nextLine());
	    	   System.out.println("День поставки: ");
	    	   dayOfArrival = Integer.parseInt(in.nextLine());
	    	   System.out.println("Теперь введите не ограниченое количество характеристик в виде пары \"название-значение\", чтобы прекратить ввод напишите \"выход\"");
	    	   System.out.println("Сколько будет характеристик: ");
	    	   num = Integer.parseInt(in.nextLine());
	    	   args = new String[num*2];
	    	   for(int i = 0; i < num; i++) {
	    		   System.out.println("Название: ");
	    		   args[i*2] = in.nextLine();
	    		   System.out.println("Значение: ");
	    		   args[i*2+1] = in.nextLine();
	    	   }
	    	   list.add(new Product(name, unitOfMeasurement, amount,price, yearOfArrival, monthOfArrival, dayOfArrival, args));
	    	   break;
	       case 2:
	    	   list.clear();
	    	   break;
	       case 3:
	    	   WriteArrayList(list, PathfinderXML().toString());
	    	   break;
	       case 4:
	    	   ReadArrayList(list, PathfinderXML().toString());
	    	   break;
	       case 5:
	    	   num = 1;
	    	   System.out.println("-------------------------------");
	    	   for(Product item : list) {
	    		   System.out.println(num++ + "." + item.toString());
	    		   System.out.println("-------------------------------");
	    	   }
	    	   break;
	       case 6:
	    	   return;
	       }
       }
	}
	public static Path PathfinderXML() {
		System.out.println("Из предложеного списка выберете диреторию(нет указанного типа файла) для перемещения в нее или введите название файла с окончанием.xml чтобы открыть или создать его.\n");
		Path iopath = Paths.get("");
		Path newIopath;
		String text;
		while(true) {
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(iopath)) {
				System.out.println(iopath.toAbsolutePath());
				System.out.println("-------------------------------");
			    for (Path file: stream) {
			        System.out.println(file.getFileName());
			    }
			    System.out.println("-------------------------------");
			}
			catch (IOException | DirectoryIteratorException x) {
			    System.err.println("Ошибка! Такого пути не существует");
			}
			System.out.println("Выберете .xml-файл или директорию: ");
			text = in.nextLine();
			if(text.endsWith(".xml")){
				return iopath.resolve(Paths.get(text));
			}
			else {
				newIopath = iopath.resolve(Paths.get(text));
				try (DirectoryStream<Path> stream = Files.newDirectoryStream(newIopath)) {
					iopath = newIopath;
				}
				catch (IOException | DirectoryIteratorException x) {
					System.out.println("Такого файла в директории нет!");
				}
			}
			
		}
	}
	public static boolean DisplayDirectory(Path iopath) {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(iopath)) {
		    for (Path file: stream) {
		        System.out.println(file.getFileName());
		        return true;
		    }
		} catch (IOException | DirectoryIteratorException x) {
		    System.err.println(x);
		    return false;
		}
		return false;
	}
	public static boolean WriteArrayList(ArrayList<Product> arr, String dir) {
		if(dir.endsWith(".xml")){
			XMLEncoder encoder;
			try {
				encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(dir)));
				encoder.writeObject(arr);
				encoder.close();
				return true;
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: No " + dir + "found!");
				e.printStackTrace();
				return false;
			}
		}
		else {
			System.out.println("File name must end with .xml !");
			return false;
		}
		
	}
	public static boolean ReadArrayList(ArrayList<Product> arr, String dir) {
		if(dir.endsWith(".xml")){
			XMLDecoder decoder;
			try {
				decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(dir)));
				ArrayList<Product> result = (ArrayList<Product>) decoder.readObject();
				arr.clear();
				arr.addAll(result);
				decoder.close();
				return true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		else {
			System.out.println("File name must end with .xml !");
			return false;
		}
	}

}
