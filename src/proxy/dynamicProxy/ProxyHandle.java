package proxy.dynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandle implements InvocationHandler{
	private Object target;//Ŀ�����
    public ProxyHandle(Object target){
    	this.target = target;
    }
    
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before...");
		Object retrunObj = method.invoke(target, args);
		System.out.println("afeter...");
		return retrunObj;
	}
	
	// Proxy.newProxyInstance�ĵ����������Ǳ�����Щ�����صķ���ִ��ʱ��Ҫִ���ĸ�InvocationHandler��invoke����
//	public Object bindRelation(Object object) {
//		this.target = object;
//		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
//				object.getClass().getInterfaces(), this);
//	} 
	
}

//http://kuangbaoxu.iteye.com/blog/192804
//http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html
//cglib��Code Generation Library����һ��ǿ���,������,��������Code������⡣����������������չJava����ʵ��Java�ӿڡ�
//cglib http://www.blogjava.net/stone2083/archive/2008/03/16/186615.html
//cglib��װ��asm�������������ڶ�̬�����µ�class��
//cglib����AOP��jdk�е�proxy������ڽӿڣ�cglibȴû��������ơ�
//Hibernate������ʵ��PO�ֽ���Ķ�̬���ɡ�
