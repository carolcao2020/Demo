package lessons;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class OpenCSV {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//加载CSV文件
		CSVReader reader = new CSVReader(new FileReader(".\\DataFiles\\test.csv"));
		//把内容添加到list中
		List<String[]> li = reader.readAll();
		System.out.println("Total line is: " + li.size());
		
		//新建一个Itera引用
		Iterator<String[]> i1 = li.iterator();
		
		//遍历每个值
		while(i1.hasNext()){
			String[] str = i1.next();
			System.out.print("Current line value is: ");
			for(int i = 0; i<str.length;i++){
				System.out.print(" " + str[i]);
			}
			System.out.println("  ");
		}
	}
}
