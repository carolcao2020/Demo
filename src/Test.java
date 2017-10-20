import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test { 
	private  int count =0;
	public void test1(){
		count++;
		System.out.println(count);
	}
	public void test2(){
		count++;
		System.out.println(count);
	}
	
	@SuppressWarnings("null")
	public int currsor[] = {0,0};
	public int[] arraylist(int number[], int target){
		for(int i = 0;i<number.length;i++){
//			System.out.println(number[i]);
			for(int j = 1; j<number.length;j++){
//				System.out.println(number[j]);
				if(number[i] + number[j] == target){
					if(i<j){
						currsor[0]=i+1;
						currsor[1]=j+1;
					}
					else{
						currsor[0]=j+1;
						currsor[1]=i+1;
					}
				}
				else{
					System.out.println("Cannot find the value");
				}
			}
		}
		System.out.println(currsor[0]);
		System.out.println(currsor[1]);
		return currsor;	
	}
	
	public ArrayList FindCharacter(String str){
		int max = 0;
		int n = 0;
		char[] ch = str.toCharArray();
		ArrayList listChar = new ArrayList();
		ArrayList listNum = new ArrayList();
		for(int i=0; i<ch.length;i++){
			int currsor=0;
			for(int j =1; j< ch.length;j++){
				if(ch[j]==ch[i]){
					currsor++;
				}
			}
			if(!listChar.contains(ch[i])){
				listChar.add(ch[i]);
				listNum.add(currsor);
			}
			System.out.println(listChar);
			System.out.println(listNum);
		}
		for(int k=0;k<listNum.size()-1;k++){
			//System.out.println(Integer.parseInt(listNum.get(k).toString()));
			if(Integer.parseInt(listNum.get(k).toString()) < Integer.parseInt(listNum.get(k+1).toString())){
				max = Integer.parseInt(listNum.get(k+1).toString());
				n = k;
			}
		}
		System.out.println(n);
//		System.out.println(max);
		ArrayList listCharNum = new ArrayList();
		listCharNum.add(listChar.get(n-1));
		listCharNum.add(listNum.get(n-1));
		System.out.println(listCharNum);
		return listChar;
	}
	
	public void findCharNum(String str){
		char[] charStr = str.toCharArray();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<charStr.length;i++){
			String sValue = String.valueOf(charStr[i]);
			Set<String> keySet=map.keySet();
			if(keySet.contains(sValue)){
				int v = map.get(sValue);
				map.put(sValue,v+1);
			}
			else{
				map.put(sValue,1);
			}
			System.out.println(keySet);
		}
		
		System.out.println(map);
		System.out.println(map.keySet());
		int max = -1;
		Set<String> keySetNum=map.keySet();
		for(String key:keySetNum){
			if(map.get(key)> max){
				max = map.get(key);
			}
			System.out.println(max);
		}
		for(String key : keySetNum){
			if(max == map.get(key)){
				System.out.println("key : " + key + " is the max number: " + max);
			}
		}
		
		System.out.println(map.containsValue(max));
		System.out.println(map.containsKey("a"));
	}
	
	public String reverseString(String str){
		return new StringBuilder(str).reverse().toString();
	}
	
	public void BubbleSort(int[] unsorted){
		for(int i=0;i<unsorted.length;i++){
			for(int j=i;j<unsorted.length;j++){
				if(unsorted[i]>unsorted[j]){
					int temp = unsorted[i];
					unsorted[i] = unsorted[j];
					unsorted[j] = temp;
				}
			}
			System.out.print(i +" The sort order is :");
			for(int k = 0; k< unsorted.length;k++){
				System.out.print(unsorted[k]+",");
			}
			System.out.println();
		}
	}
	public static int getvalue(int i){
		int result = 0;
		switch(i){
		case 1:
			result = result + i;
		case 2:
			result = result + i*2;
		case 3:
			result = result + i*3;
		}
		return result;	
		
	}
	public static void main(String[] args) {
		Test t1= new Test();
//		t1.test1();
//		t1.test2();
//		int num[]={2,7,1,4,88};
//		int target = 9;
//		t1.arraylist(num, target);
//		String str="asdfsfadsfasdfsdf";
//		t1.FindCharacter(str);
//		t1.findCharNum(str);
		String str = "Hello";
		System.out.println(t1.reverseString(str));
		int[] numSort = {12,7,3,9,4,22};
		t1.BubbleSort(numSort);
		for(int n = 0;n < numSort.length;n++){
			System.out.print(numSort[n]+" ");	
		}
		System.out.println();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int k =0; k< 10;k++){
			list.add(k+2);
			System.out.println(list.get(k));
		}
		System.out.println(list.get(0));
		int size = list.size();
		int[] num = new int[size];
		for(int k =0; k< 10;k++){
			num[k] = list.get(k)+1;
			System.out.print(num[k]+" ");
			
		}
		System.out.println();
		System.out.println(t1.getvalue(2));
	}
}
