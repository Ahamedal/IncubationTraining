package zkart;

public class Product {
    
	private int productId;
	private String categoryName;
	private String brandName;
	private String modelName;
	private int priceOfProduct;
	private int stockOfProduct;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getPriceOfProduct() {
		return priceOfProduct;
	}
	public void setPriceOfProduct(int priceOfProduct) {
		this.priceOfProduct = priceOfProduct;
	}
	public int getStockOfProduct() {
		return stockOfProduct;
	}
	public void setStockOfProduct(int stockOfProduct) {
		this.stockOfProduct = stockOfProduct;
	}
	@Override
	public String toString() {
		return "[categoryName=" + categoryName + ", brandName=" + brandName + ", modelName=" + modelName
				+ ", priceOfProduct=" + priceOfProduct + "]";
	}
	
	
	
}
