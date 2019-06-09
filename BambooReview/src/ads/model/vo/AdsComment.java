package ads.model.vo;

import java.sql.Date;

public class AdsComment {
	private int commentNo;
	private int customerNo;
	private int adsNo;
	private Date writtenDate;
	private String commentContent;
	
	public AdsComment() {
		super();
	}
	
	public AdsComment(int commentNo, int customerNo, int adsNo, Date writtenDate, String commentContent) {
		super();
		this.commentNo = commentNo;
		this.customerNo = customerNo;
		this.adsNo = adsNo;
		this.writtenDate = writtenDate;
		this.commentContent = commentContent;
	}
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	@Override
	public String toString() {
		return "AdsComment [commentNo=" + commentNo + ", customerNo=" + customerNo + ", adsNo=" + adsNo
				+ ", writtenDate=" + writtenDate + ", commentContent=" + commentContent + "]";
	}
}
