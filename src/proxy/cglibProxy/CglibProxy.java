package proxy.cglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 使用cglib动态代理
 * 
 * 
 */
public class CglibProxy implements MethodInterceptor {
	private Object target;

	/**
	 * 创建代理对象
	 * 
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	// 回调方法
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("before...");
		proxy.invokeSuper(obj, args);
		System.out.println("afeter...");
		return null;
	}

}