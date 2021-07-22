package friendDB.vo;

//Value Object, 값을 가지고 있는 객체, bean이라고 한다
public class FriendVo {
	private int friendNo;
	private String friendName;
	private String friendMobile;
	private String friendAddress;
	
	public FriendVo(int friendNo, String friendName, String friendMobile, String friendAddress) {
		super();
		this.friendNo = friendNo;
		this.friendName = friendName;
		this.friendMobile = friendMobile;
		this.friendAddress = friendAddress;
	}

	public int getFriendNo() {
		return friendNo;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getFriendMobile() {
		return friendMobile;
	}

	public void setFriendMobile(String friendMobile) {
		this.friendMobile = friendMobile;
	}

	public String getFriendAddress() {
		return friendAddress;
	}

	public void setFriendAddress(String friendAddress) {
		this.friendAddress = friendAddress;
	}
	
	
}
