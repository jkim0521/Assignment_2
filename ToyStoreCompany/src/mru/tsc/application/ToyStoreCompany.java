package mru.tsc.application;

import java.io.IOException;

import mru.tsc.controller.Navigation;
import mru.tsc.view.Menu;

/**
 * Program that allows users to add, search, or remove items
 * from a ToyStore company's database
 * @author Joseph Kim
 *
 */
public class ToyStoreCompany {
	public static void main(String[]args) throws RuntimeException, IOException {
		Navigation navi = new Navigation();
		Menu menu = new Menu();
		menu.welcomeMessage();
		navi.mainMenu();
	}

}
