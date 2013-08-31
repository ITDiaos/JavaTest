package proxy.staticProxy;

import proxy.RealSubject;
import proxy.Subject;

public class ProxySubject implements Subject{
	RealSubject subject;
	public ProxySubject(RealSubject subject){
		this.subject = subject;
	}
	public void request() {
		System.out.println("....before");
		subject.request();
		System.out.println("....after");
	}
	
	//当如果接口加一个方法（把上面所有的代码的注释给去掉），所有的实现类和代理类里都需要做个实现。
	//这就增加了代码的复杂度。动态代理就可以避免这个缺点。 
	public void response() {
		System.out.println("....before");
		subject.request();
		System.out.println("....after");
	}
}
