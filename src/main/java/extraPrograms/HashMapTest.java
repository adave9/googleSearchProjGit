package extraPrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class HashMapTest {

	public static void main(String[] args) {
		
		Map<Integer,String> map = new HashMap<>();
		
		map.put(101,"One O One");
		map.put(null,"Two O Two");
		map.put(null,"Three0 O Three");
		
		map.put(101,"One O One");
		map.put(102,"One O Two");
		map.put(103,"One O Three");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Int:");
		int keyVal = sc.nextInt();
		System.out.println("Enter String:");
		String val = sc.next();
		
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
//			System.out.println("Enter id:");
//			int x = sc.nextInt();
//			
//			System.out.println("Enter value:");
//			String src = sc.next();
			
			//System.out.println("Key :"+entry.getKey());
			//System.out.println("Value :"+entry.getValue());
			
			
			if(map.containsKey(keyVal)) {
				map.put(keyVal,val);
			}
		}
		
		
		System.out.println(map);
		
		
	}
}
