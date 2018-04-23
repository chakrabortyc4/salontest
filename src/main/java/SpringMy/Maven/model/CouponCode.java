package SpringMy.Maven.model;

public class CouponCode {

	private String userId;
	private String persent;
	
	public CouponCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CouponCode(String userId, String persent) {
		super();
		this.userId = userId;
		this.persent = persent;
	}

	public String getPersent() {
		return persent;
	}


	public void setPersent(String persent) {
		this.persent = persent;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
