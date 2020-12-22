package task06;
import java.io.Serializable;
import java.util.Arrays;

public class Container implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] text;
	private int size;
	public Container() {
		text = new String[0];
		size = 0;
	};
	public Container(String input) {
		text = new String[1];
		size = 0;
		int start = 0;
		int end = 0;
		for(int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			if(cur == ' ') {
				end = i;
				add(input.substring(start, end));
				start = i+1;
			}
		}
		add(input.substring(start, input.length()));
	};
	public String toString() {
		String result = "";
		for(int i = 0; i < size; i++) {
			result += text[i] + " ";
		}
		return result;
	}
	public void add(String line) {
		if (size < text.length) {
			text[size++] = line;
		}
		else {
			String[] newlist = new String[size+1];
			for(int i = 0;i<size;i++) {
				newlist[i] = text[i];
			}
			newlist[size++] = line;
			text = newlist;
		}
	}
	public void clear() {
		text = new String[0];
		size = 0;
	}
	public boolean remove(String line) {
		for (int i = 0; i < size; i++) {
			if(text[i].equals(line)) {
				String[] newlist = new String[size-1];
				for(int a = 0,j = 0;a<size;a++) {
					if (a != i) {
						newlist[j++] = text[a];
					}
				}
				text = newlist;
				size--;
				return true;
			}
		}
		return false;
	}
	public String[] toArray() {
		return text;
	}
	public int size() {
		return size;
	}
	public Iterator iterator(){
		return new ListIterator();
	}
	public class ListIterator implements Iterator {
		int index = 0;
		
		@Override
		public boolean hasNext() {
			if (index<text.length) {
				return true;
			}
			else return false;
		}

		@Override
		public String next() {
			return text[index++];
		}

		@Override
		public void remove() {
			String[] newlist = new String[size-1];
			for(int i = 0,j = 0;i<size;i++) {
				if (i != index) {
					newlist[j++] = text[i];
				}
			}
			text = newlist;
		}
	}
	public int contains(String string) {
		for(int i = 0; i < size; i++) {
			if(string.equalsIgnoreCase(text[i])) {
				return i;
			}
		}
		return -1;
	}
	public boolean containsAll(Container container) {
		Iterator itr = container.iterator();
		while (itr.hasNext()) {
			if(contains(itr.next()) == -1) return false;
		}
		return true;
	}
	public void sort() {
		Arrays.sort(text);
	}
}
