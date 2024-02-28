package bich.main;

import java.util.List;

import bich.dao.ProductDAOImpl;

public class TestDelete{
public static void main(String[] args) {
	boolean flag = new ProductDAOImpl().deleteProduct("P005");
	if(flag==true) {
		System.out.println("Đã xóa sản phẩm có mã P005!");
	}else {
		System.out.println("Sảy ra lỗi khi xóa sản phẩm");
	}
}
}
