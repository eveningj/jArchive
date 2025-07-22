package kr.co.food.model.vo;

public class CartItem {
	private Product product;  
	private int amount;       

	public CartItem() {}

	public CartItem(Product product, int amount) {
		this.product = product;
		this.amount = amount;
	}

	// Getter/Setter
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	public String getType() {
		return product.getType();
	}

	
	public int getFinalPrice() {
		int price = product.getPrice();
		if ("콤보".equals(getType())) {
			price = (int)(price * 0.8);  // 20% 할인
		}
		return price * amount;
	}

}
