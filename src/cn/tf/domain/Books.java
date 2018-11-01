package cn.tf.domain;

public class Books {
	private String Id;
	private String Title;
	private String Author;
	private String PublisherId;
	private String PublishDate;
	private String ISBN;
	private String WordsCount;
	private String UnitPrice;
	private String ContentDescription;
	private String AurhorDescription;
	private String EditorComment;
	private String TOC;
	private String CategoryId;
	private String Clicks;
	public Books() {
		
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublisherId() {
		return PublisherId;
	}
	public void setPublisherId(String publisherId) {
		PublisherId = publisherId;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getWordsCount() {
		return WordsCount;
	}
	public void setWordsCount(String wordsCount) {
		WordsCount = wordsCount;
	}
	public String getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		UnitPrice = unitPrice;
	}
	public String getContentDescription() {
		return ContentDescription;
	}
	public void setContentDescription(String contentDescription) {
		ContentDescription = contentDescription;
	}
	public String getAurhorDescription() {
		return AurhorDescription;
	}
	public void setAurhorDescription(String aurhorDescription) {
		AurhorDescription = aurhorDescription;
	}
	public String getEditorComment() {
		return EditorComment;
	}
	public void setEditorComment(String editorComment) {
		EditorComment = editorComment;
	}
	public String getTOC() {
		return TOC;
	}
	public void setTOC(String tOC) {
		TOC = tOC;
	}
	public String getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}
	public String getClicks() {
		return Clicks;
	}
	public void setClicks(String clicks) {
		Clicks = clicks;
	}
}
