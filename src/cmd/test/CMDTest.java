package cmd.test;


/**
 * http://lelglin.iteye.com/blog/1487351
 * http://soft.chinabyte.com/database/94/12087594.shtml
 * 
 * @author Administrator
 * 
 */
public class CMDTest {
	public static void main(String[] args) {
		Process p = null;
		try {
			p = Runtime.getRuntime().exec("c:\\test.bat");

			p.waitFor();
			System.out.println(p.exitValue());
			System.out.println("over");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//test.bat
//ping www.baidu.com
