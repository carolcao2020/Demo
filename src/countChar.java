import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class countChar {
	
	public static void FindMaxChar(String str){
		char[] chNum = str.toCharArray();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<chNum.length;i++){
			String sValue = String.valueOf(chNum[i]);
			Set<String> keySetValue = map.keySet();
			if(keySetValue.contains(sValue)){
				int v = map.get(sValue);
				map.put(sValue, v+1);
			}
			else{
				map.put(sValue, 1);
			}
			System.out.println(keySetValue);
			}
		System.out.println(map);
		System.out.println(map.keySet());
		System.out.println(map.values());
		int max =-1;
		Set<String> keySetNum = map.keySet();
		for(String keyNum:keySetNum){
			if(map.get(keyNum)>max){
				max = map.get(keyNum);
			}
			System.out.println(max);
		}
		for(String key: keySetNum){
			if(max == map.get(key)){
				System.out.println("The original string is: " + str);
				System.out.println("\'"+ key + "\'" + "is the most characters");
				System.out.println("\'"+ max + "\'" + "is the number that occurs");
			}
		}
		
	}
	
	//print 9x9 table
	public static void Table(){
		for(int i = 1;i<10;i++){
			for(int j=1;j<=i;j++){
				int k = i*j;
				System.out.print(j + "*"+i+"="+k + "  ");	
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="asdfsfadsfasdfsdf";
		FindMaxChar(str);
		int x=2;
		System.out.print(x++);
		System.out.print(x);
		System.out.print(++x);
		System.out.println(x);
//		int y =0;
//		switch(y){
//		case 10:
//			System.out.println("Test");
//			break;
//		case 5:
//			System.out.println("123");
//			break;
//		case 4:
//			System.out.println("4");
//			break;
//		case 1:
//			System.out.println("1");
//			break;
//		default:
//			System.out.println("default");
//			break;
//		}
//		int a =1;
//		int sum =0;
//		while(a<11){
//			System.out.print(a);
//			a++;
//		}
//		while(a<101){
//			sum += a;
//			a++;
//		}
//		System.out.println(sum);
		Table();

	}

}
