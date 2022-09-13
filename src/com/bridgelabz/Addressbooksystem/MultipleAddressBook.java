package com.bridgelabz.Addressbooksystem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBook {
	private Map<String,MultipleContacts> addressBookMap;
	private MultipleContacts addressb;
	Scanner sc;
	public MultipleAddressBook() {
		addressBookMap=new HashMap<>();
		addressb=new MultipleContacts();
		sc=new Scanner(System.in);
	}
	public int displayChoice() {
		System.out.println("1.Add new Address Book");
		System.out.println("2.View Address Book List");
		System.out.println("3.Select Address Book to View Contact Details");
		System.out.println("4.Search Person By City");
		System.out.println("5.Search Person By State");
		System.out.println("6.Quit");
		System.out.println("Enter choice from 1 and 6");
		int choice=sc.nextInt();
		return choice;
	}
	public void addNewAddressBook() {
		System.out.println("Enter City Name For Address Book");
		String adbName=sc.next();
		adbName=adbName.toLowerCase();
		addressb.addContact();
		addressBookMap.put(adbName, addressb);
	}
	public void viewAddressBookList() {
		for(Map.Entry<String,MultipleContacts> m:addressBookMap.entrySet()) {
			System.out.println(m.getKey());
		}
	}
	public void selectAddressBook() {
		System.out.println("Enter Name of Address Book to View Contact");
		String adbName=sc.next();
		adbName=adbName.toLowerCase();
		for(Map.Entry<String,MultipleContacts> m:addressBookMap.entrySet()) {
			if(m.getKey().equals(adbName)) {
				addressb.performContactOperation((MultipleContacts)m.getValue());
			}
		}
		}

		public void searchContactByCityName() {
			System.out.println("Enter name of City to search contact");
			String city=sc.next();
			city=city.toLowerCase();
			if(addressBookMap.containsKey(city)) {
				MultipleContacts list=addressBookMap.get(city);
				list.showAllContacts();
			}
		}
		public void searchContactByStateName() {
			System.out.println("Enter name of State to search contact");
			String state=sc.next();
			state=state.toLowerCase();
			for(Map.Entry<String,MultipleContacts> m:addressBookMap.entrySet()) {
				MultipleContacts c;
				MultipleContacts nc=new MultipleContacts();
				c=m.getValue();
				Iterator<Contacts> i=c.contactArrayList.iterator();
				while(i.hasNext()) {
					Contacts con=i.next();
					if(state.equalsIgnoreCase(con.state)) {
						nc.contactArrayList.add(con);
					}
				}
				nc.showAllContacts();
			}
	}
	public static void main(String[] args) {
		MultipleAddressBook mab=new MultipleAddressBook();
		int choice;
		int flag=0;
		while(flag==0) {
			choice=mab.displayChoice();
			switch(choice) {
				case 1:
					mab.addNewAddressBook();
					break;
				case 2:
					mab.viewAddressBookList();
					break;
				case 3:
					mab.selectAddressBook();
					break;
				case 4:
					mab.searchContactByCityName();
					break;
				case 5:
					mab.searchContactByStateName();
					break;
					
				case 6:
					flag=1;
					break;
				default:
					System.out.println("You have Entered Wrong Choice.Please enter option between 1 to 6");
			}
		}
	}

}
