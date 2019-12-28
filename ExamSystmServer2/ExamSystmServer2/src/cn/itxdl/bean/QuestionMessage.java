package cn.itxdl.bean;

public class QuestionMessage implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private Question qmQuestrion;
	
	public QuestionMessage() {
		super();
	}
	public QuestionMessage(String type, Question qmQuestrion) {
		super();
		setType(type);
		setQmQuestrion(qmQuestrion);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Question getQmQuestrion() {
		return qmQuestrion;
	}
	public void setQmQuestrion(Question qmQuestrion) {
		this.qmQuestrion = qmQuestrion;
	}
	@Override
	public String toString() {
		return "QuestionMessage [type=" + type + ", qmQuestrion=" + qmQuestrion + "]";
	}
	
}
