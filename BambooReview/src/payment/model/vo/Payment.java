package payment.model.vo;

import java.sql.Date;

public class Payment {
	private int payment_no;
	private int customer_no;
	private int amount;
	private Date paid_date;
	private Date unpaid_date;
	
	public Payment() {}
	public Payment(int payment_no, int customer_no, int amount, Date paid_date, Date unpaid_date) {
		super();
		this.payment_no = payment_no;
		this.customer_no = customer_no;
		this.amount = amount;
		this.paid_date = paid_date;
		this.unpaid_date = unpaid_date;
	}
	public int getPayment_no() {
		return payment_no;
	}
	public void setPayment_no(int payment_no) {
		this.payment_no = payment_no;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getPaid_date() {
		return paid_date;
	}
	public void setPaid_date(Date paid_date) {
		this.paid_date = paid_date;
	}
	public Date getUnpaid_date() {
		return unpaid_date;
	}
	public void setUnpaid_date(Date unpaid_date) {
		this.unpaid_date = unpaid_date;
	}
	@Override
	public String toString() {
		return "Payment [payment_no=" + payment_no + ", customer_no=" + customer_no + ", amount=" + amount
				+ ", paid_date=" + paid_date + ", unpaid_date=" + unpaid_date + "]";
	}
	

}
