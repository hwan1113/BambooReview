package review.model.vo;

import java.sql.Date;

public class ReviewComment {
	private int commentNo;
	private int customerNo;
	private int reviewNo;
	private Date writtenDate;
	private String commentContent;
	
	public ReviewComment() {}

	public ReviewComment(int commentNo, int customerNo, int reviewNo, Date writtenDate, String commentContent) {
		super();
		this.commentNo = commentNo;
		this.customerNo = customerNo;
		this.reviewNo = reviewNo;
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

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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
		return "ReviewComment [commentNo=" + commentNo + ", customerNo=" + customerNo + ", reviewNo=" + reviewNo
				+ ", writtenDate=" + writtenDate + ", commentContent=" + commentContent + "]";
	}
}
