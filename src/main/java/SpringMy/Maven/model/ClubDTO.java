package SpringMy.Maven.model;

public class ClubDTO {
	
	private String club;
	private Integer members_count;
	
	public ClubDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubDTO(String club, Integer members_count) {
		super();
		this.club = club;
		this.members_count = members_count;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public Integer getMembers_count() {
		return members_count;
	}

	public void setMembers_count(Integer members_count) {
		this.members_count = members_count;
	}

	@Override
	public String toString() {
		return "ClubDTO [club=" + club + ", members_count=" + members_count + "]";
	}

	
    
}
