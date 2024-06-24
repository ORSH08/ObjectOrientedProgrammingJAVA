package ObjectOriented10128;

import java.util.Optional;

public class Seller extends Person {

	private ProductListNode first;
	private int countProducts;

	public Seller(String sellerUserName) {
		super(sellerUserName);
		this.first = null;
		this.countProducts = 0;
	}

	public ProductListNode getProduct() {
		return first;
	}

	public void setProduct(Product pr) {
		if (this.first == null) {
			this.first = new ProductListNode(pr);
		} else {
			ProductListNode node = this.first;
			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(new ProductListNode(pr));
		}
		this.countProducts++;
	}

	public Optional<Product> getProductByName(String prName) {
		for (ProductListNode node = this.first; node != null; node = node.getNext()) {
			if (node.getProduct().getItemName().equals(prName)) {
				Product pr = node.getProduct();

				return Optional.of(pr);
			}
		}
		return Optional.empty();
	}

	public int getCountProducts() {
		return countProducts;
	}

	public void setCountProducts(int countProducts) {
		this.countProducts = countProducts;
	}

	public Product[] getAllProducts() {
		Product[] rv = new Product[this.countProducts];
		int i = 0;
		for (ProductListNode node = this.first; node != null; node = node.getNext()) {
			rv[i++] = node.getProduct();
		}
		return rv;
	}

}
