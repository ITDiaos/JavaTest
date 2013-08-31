package proxy.dynamicProxy;

import java.lang.reflect.Proxy;

import proxy.RealSubject;
import proxy.Subject;

public class DynamicProxyTestMain {

	public static void main(String[] args) {
		RealSubject subject = new RealSubject();
		Subject proxySubject = (Subject) Proxy.newProxyInstance(subject
				.getClass().getClassLoader(), subject.getClass()
				.getInterfaces(), new ProxyHandle(subject));
		proxySubject.request();
		
		proxySubject.response();
	}

}
