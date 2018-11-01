package cn.tf.domain;

public class ActionInfo {
	private String ID;
	private String ActionInfoName;
	private String Url;
	private String HttpMethod;
	private String Remark;
	private String DelFalg;
	private String SubTime;
	private String IsMenu;
	private String R_UserInfo_ActionInfoID;
	
	public ActionInfo() {
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getActionInfoName() {
		return ActionInfoName;
	}
	public void setActionInfoName(String actionInfoName) {
		ActionInfoName = actionInfoName;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getHttpMethod() {
		return HttpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		HttpMethod = httpMethod;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getDelFalg() {
		return DelFalg;
	}
	public void setDelFalg(String delFalg) {
		DelFalg = delFalg;
	}
	public String getSubTime() {
		return SubTime;
	}
	public void setSubTime(String subTime) {
		SubTime = subTime;
	}
	public String getIsMenu() {
		return IsMenu;
	}
	public void setIsMenu(String isMenu) {
		IsMenu = isMenu;
	}
	public String getR_UserInfo_ActionInfoID() {
		return R_UserInfo_ActionInfoID;
	}
	public void setR_UserInfo_ActionInfoID(String r_UserInfo_ActionInfoID) {
		R_UserInfo_ActionInfoID = r_UserInfo_ActionInfoID;
	}
}
