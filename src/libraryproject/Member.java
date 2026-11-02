package libraryproject;

public class Member {
	private String memberName ;
	private int memberId;
	
	public Member(String memberName,int memberId) {
		this.memberName = memberName;
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String toString() {
		return "Member{Member name :"+this.memberName+" Member ID= " + this.memberId; 
	}
}
