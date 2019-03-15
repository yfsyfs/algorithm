package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
* @Description: 求出1~1亿中 包含68的数字并打印，而且求出出现68的总次数, 例如 16868 出现2次"68" 
* @author: 影法师
* @date: 2019年3月15日 下午12:36:11
*
* @Copyright: 2019 https://yfsyfs.github.io Inc. All rights reserved.
* 注意：本内容仅限于影法师信息技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test1 {

	private static final int MAX = 100000000;

	public static void main(String[] args) throws FileNotFoundException {
		process(MAX);
	}

	private static void process(int n) throws FileNotFoundException {
		System.setOut(new PrintStream(new File("d:\\log1.txt")));
		long start = System.currentTimeMillis();
		int ret = 0;
		for (int i = 1; i <= n; i++) {
			String nn = String.valueOf(i);
			String replaceAfter = nn.replaceAll("68", "");
			if (replaceAfter.length() < nn.length()) {
//				System.out.println(nn);
				ret += ((nn.length() - replaceAfter.length()) >> 1);
			}
		}
		// 68一共出现 7000000次
		System.out.println("68一共出现 " + ret + "次");
		// 程序耗时: 64352
		System.out.println("程序耗时: " + (System.currentTimeMillis() - start) + "毫秒");
	}

}
