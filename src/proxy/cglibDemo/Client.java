package proxy.cglibDemo;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * 客户端调用
 * 
 */
public class Client {

    public static void main(String[] args) {
    	//设置编译后的class文件存放的目录
    	System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "src/proxy/cglibDemo/compiledClasses");
    	
        Client c = new Client();
        c.anyonecanManager();
        c.haveNoAuthManager();
        c.haveAuthManager();
        c.selectivityAuthManager();
    }

    /**
     * 模拟：没有任何权限要求，任何人都可以操作
     */
    public void anyonecanManager() {
        System.out.println("any one can do manager...");
        InfoManager manager = InfoManagerFactory.getInstance();
        doCRUD(manager);
        separatorLine();
    }

    /**
     * 模拟：登录会员没有权限
     */
    public void haveNoAuthManager() {
        System.out.println("the loginer's name is not admin,so have no permits do manager...");
        InfoManager noAuthManager = InfoManagerFactory.getAuthInstance(new AuthProxy("test"));
        doCRUD(noAuthManager);
        separatorLine();
    }

    /**
     * 模拟：登录会员有权限
     */
    public void haveAuthManager() {
        System.out.println("the loginer's name is admin,so have permits do manager...");
        InfoManager authManager = InfoManagerFactory.getAuthInstance(new AuthProxy("admin"));
        doCRUD(authManager);
        separatorLine();
    }

    /**
     * 模拟：没有权限的会员，可以作查询操作
     */
    public void selectivityAuthManager() {
        System.out.println("the loginer's name is not admin,so have no permits do manager except do query operator...");
        InfoManager authManager = InfoManagerFactory.getSelectivityAuthInstance(new AuthProxy("test"));
        doCRUD(authManager);
        separatorLine();
    }

    /**
     * 对Info做增加／更新／删除／查询操作
     * 
     * @param manager
     */
    private void doCRUD(InfoManager manager) {
        manager.create();
        manager.update();
        manager.delete();
        manager.query();
    }

    /**
     * 加一个分隔行，用于区分
     */
    private void separatorLine() {
        System.out.println("################################");
    }

}
