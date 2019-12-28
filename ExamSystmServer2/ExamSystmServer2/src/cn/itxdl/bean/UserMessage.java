package cn.itxdl.bean;

public class UserMessage implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String type;
	private User umUser;
	
	public UserMessage() {
		super();
	}
	public UserMessage(String type, User umUser) {
		super();
		setType(type);
		setUmUser(umUser);
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User getUmUser() {
		return umUser;
	}
	public void setUmUser(User umUser) {
		this.umUser = umUser;
	}
	@Override
	public String toString() {
		return "UserMessage [type=" + type + ", umUser=" + umUser + "]";
	}
}
