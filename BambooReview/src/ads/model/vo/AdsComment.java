package ads.model.vo;

import java.sql.Date;

public class AdsComment {
	private int adsCommentNo;
	private int customerNo;
	private int adsNo;
	private Date writtenDate;
	private String adsCommentContent;
	
	public AdsComment() {
		super();
	}

	public AdsComment(int adsCommentNo, int customerNo, int adsNo, Date writtenDate, String adsCommentContent) {
		super();
		this.adsCommentNo = adsCommentNo;
		this.customerNo = customerNo;
		this.adsNo = adsNo;
		this.writtenDate = writtenDate;
		this.adsCommentContent = adsCommentContent;
	}

	public int getAdsCommentNo() {
		return adsCommentNo;
	}

	public void setAdsCommentNo(int adsCommentNo) {
		this.adsCommentNo = adsCommentNo;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public int getAdsNo() {
		return adsNo;
	}

	public void setAdsNo(int adsNo) {
		this.adsNo = adsNo;
	}

	public Date getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}

	public String getAdsCommentContent() {
		return adsCommentContent;
	}

	public void setAdsCommentContent(String adsCommentContent) {
		this.adsCommentContent = adsCommentContent;
	}

	@Override
	public String toString() {
		return "AdsComment [adsCommentNo=" + adsCommentNo + ", customerNo=" + customerNo + ", adsNo=" + adsNo
				+ ", writtenDate=" + writtenDate + ", adsCommentContent=" + adsCommentContent + "]";
	}
	
	
}
