package ba.bitcamp.threadpool;

import ba.bitcamp.logger.Logger;

public class Greetings implements Runnable {
	private static int id;

	public Greetings(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		Thread t = new Thread();
		int repetitions = 5;
		for (int i = 0; i < repetitions; i++) {
			String message = String.format("Meraba, ja sam " + this.id
					+ "-ti thread, izbrojao sam dakle " + i + "brojeva");
			Logger.log("threadLog", message);
		}
	}
}
