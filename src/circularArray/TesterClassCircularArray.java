package circularArray;

public class TesterClassCircularArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularArrayQueue<String> queue = new CircularArrayQueue<String>();
		
		queue.offer("Haz");
		queue.offer("kass");
		queue.offer("bbb");
		queue.offer("hahaha");
		queue.offer("hello");
		queue.offer("world");
		
		queue.remove();
		System.out.println(queue);
	}

}
