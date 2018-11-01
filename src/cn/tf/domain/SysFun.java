package cn.tf.domain;

public class SysFun {
	private String NodeId;
	private String DisplayName;
	private String NodeURL;
	private String DisplayOrder;
	private String ParentNodeId;
	public  SysFun (){

	}
	public String getNodeId() {
		return NodeId;
	}
	public void setNodeId(String nodeId) {
		NodeId = nodeId;
	}
	public String getDisplayName() {
		return DisplayName;
	}
	public void setDisplayName(String displayName) {
		DisplayName = displayName;
	}
	public String getNodeURL() {
		return NodeURL;
	}
	public void setNodeURL(String nodeURL) {
		NodeURL = nodeURL;
	}
	public String getDisplayOrder() {
		return DisplayOrder;
	}
	public void setDisplayOrder(String displayOrder) {
		DisplayOrder = displayOrder;
	}
	public String getParentNodeId() {
		return ParentNodeId;
	}
	public void setParentNodeId(String parentNodeId) {
		ParentNodeId = parentNodeId;
	}
	

}
