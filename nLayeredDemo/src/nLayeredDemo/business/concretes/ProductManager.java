package nLayeredDemo.business.concretes;

import java.util.List;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.entities.concretes.Product;

public class ProductManager implements ProductService {

	//dependency injection 
	private ProductDao productDao;
	private LoggerService loggerService;
		
	
	public ProductManager(ProductDao productDao, LoggerService loggerService) {
		super();
		this.productDao = productDao;
		this.loggerService=loggerService;
	}

	@Override
	public void add(Product product) {
		//iş kodları
		if(product.getCategoryId()==1) {
			System.out.println("Bu kategoride ürün kabul edilmiyor!!!");
			return;
		}
		//katı bagımlı
		//HibernateProductDao dao=new HibernateProductDao();
		//dao.add(product);
		
		
		this.productDao.add(product);
		this.loggerService.logToSystem("Ürün eklendi " + product.getName());
		
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}