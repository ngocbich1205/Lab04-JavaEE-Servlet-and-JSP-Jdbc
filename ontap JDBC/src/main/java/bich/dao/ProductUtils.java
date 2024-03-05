package bich.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bich.entity.Department;

public class ProductUtils {

   public static List<Department> queryProduct(Connection conn) throws SQLException {
       String sql = "Select * from Department a ";
       PreparedStatement pstm = conn.prepareStatement(sql);
       ResultSet rs = pstm.executeQuery();
       List<Department> list = new ArrayList<Department>();
       while (rs.next()) {
           int DEPT_ID = rs.getInt("DEPT_ID");
           String DEPT_NAME = rs.getString("DEPT_NAME");
           String DEPT_NO = rs.getString("DEPT_NO");
           String LOCATION = rs.getString("LOCATION");
           Department department = new Department();
           department.setDeptId(DEPT_ID);
           department.setDeptName(DEPT_NAME);
           department.setDeptNo(DEPT_NO);
           department.setLocation(LOCATION);
           list.add(department);
       }
       return list;
   }

}