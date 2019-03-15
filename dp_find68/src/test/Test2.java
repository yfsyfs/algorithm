package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* @Description: 求出1~1亿中 包含68的数字并打印，而且求出出现68的总次数, 例如 16868 出现2次"68" 
* @author: 影法师
* @date: 2019年3月15日 下午12:36:11
*
* @Copyright: 2019 https://yfsyfs.github.io Inc. All rights reserved.
* 注意：本内容仅限于影法师信息技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test2 {

	public static void main(String[] args) throws FileNotFoundException {
		process(6);
	}

	private static void process(int n) throws FileNotFoundException {
		System.setOut(new PrintStream(new File("d:\\log2.txt")));
		long begin = System.currentTimeMillis();
		int ret = 1;
		Set<String> resultSet = new HashSet<>();
		resultSet.add("68");
		int pow = 10;
		Set<String>[] resultSets = new Set[n + 1];
		resultSets[0] = new HashSet<>();
		resultSets[1] = new HashSet<>();
		resultSets[2] = new HashSet<>();
		resultSets[2].add("68");
		for (int i = 3; i < n + 1; i++) {
			// 下面是打印字符串部分(IO部分)
			for (String string : resultSets[i - 1]) {
				System.out.println(string);
			}
			resultSets[i] = new HashSet<>(resultSets[i - 1].size());
			for (int j = 68 * pow; j < 69 * pow; j++) {
				resultSets[i].add(String.valueOf(j));
			}
			for (int k = 1; k < 10; k++) {
				for (int j = 0; j < i; j++) {
					for (String string : resultSets[i - j - 1]) {
						resultSets[i].add(k + repeat(j) + string);
					}
				}
			}
			ret = 10 * ret + pow;
			pow *= 10;
		}
		for (String string : resultSets[n]) {
			System.out.println(string);
		}
		System.out.println("68一共出现 " + ret + "次");
		System.out.println("耗时: " + (System.currentTimeMillis() - begin) + "毫秒");
	}

	private static String repeat(int j) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < j; i++) {
			sb.append("0");
		}
		return sb.toString();
	}

}
