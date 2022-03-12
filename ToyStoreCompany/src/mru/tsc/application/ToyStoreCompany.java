package mru.tsc.application;

import mru.tsc.controller.Navigation;
import mru.tsc.view.Menu;

/**
 * Program that allows users to add, search, or remove items
 * from a ToyStore company's database
 * @author Joseph Kim & Skylar Wiltse
 *
 */
public class ToyStoreCompany {
	public static void main(String[]args) {
		Navigation navi = new Navigation();
		Menu menu = new Menu();
		menu.welcomeMessage();
		navi.mainMenu();
	}

}
