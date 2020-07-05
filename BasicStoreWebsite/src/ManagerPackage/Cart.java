package ManagerPackage;

import java.util.HashMap;

public class Cart {
	private HashMap<String, Integer> mp;
	private Double total;
	public Cart() {
		mp = new HashMap<String, Integer>();
		total = 0.0;
	}
	public void addProduct(String id, Double price){
		if(mp.containsKey(id)) {
			mp.put(id, mp.get(id).intValue()+1);
		} else {
			mp.put(id, 1);
		}
		total += price;
	}
	public Double getTotal() {
		return total;
	}
	public void updateCart() {
		
	}
	public HashMap<String,Integer> getMp(){
		return mp;
	}
	
}
