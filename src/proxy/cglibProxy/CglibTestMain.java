package proxy.cglibProxy;

import net.sf.cglib.core.DebuggingClassWriter;

public class CglibTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"c:\\cglib");
		CglibProxy cglib = new CglibProxy();
		RealSubject2 subject = (RealSubject2) cglib.getInstance(new RealSubject2());
		subject.request();
	}

}
