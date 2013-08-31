package proxy;

public class RealSubject implements Subject{

	public void request() {
		System.out.println("request...");
	}

	public void response() {
		System.out.println("response...");
	}

}
