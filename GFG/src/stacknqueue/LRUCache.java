package stacknqueue;

import java.util.*;

public class LRUCache {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for(int t = 1; t <= test; t++) {
			Queue<Cache> queue = new LinkedList<>();
			int capacity = in.nextInt();
			int query = in.nextInt();
			in.nextLine();
			for(int q = 1; q <= query; q++ ) {
				String type = in.nextLine();
				if(type.equals("SET")) {
					int key = in.nextInt();
					int value = in.nextInt();
					if(queue.size() == capacity) {
						queue.remove();
					}
					queue.add(new Cache(key, value));
				}
				else {
					int key = in.nextInt();
					int value = -1;
					for(Cache cache : queue) {
						if(cache.getKey() == key) {
							value = cache.getValue();
							break;
						}
					}
					System.out.println(value);
				}
			}
		}
		in.close();
	}

}
class Cache {
	private int key;
	private int value;
	public Cache(int key, int value) {
		this.key = key;
		this.value = value;
	}
	public int getKey() {
		return this.key;
	}
	public int getValue() {
		return this.value;
	}
}