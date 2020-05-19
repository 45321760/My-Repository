
public class Singleton{

	private static Singleton instance;
	private long started;
	private long a;
	private long b;

	private Singleton() {
		started = System.currentTimeMillis();
		this.a = 1000;
		this.b = 1000;
	}

	public static Singleton getInstance() {
		if(instance ==null) {
			instance = new Singleton();
		} 
		return instance;
	}

	public char getPhase() {
		long currTime = System.currentTimeMillis();
		if(currTime > started + 20000) {
			a = b = 750;
		}
		if(currTime > started + 40000) {
			a = b = 500;
		}
		if(currTime > started + 60000) {
			a = b = 250;
		}
		long rem = (currTime - started) % (a + b);
		if(rem > a) {
			return 'b';
		} else {
			return 'a';
		}
	}

}
