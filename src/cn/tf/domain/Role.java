package cn.tf.domain;

public class Role {
	private String ID;
	private String RoleName;
	private String DelFlag;
	private String RoleType;
	private String SubTime;
	private String Remark;
	public Role() {
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	public String getDelFlag() {
		return DelFlag;
	}
	public void setDelFlag(String delFlag) {
		DelFlag = delFlag;
	}
	public String getRoleType() {
		return RoleType;
	}
	public void setRoleType(String roleType) {
		RoleType = roleType;
	}
	public String getSubTime() {
		return SubTime;
	}
	public void setSubTime(String subTime) {
		SubTime = subTime;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
}
