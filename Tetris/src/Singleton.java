
public class Singleton{
	
	private static Singleton instance;
	private long started;
	private long a;
	private long b;

	private Singleton() {
		started = System.currentTimeMillis();
		this.a = 1500;
		this.b = 1500;
	}
	
	public static Singleton getInstance() {
		if(instance ==null) {
			instance = new Singleton();
		} 
		return instance;
	}
	
	public char getPhase() {
		long currTime = System.currentTimeMillis();
		long rem = (currTime - started) % (a + b);
		if(rem > a) {
			return 'b';
		} else {
			return 'a';
		}
	}
	
}
