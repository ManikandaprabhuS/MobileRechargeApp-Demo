package packageMyApp;

public class User {
	private String phoneNumber;
	private String name;
	private String networkName;
	private MyPlan myplan;

	public User(String phoneNumber, String name, String networkName) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.networkName = networkName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public User() {
		super();
	}

	public MyPlan getMyplan() {
		return myplan;
	}

	public void setMyplan(MyPlan myplan) {
		this.myplan = myplan;
	}

	@Override
	public String toString() {
		return "User [phoneNumber=" + phoneNumber + ", name=" + name + ", networkName=" + networkName + ", myplan="
				+ myplan + "]";
	}

	public User(String phoneNumber, String name, String networkName, MyPlan myplan) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.networkName = networkName;
		this.myplan = myplan;
	}

}
