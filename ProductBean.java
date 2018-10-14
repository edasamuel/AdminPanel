package adminactions;

public class ProductBean {
	
	private static String category;
	private static String type;
	private static String item;
	private static String productName;
	private static String size;
	private static String price;
	private static String photo;
	
	
	public ProductBean() {	}
	public ProductBean(String cat, String ty, String it, String product, String si,String pri,String ph) {
		ProductBean.category = cat;
		ProductBean.type = ty;
		ProductBean.item = it;
		ProductBean.productName = product;
		ProductBean.size = si;
		ProductBean.price = pri;
		ProductBean.photo = ph;
	}
	public static String getCategory() {
		return category;
	}
	public static void setCategory(String category) {
		ProductBean.category = category;
	}
	public static String getType() {
		return type;
	}
	public static void setType(String type) {
		ProductBean.type = type;
	}
	public static String getItem() {
		return item;
	}
	public static void setItem(String item) {
		ProductBean.item = item;
	}
	public static String getProductName() {
		return productName;
	}
	public static void setProductName(String productname) {
		ProductBean.productName = productname;
	}
	public static String getSize() {
		return size;
	}
	public static void setSize(String size) {
		ProductBean.size = size;
	}
	public static String getPrice() {
		return price;
	}
	public static void setPrice(String price) {
		ProductBean.price = price;
	}
	public static String getPhoto() {
		return photo;
	}
	public static void setPhoto(String photo) {
		ProductBean.photo = photo;
	}
	
}
