package com.liao.sample.j2eebase.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


public class CollectionModifyException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collection user=new ArrayList();
		user=new CopyOnWriteArrayList();
		Iterator itrUsers=user.iterator();
		while(itrUsers.hasNext()){
			Object object=itrUsers.next();
			if(true){
				user.remove(object);
			}
		}
	}

}
