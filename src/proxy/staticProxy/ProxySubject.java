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
	
	//������ӿڼ�һ�����������������еĴ����ע�͸�ȥ���������е�ʵ����ʹ������ﶼ��Ҫ����ʵ�֡�
	//��������˴���ĸ��Ӷȡ���̬����Ϳ��Ա������ȱ�㡣 
	public void response() {
		System.out.println("....before");
		subject.request();
		System.out.println("....after");
	}
}
