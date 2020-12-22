package task05;

public class Main {
	public static void main(String[] args) {
		Container test = new Container("Hello world text yay let's try");
		test.add("OI");
		System.out.println(test.toString());
		test.remove("text");
		System.out.println(test.toString());
		Iterator itr = test.iterator();
		System.out.println(itr.next());
		System.out.println(itr.next());
		System.out.println(itr.next());
		System.out.println(test.contains("world"));
		System.out.println(test.contains("nope"));
		System.out.println(test.containsAll(new Container("Hello yay try")));
	}
}
