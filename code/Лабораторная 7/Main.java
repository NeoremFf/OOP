package task07;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(new Product("��������","��",153, 10, 2020, 11, 15, "����", "�������", "����", "�����"));
		System.out.println(list.get(0).toString());
	}
}
