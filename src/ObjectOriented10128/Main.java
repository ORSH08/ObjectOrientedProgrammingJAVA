
//Or Shemesh 209523489
//Gal Shemesh 322387481
//lecturer - Eyal

package ObjectOriented10128;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TradeMarket tradeMarket = new TradeMarketSystem();

		try (Scanner scanner = new Scanner(System.in)) {

			boolean keepRunning = true;

			while (keepRunning) {
				// print menu
				System.out.println(
						"\nWelcome to the market!\n-----------------------------\nSelect an action:\n-----------------------------");
				System.out.println("0 - Exit");
				System.out.println("1 - To add seller");
				System.out.println("2 - To add buyer");
				System.out.println("3 - To add product to a seller");
				System.out.println("4 - To add product to a buyer");
				System.out.println("5 - To tranfer payment for buyer's order");
				System.out.println("6 - To Display details of all buyers");
				System.out.println("7 - To Display details of all sellers\n-----------------------------");
				String choice = scanner.nextLine();

				switch (choice) {
				case "0":
					keepRunning = false;
					System.out.println("Exiting the program...");
					break;

				case "1":
					addSeller(tradeMarket, scanner);
					break;

				case "2":
					addBuyer(tradeMarket, scanner);
					break;

				case "3":
					addProductToSeller(tradeMarket, scanner);
					break;

				case "4":
					addProductToBuyer(tradeMarket, scanner);
					break;

				case "5":
					payment(tradeMarket, scanner);
					break;

				case "6":
					displayBuyers(tradeMarket);
					break;

				case "7":
					displaySellers(tradeMarket);
					break;

				default:
					System.out.println("Invalid selection. please try again.");
					break;

				}

			}

		}
	}

	// Add seller to trade market
	private static void addSeller(TradeMarket tradeMarket, Scanner scanner) {
		System.out.println("Please enter the seller username");
		String sellerUserName = scanner.nextLine();
		Seller seller = new Seller(sellerUserName);
		// check input
		boolean again = true;
		while (again) {
			if (!tradeMarket.addSeller(seller)) {
				System.out.println("This user name already exist in system , please try again to enter user name");
				seller.setUserName(scanner.nextLine());

			} else {
				again = false;

			}

		}
		System.out.println("Please enter the seller password");
		seller.setPassword(scanner.nextLine());
		System.out.println("Seller added to market");
	}

	// Add buyer to trade market
	private static void addBuyer(TradeMarket tradeMarket, Scanner scanner) {
		System.out.println("Please enter the buyer username");
		String buyerUserName = scanner.nextLine();
		Buyer buyer = new Buyer(buyerUserName);
		// check input
		boolean again = true;
		while (again) {

			if (!tradeMarket.addBuyer(buyer)) {
				System.out.println("This user name already exist in system , please try again to enter user name");
				buyer.setUserName(scanner.nextLine());

			} else {
				again = false;

			}
		}
		System.out.println("Please enter the buyer password");
		buyer.setPassword(scanner.nextLine());
		System.out.println("plaese enter your address: ");
		System.out.println("please enter country: ");
		String country = scanner.nextLine();
		System.out.println("please enter city: ");
		String city = scanner.nextLine();
		System.out.println("please enter street: ");
		String street = scanner.nextLine();
		System.out.println("please enter building number: ");
		String buildingNum = scanner.nextLine();
		Address ad = new Address(street, buildingNum, city, country);
		buyer.setAddress(ad);
		System.out.println("Buyer added to market");

	}

	// Add product to seller
	private static void addProductToSeller(TradeMarket tradeMarket, Scanner scanner) {
		if (tradeMarket.getSellers().length != 0) {
			System.out.println("Please enter the username of the seller to add product");
			String sellerNameToAddProduct = scanner.nextLine();
			// check input
			int index = tradeMarket.isExistSellers(sellerNameToAddProduct);
			while (index == -1) {
				System.out.println("Seller not found, please try again");
				sellerNameToAddProduct = scanner.nextLine();
				index = tradeMarket.isExistSellers(sellerNameToAddProduct);
			}

			System.out.println("Please enter product name");
			String productName = scanner.nextLine();
			System.out.println("Please enter product price");
			String productPrice = scanner.nextLine();
			System.out.println("Please enter product category");
			System.out.println("categories:");
			for (Category c : Category.values()) {
				System.out.println("\t" + c);
			}
			Category category = Category.valueOf(scanner.nextLine().toUpperCase());
			Product pr = new Product(productName, Double.valueOf(productPrice), category);
			tradeMarket.addProductToSeller(pr, index);
			System.out.println("product added to seller: " + sellerNameToAddProduct);
		} else {
			System.out.println("There are no sellers");
		}

	}

	// Add product to buyer (costumer) cart
	private static void addProductToBuyer(TradeMarket tradeMarket, Scanner scanner) {
		if (tradeMarket.getBuyers().length != 0) {
			System.out.println("Please choose the buyer to add product to from the list below");
			displayBuyersNames(tradeMarket);
			String buyerNameToAddProduct = scanner.nextLine();
			// check input
			int indexBuyer = tradeMarket.isExistBuyers(buyerNameToAddProduct);
			while (indexBuyer == -1) {
				System.out.println("Buyer not found, please try again");
				buyerNameToAddProduct = scanner.nextLine();
				indexBuyer = tradeMarket.isExistBuyers(buyerNameToAddProduct);
			}
			if (tradeMarket.getSellers().length == 0) {
				System.out.println("There are no sellers in the market");
			} else {
				System.out.println("Please choose from the list below a seller you would like to buy from");
				displaySellersNames(tradeMarket);
				String sellerNameToChooseFrom = scanner.nextLine();
				// check input
				int indexSeller = tradeMarket.isExistSellers(sellerNameToChooseFrom);
				while (indexSeller == -1) {
					System.out.println("Seller not found, please try again");
					sellerNameToChooseFrom = scanner.nextLine();
					indexSeller = tradeMarket.isExistSellers(sellerNameToChooseFrom);
				}

				System.out.println("the products you can choose from are:");
				Product[] productsToDisplay = tradeMarket.getSellerProducts(indexSeller);
				if (productsToDisplay.length != 0) {
					for (Product pr : productsToDisplay) {
						System.out.println(pr.toString() + ", ");
					}
					System.out.println();
					String productToAdd = scanner.nextLine();
					boolean successful = tradeMarket.addProductToBuyer(productToAdd, indexSeller, indexBuyer);
					// check if input in valid, if its valid it means the adding was successful
					while (successful == false) {
						System.out.println("product not found,try again");
						productToAdd = scanner.nextLine();
						successful = tradeMarket.addProductToBuyer(productToAdd, indexSeller, indexBuyer);

					}
					System.out.println("product added to buyers cart");
				} else {
					System.out.println("This seller has no products to sell");
				}
			}
		} else {
			System.out.println("There are no buyers");
		}

	}

	// To payment a cart for buyer (costumer)
	private static void payment(TradeMarket tradeMarket, Scanner scanner) {
		if (tradeMarket.getBuyers().length != 0) {
			System.out.println("Please enter buyer name to pay for");
			String buyerNameToPayFor = scanner.nextLine();
			int index = tradeMarket.isExistBuyers(buyerNameToPayFor);
			while (index == -1) {
				System.out.println("Buyer not found, please try again");
				buyerNameToPayFor = scanner.nextLine();
				index = tradeMarket.isExistBuyers(buyerNameToPayFor);

			}
			Buyer buyer = tradeMarket.getBuyers()[index];
			if (buyer.getBalance() != 0) {
				System.out.println("The balance is : " + buyer.getBalance() + " would you like to pay? y/n");
				String pay = scanner.nextLine();
				while (!pay.equals("n") && !pay.equals("y")) {
					System.out.println("what?????????? or y or n ");
					pay = scanner.nextLine();
				}

				if (pay.equals("y")) {
					tradeMarket.payment(index);
					System.out.println("cart paid successfuly!");
				}
			} else {
				System.out.println("the cart is empty");
			}
		} else {
			System.out.println("There are no buyers");
		}

	}

	// displays all buyers user name
	private static void displayBuyersNames(TradeMarket tradeMarket) {
		Buyer[] buyersToDisplay = tradeMarket.getBuyers();
		if (buyersToDisplay.length == 0) {
			System.out.println("there are no buyers in the system");
		} else {
			System.out.println("The buyers are:\n");
			for (Buyer buyer : buyersToDisplay) {
				System.out.println(buyer.getUserName());
			}

			System.out.println();

		}

	}

	// displays all sellers user name
	private static void displaySellersNames(TradeMarket tradeMarket) {
		Seller[] sellersToDisplay = tradeMarket.getSellers();
		if (sellersToDisplay.length == 0) {
			System.out.println("there are no sellers in the system");
		} else {
			System.out.println("The sellers are: \n");
			for (Seller seller : sellersToDisplay) {
				System.out.println(seller.getUserName());
			}

			System.out.println();

		}
	}

	private static void displayBuyers(TradeMarket tradeMarket) {
		Buyer[] buyersToDisplay = tradeMarket.getBuyers();
		if (buyersToDisplay.length != 0) {
			System.out.println("The buyers in the market are:");
			for (Buyer buyer : buyersToDisplay) {
				System.out.println(buyer.toString());
				System.out.println("The current cart is: ");
				Cart currentCart = buyer.getCurrentCart();
				if (currentCart.getAllProducts().length == 0) {
					System.out.println("No products in current cart\n");
				} else {
					System.out.println("balance: " + buyer.getBalance());
					System.out.println("The items in cart is: ");
					System.out.println(Arrays.toString(currentCart.getAllProducts()));

				}
				System.out.println();
				System.out.println("The orders history is:\n");
				Cart[] history = buyer.getAllCarts();
				if (history.length == 0) {
					System.out.println("No prior orders\n");
				} else {
					for (Cart cart : history) {
						System.out.println(cart.toString());
						System.out.println(Arrays.toString(cart.getAllProducts()));
						System.out.println();
					}
				}
				System.out.println();
			}
		} else {
			System.out.println("There are no buyers in the market");
		}
	}

	private static void displaySellers(TradeMarket tradeMarket) {
		Seller[] sellersToDisplay = tradeMarket.getSellers();
		if (sellersToDisplay.length != 0) {
			System.out.println("The sellers in the market are:");
			for (Seller seller : sellersToDisplay) {
				System.out.println(seller.toString());
				if (seller.getAllProducts().length != 0) {
					System.out.println("the products are:");
					System.out.println(Arrays.toString(seller.getAllProducts()));
					System.out.println();
				} else {
					System.out.println("There are no products");
				}

			}
		}

		else {
			System.out.println("There are no sellers in the market");
		}
	}

}
