package com.addressBook.IOStream;

import java.util.ArrayList;

public class Address_Book {
	private ArrayList<Contacts> arrList = new ArrayList<Contacts>();

	public boolean addToAddressBook(Contacts con) {
		if (getArrList().contains(con)) {
			System.out.println("Sorry! The details already exist...");
			return false;
		}
		getArrList().add(con);
		return true;
	}

	public void printArrayList() {
		System.out.println("Updated array list is: ");
		System.out.println(getArrList());
	}

	public ArrayList<Contacts> getArrList() {
		return arrList;
	}

	public int getArrListSize() {
		return arrList.size();
	}
}