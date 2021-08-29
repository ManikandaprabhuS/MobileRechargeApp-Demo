package packageMyApp;

public class MyPlan {
	private String packType;
	private int planPrice;
	private int noOfRecharge;
	private double totalPrice;

	public MyPlan(String packType, int planPrice) {
		super();
		this.packType = packType;
		this.planPrice = planPrice;
	}

	public String getPlanType() {
		return packType;
	}

	public void setPlanType(String packType) {
		this.packType = packType;
	}

	public int getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(int planPrice) {
		this.planPrice = planPrice;
	}

	public MyPlan(String string) {
		super();
	}

	@Override
	public String toString() {
		return "MyPlan [packType=" + packType + ", planPrice=" + planPrice + "]";
	}

	public int getNoOfRecharge() {
		return noOfRecharge;
	}

	public void setNoOfRecharge(int noOfRecharge) {
		this.noOfRecharge = noOfRecharge;
	}

	public MyPlan(String packType, int planPrice, int noOfRecharge) {
		super();
		this.packType = packType;
		this.planPrice = planPrice;
		this.noOfRecharge = noOfRecharge;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public MyPlan(String packType, int planPrice, int noOfRecharge, double totalPrice) {
		super();
		this.packType = packType;
		this.planPrice = planPrice;
		this.noOfRecharge = noOfRecharge;
		this.totalPrice = totalPrice;
	}

}
