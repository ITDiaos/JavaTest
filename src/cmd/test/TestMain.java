package cmd.test;

import java.util.List;

public class TestMain {

	// test.bat
	// ping www.baidu.com
	public static void main(String[] args) {
		CommandUtil util = new CommandUtil();
		util.executeCommand("c:\\test.bat");
		printList(util.getStdoutList());
		System.out.println("--------------------");
		printList(util.getErroroutList());
	}

	public static void printList(List<String> list) {
		for (String string : list) {
			System.out.println(string);
		}
	}

}
