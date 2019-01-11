package org.r.system.cs.dto.baseinfo;

public class EmployeeDTO {

	// 员工记录号
	private int id;
	// 员工编号
	private String code;
	// 员工姓名
	private String name;
	// 身份证
	private String idcard;
	// 性别
	private int sex;
	// 联系方式
	private String phone;
	// 联系地址
	private String address;
	// 职务
	private int jodtitle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getJodtitle() {
		return jodtitle;
	}

	public void setJodtitle(int jodtitle) {
		this.jodtitle = jodtitle;
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", code=" + code + ", name=" + name + ", idcard=" + idcard + ", sex=" + sex
				+ ", phone=" + phone + ", address=" + address + ", jodtitle=" + jodtitle + "]";
	}

}
