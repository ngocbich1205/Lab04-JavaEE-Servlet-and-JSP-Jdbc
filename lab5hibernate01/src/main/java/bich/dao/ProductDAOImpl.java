package bich.dao;
import java.util.List;
import bich.entity.Product;
public class ProductDAOImpl implements ProductDAO {
	public List<Product> getAllProduct() {
		return null;
		}
		@Override
		public Product getProductById(String id) {
			return null;
		}
		@Override
		public boolean insertProduct(Product product) {
			return false;
		}
		@Override
		public boolean updateProduct(Product product) {
			return false;
		}
		@Override
		public boolean deleteProduct(String id) {
			return false;
		}
		
}

	public List<Product> getAllProduct() {
		Session session =HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			List<Product> list = session.createQuery("fromProduct").list();
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception ex) {
		ex.printStackTrace();
		session.close();
		}
	return null;
	}

	public Product getProductById(String id) {
	Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Product product = (Product)session.createQuery("from
			Product where MaSP = :maSp")
			
			.setParameter("maSp", id)
			.uniqueResult();
			session.getTransaction().commit();
			session.close();
			return product;
		} catch (Exception ex) {
	
		ex.printStackTrace();
		session.close();
		
		}
	return null;
	}

	public boolean insertProduct(Product product) {
	Session session =HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
		ex.printStackTrace();
		session.close();
		}
	return false;
	}

	public boolean updateProduct(Product product) {
		Session session =HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
			return false;
	}

	public boolean deleteProduct(String id) {
	Session session =
	HibernateUtil.getSessionFactory().openSession();
	try {
		session.beginTransaction();
	int res = session.createQuery("delete from Product where MaSP = :maSP")
		.setParameter("maSP", id)
		.executeUpdate();
		session.getTransaction().commit();
		session.close();
		if(res>0)
			return true;
	} catch (Exception ex) {
		ex.printStackTrace();
		session.close();	
	}
	return false;
	}