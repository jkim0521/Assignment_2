package mru;

/**
 * Program that allows users to add, search, or remove items
 * from a ToyStore company's database
 * @author Joseph Kim
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
