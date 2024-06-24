package ObjectOriented10128;

public class Product {

	private String itemName;
	private double price;
	private Category category;

	public Product(String itemName, double price, Category category) {
		this.itemName = itemName;
		this.price = price;
		this.category = category;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "itemName: " + itemName + ", price: " + price + ", category: " + category;
	}
}