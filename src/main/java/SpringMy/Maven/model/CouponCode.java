package SpringMy.Maven.model;

public class CouponCode {

	private String userId;
	private String clubData;
	private String persent;
	
	public CouponCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CouponCode(String userId, String clubData, String persent) {
		super();
		this.userId = userId;
		this.clubData = clubData;
		this.persent = persent;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClubData() {
		return clubData;
	}

	public void setClubData(String clubData) {
		this.clubData = clubData;
	}

	public String getPersent() {
		return persent;
	}

	public void setPersent(String persent) {
		this.persent = persent;
	}



	@Override
	public String toString() {
		return "CouponCode [userId=" + userId + ", clubData=" + clubData + ", persent=" + persent + "]";
	}

	

}
