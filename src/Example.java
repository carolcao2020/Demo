import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Example {
	String str = new String("good");
	char[] ch ={'a','b','c'};
	public static void main(String args[]){
		Example ex = new Example();
		ex.change(ex.str,ex.ch);
		System.out.print(ex.str+"and");	
		System.out.print(ex.ch);
		String str ="abc";
		changeStr(str);
		System.out.print(str);
		int i=0;
		for(foo('A');foo('B')&&(i<2);foo('C')){
			i++;
			foo('D');
		}
		int simpleArray[] = new int[5];
		int simpleArry[] = {1,2,3,5,5};
		ArrayList<Integer> numList = new ArrayList<Integer>();
		numList.add(1);
		numList.set(0, 5);
		String s1= "hello";
		char ch[] = s1.toCharArray();
		System.out.println(s1);
		System.out.println(ch);
		String s2=String.valueOf(ch);
		System.out.println(ch);
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (int m =0;i<5;i++){
			String sValue = "hello" + String.valueOf(m);
			map.put(sValue,m+10);
		}
		Set<String> keyset = map.keySet();
		
	}
	public void change(String str, char ch[]){
		str ="test ok";
		ch[0] ='g';
	}
	
	public static void changeStr(String str){
		str = "welcome";
	}
	static boolean foo(char c){
		System.out.print(c);
		return true;
	}

}
