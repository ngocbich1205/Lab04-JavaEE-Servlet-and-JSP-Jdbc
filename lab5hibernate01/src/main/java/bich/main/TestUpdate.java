package bich.main;

import java.util.List;

import bich.dao.ProductDAOImpl;
import bich.entity.Product;

public class TestUpdate{
public static void main(String[] args) {
	Product p = new ProductDAOImpl().getProductById("P005");
	p.setMaSP("P005");
	p.setTenSanPham("Kệ để giày hàn quốc");
	p.setAnhSanPham("P005.jpg");
	p.setSoLuong(150);
	p.setDonGia(2990000d);
	boolean flag = new ProductDAOImpl().updateProduct(p);
	if(flag==true) {
		System.out.println("Sửa đổi dữ liệu thành công!");
	}else {
		System.out.println("Sảy ra lỗi khi sửa sản phẩm");
	}
}
}
