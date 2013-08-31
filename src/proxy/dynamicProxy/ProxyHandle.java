package proxy.dynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandle implements InvocationHandler{
	private Object target;//目标对象
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
	
	// Proxy.newProxyInstance的第三个参数是表明这些被拦截的方法执行时需要执行哪个InvocationHandler的invoke方法
//	public Object bindRelation(Object object) {
//		this.target = object;
//		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
//				object.getClass().getInterfaces(), this);
//	} 
	
}

//http://kuangbaoxu.iteye.com/blog/192804
//http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html
//cglib（Code Generation Library）是一个强大的,高性能,高质量的Code生成类库。它可以在运行期扩展Java类与实现Java接口。
//cglib http://www.blogjava.net/stone2083/archive/2008/03/16/186615.html
//cglib封装了asm，可以在运行期动态生成新的class。
//cglib用于AOP，jdk中的proxy必须基于接口，cglib却没有这个限制。
//Hibernate用它来实现PO字节码的动态生成。
