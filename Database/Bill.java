package Database;

import java.util.*;

public class Bill {
	String Billname;
	double Billcost;
	double BillFrequency;

	public Bill() {
		this.Billname = "";
		this.Billcost = 0;
		this.BillFrequency = 0;
	}

	public Bill(String name, double price, double recurrence) {
		this.Billname = name;
		this.Billcost = price;
		this.BillFrequency = recurrence;
	}

	/**
	 * @return the billname
	 */
	public String getBillname() {
		return Billname;
	}

	/**
	 * @param billname the billname to set
	 */
	public void setBillname(String billname) {
		Billname = billname;
	}

	/**
	 * @return the billcost
	 */
	public double getBillcost() {
		return Billcost;
	}

	/**
	 * @param billcost the billcost to set
	 */
	public void setBillcost(double billcost) {
		Billcost = billcost;
	}

	/**
	 * @return the billFrequency
	 */
	public double getBillFrequency() {
		return BillFrequency;
	}

	/**
	 * @param billFrequency the billFrequency to set
	 */
	public void setBillFrequency(double billFrequency) {
		BillFrequency = billFrequency;
	}

}
