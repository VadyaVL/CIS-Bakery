package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IProductPriceDAO;
import ua.bakery.db.jpa.ProductPrice;

public class ProductPriceDAO_DI {

	private IProductPriceDAO productpriceDAO;
	
	public ProductPriceDAO_DI(IProductPriceDAO productpriceDAO) {
		this.productpriceDAO = productpriceDAO;
	}

    
	public void saveProductPrice(ProductPrice productprice) {
		productpriceDAO.saveProductPrice(productprice);
	}

	public void updateProductPrice(ProductPrice productprice) {
		productpriceDAO.updateProductPrice(productprice);
	}

	public void deleteProductPrice(ProductPrice productprice) {
		productpriceDAO.deleteProductPrice(productprice);
	}

	public ProductPrice getProductPriceById(Integer productprice_id) {
		ProductPrice productprice = productpriceDAO.getProductPriceById(productprice_id);
		return productprice;
	}

	public Integer getAllProductPriceCount() {
		Integer cnt = productpriceDAO.getAllProductPriceCount();
		return cnt;
	}

	public Collection<ProductPrice> getAllProductPrice() {
		List<ProductPrice> productprices = (List<ProductPrice>) productpriceDAO.getAllProductPrice();
		return productprices;
	}


}
