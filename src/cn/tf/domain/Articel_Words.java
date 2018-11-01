package cn.tf.domain;

public class Articel_Words {
	private String Id;
	private String WordPattern;
	private String IsForbid;
	private String IsMod;
	private String ReplaceWord;
	public Articel_Words() {
		
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getWordPattern() {
		return WordPattern;
	}
	public void setWordPattern(String wordPattern) {
		WordPattern = wordPattern;
	}
	public String getIsForbid() {
		return IsForbid;
	}
	public void setIsForbid(String isForbid) {
		IsForbid = isForbid;
	}
	public String getIsMod() {
		return IsMod;
	}
	public void setIsMod(String isMod) {
		IsMod = isMod;
	}
	public String getReplaceWord() {
		return ReplaceWord;
	}
	public void setReplaceWord(String replaceWord) {
		ReplaceWord = replaceWord;
	}
}
