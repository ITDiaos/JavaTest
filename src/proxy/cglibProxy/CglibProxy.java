package proxy.cglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * ʹ��cglib��̬����
 * 
 * 
 */
public class CglibProxy implements MethodInterceptor {
	private Object target;

	/**
	 * �����������
	 * 
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// �ص�����
		enhancer.setCallback(this);
		// �����������
		return enhancer.create();
	}

	// �ص�����
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("before...");
		proxy.invokeSuper(obj, args);
		System.out.println("afeter...");
		return null;
	}

}