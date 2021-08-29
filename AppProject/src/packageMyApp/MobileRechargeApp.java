package packageMyApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MobileRechargeApp implements MyPay {

	List<User> userList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		List<String> checkPhoneList = new ArrayList<>();
		MobileRechargeApp mra = new MobileRechargeApp();
		char c = 'q';
		Scanner sc = new Scanner(System.in);
		do {
			try {
				List<MyPlan> smartplanList = new ArrayList<>();
				List<MyPlan> dataplanList = new ArrayList<>();
				System.out.println("***************************************");
				System.out.println("Welcome To MyPAy Application");
				System.out.println("***************************************");
				System.out.println("Enter PhoneNumber To Login:");
				String phoneNumber = sc.next();
				if (phoneNumber.length() != 10) {
					throw new Exception("Enter Valid Number TO Recharge");
				} else if ((checkPhoneList.contains(phoneNumber))) {
					throw new Exception("This Number is Already Taken");
				} else {
					checkPhoneList.add(phoneNumber);
				}
				System.out.println("Enter the Name : ");
				String name = sc.next();
				System.out.println("Enter the Network Name ");
				String networkName = sc.next();
				User user = new User(phoneNumber, name, networkName);
				System.out.println("Select the Recharge Pack for You");
				System.out.println("1).Smart Recharge");
				System.out.println("2).Data Recharge");
				mra.showPackPlans(user);
				c = sc.next().charAt(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (c != 'q');

	}

	public void showPackPlans(User user) {
		MobileRechargeApp mra = new MobileRechargeApp();
		Scanner sc = new Scanner(System.in);
		int packType = sc.nextInt();
		List<MyPlan> smartplanList = new ArrayList<>();
		List<MyPlan> dataplanList = new ArrayList<>();
		String planType = "";
		if (packType == 1) {
			smartplanList = mra.dispalySmartPlanList();
			for (MyPlan my : smartplanList) {
				System.out.println(my.getPlanType());
			}
			planType = sc.next();
			int n = Integer.parseInt(planType) - 1;
			for (MyPlan my : smartplanList) {
				if (smartplanList.get(n).equals(my)) {
					System.out.println(my.getPlanType());
					user.setMyplan(my);
				}
			}
			userList.add(user);
			System.out.println("How many Number You need To Recharge ? ");
			int n1 = sc.nextInt();
			user.getMyplan().setNoOfRecharge(n1);
			for (int i = 1; i <= n1; i++) {
				System.out.println("Enter" + i + " PhoneNumber:");
				String phoneNumber1 = sc.next();
				user.setPhoneNumber(phoneNumber1);
				billReceipt(user);
				// System.out.println(user);
			}
			invoiceMessage(user);
		} else if (packType == 2) {
			dataplanList = mra.dispalyDataPlanList();
			for (MyPlan my : dataplanList) {
				System.out.println(my.getPlanType());
			}
			planType = sc.next();
			int n = Integer.parseInt(planType) - 1;
			for (MyPlan my : dataplanList) {
				if (dataplanList.get(n).equals(my)) {
					System.out.println(my.getPlanType());
					user.setMyplan(my);
				}
			}
			userList.add(user);
			System.out.println("How many Number You need To Recharge ? ");
			int n1 = sc.nextInt();
			for (int i = 1; i <= n1; i++) {
				System.out.println("Enter" + i + " PhoneNumber:");
				String phoneNumber1 = sc.next();
				user.setPhoneNumber(phoneNumber1);
				billReceipt(user);
				// System.out.println(user);
			}
			invoiceMessage(user);
			System.out.println();

		} else {
			System.out.println("Select the Valid Pack");
		}
	}

	List<MyPlan> dispalySmartPlanList() {
		List<MyPlan> smartplanList = new ArrayList<>();
		smartplanList.add(new MyPlan("1).plan value:48  DataPack:1GB validity:1d", 48));
		smartplanList.add(new MyPlan("2).plan value:199  DataPack:1GB validity:1d", 199));
		smartplanList.add(new MyPlan("3).plan value:448  DataPack:1GB validity:1d", 448));
		return smartplanList;
	}

	List<MyPlan> dispalyDataPlanList() {
		List<MyPlan> dataplanList = new ArrayList<>();
		dataplanList.add(new MyPlan("1).plan value:199  DataPack:1GB validity:N/A", 199));
		dataplanList.add(new MyPlan("2).plan value:98  DataPack:1GB validity:N/A", 98));
		dataplanList.add(new MyPlan("3).plan value:599  DataPack:1GB validity:N/A", 599));
		return dataplanList;
	}

	@Override
	public void billReceipt(User user) {
		double tax = 6.6;
		double totalPrice = (user.getMyplan().getPlanPrice() + tax);
		user.getMyplan().setTotalPrice(totalPrice);
		System.out.println(user.getName() + " you have SuccessFully Recharged  for your " + user.getNetworkName() + " "
				+ user.getPhoneNumber() + " of TotalAmount is " + totalPrice);
	}

	@Override
	public void invoiceMessage(User user) {
		System.out.println(user.getName() + " you have Totally  Recharged for "
				+ user.getMyplan().getNoOfRecharge() * user.getMyplan().getTotalPrice());
	}

}
