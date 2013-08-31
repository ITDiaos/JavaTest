package proxy.staticProxy;

import proxy.RealSubject;

public class StaticProxyTestMain {

	public static void main(String[] args) {
		RealSubject subject = new RealSubject();
		ProxySubject proxySubject = new ProxySubject(subject);
		proxySubject.request();
		//proxySubject.response();
	}

}
