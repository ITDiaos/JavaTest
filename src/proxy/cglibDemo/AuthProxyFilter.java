package proxy.cglibDemo;

import java.lang.reflect.Method;
import java.util.Arrays;

import net.sf.cglib.proxy.CallbackFilter;

/**
 * proxy����
 * 
 */
public class AuthProxyFilter implements CallbackFilter {

    private static final int AUTH_NEED     = 0;
    private static final int AUTH_NOT_NEED = 1;
    
    private static final String[] METHOD_NO_CHECK = {"query"};

    /**
     * <pre>
     * ѡ��ʹ�õ�proxy
     * �������query��������ʹ�õڶ���proxy
     * ����ʹ�õ�һ��proxy
     * </pre>
     */
    public int accept(Method method) {
//      if ("query".equals(method.getName())) {
		if (Arrays.asList(METHOD_NO_CHECK).contains(method.getName())) {
			return AUTH_NOT_NEED;
		}
        return AUTH_NEED;
    }

}
