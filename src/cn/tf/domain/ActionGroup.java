package cn.tf.domain;

public class ActionGroup {
	private String ID;
	private String GroupName;
	private String GroupType;
	private String DelFlag;
	private String Sort;
	
	public ActionGroup() {
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public String getGroupType() {
		return GroupType;
	}
	public void setGroupType(String groupType) {
		GroupType = groupType;
	}
	public String getDelFlag() {
		return DelFlag;
	}
	public void setDelFlag(String delFlag) {
		DelFlag = delFlag;
	}
	public String getSort() {
		return Sort;
	}
	public void setSort(String sort) {
		Sort = sort;
	}
}
