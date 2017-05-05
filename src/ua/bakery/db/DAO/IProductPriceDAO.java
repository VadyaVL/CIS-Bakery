package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.ProductPrice;

/**
* @author vadym
* @since 0.12
*/
public interface IProductPriceDAO extends IGenericDAO<ProductPrice> {
	public void saveProductPrice(ProductPrice productprice);
	public void updateProductPrice(ProductPrice productprice);
	public ProductPrice getProductPriceById(Integer productprice_id);
	public Integer getAllProductPriceCount();
	public Collection<ProductPrice> getAllProductPrice();
	public void deleteProductPrice(ProductPrice productprice);

}