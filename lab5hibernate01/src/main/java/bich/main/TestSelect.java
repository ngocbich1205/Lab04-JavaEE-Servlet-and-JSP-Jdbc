package bich.main;

import java.util.List;

import bich.dao.ProductDAOImpl;
import bich.entity.Product;

public class TestSelect {

	public static void main(String[] args) {
		List<Product> list = new
				ProductDAOImpl().getAllProduct();
		if(list == null)
			return;
		for(Product item:list) {
			System.out.printf("\n%-10s",item.getMaSP());
			System.out.printf("%-15s",item.getTenSanPham());
			System.out.printf("% 15d",item.getSoLuong());
			System.out.printf("% 15.0f",item.getDonGia());
		}
	}
}
