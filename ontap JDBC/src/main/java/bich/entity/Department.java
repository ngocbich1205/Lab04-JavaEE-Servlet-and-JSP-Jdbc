package bich.entity;
public class Department {
	   
	private Integer deptId;
	private String deptName;
	private String deptNo;
	private String location;

	   public Department() {
	   }

	   public Department(int deptId, String deptName, String deptNo) {
	       this.deptId = deptId;
	       this.deptName = deptName;
	       this.deptNo = deptNo;
	   }

	   public Department(int deptId, String deptName, String deptNo, String location) {
	       this.deptId = deptId;
	       this.deptName = deptName;
	       this.deptNo = deptNo;
	       this.location = location;
	   }

	   public int getDeptId() {
	       return this.deptId;
	   }

	   public void setDeptId(int deptId) {
	       this.deptId = deptId;
	   }

	   public String getDeptName() {
	       return this.deptName;
	   }

	   public void setDeptName(String deptName) {
	       this.deptName = deptName;
	   }

	   public String getDeptNo() {
	       return this.deptNo;
	   }

	   public void setDeptNo(String deptNo) {
	       this.deptNo = deptNo;
	   }

	   public String getLocation() {
	       return this.location;
	   }

	   public void setLocation(String location) {
	       this.location = location;
	   }


	}
