package review.model.vo;

import java.sql.Date;

public class Review {
	private int reviewNo; //게시글번호
	private int customerNo; //작성자 회원번호
	private String reviewWriter;	//작성자
	private String hotelId;	//참조하는 api의 호텔아이디
	private int reviewRate;	//리뷰 점수
	private int rateTotal;//리뷰 점수 합계
	private String reviewTitle;	//리뷰 제목
	private String reviewContent;	//리뷰 내용
	private Date writtenDate;	//작성한 날짜
	private Date modifiedDate;	//수정한 날짜
	private int readCnt;	//조회수
	private int likeCnt;	//추천수
	private int disLikeCnt;	//비추천수
	private int rateCnt;	//평가수
	
	public Review() {
		super();
	}
	public Review(int reviewNo, int customerNo, String reviewWriter, String hotelId, int reviewRate, int rateTotal,
			String reviewTitle, String reviewContent, Date writtenDate, Date modifiedDate, int readCnt, int likeCnt,
			int disLikeCnt, int rateCnt) {
		super();
		this.reviewNo = reviewNo;
		this.customerNo = customerNo;
		this.reviewWriter = reviewWriter;
		this.hotelId = hotelId;
		this.reviewRate = reviewRate;
		this.rateTotal = rateTotal;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.writtenDate = writtenDate;
		this.modifiedDate = modifiedDate;
		this.readCnt = readCnt;
		this.likeCnt = likeCnt;
		this.disLikeCnt = disLikeCnt;
		this.rateCnt = rateCnt;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public int getReviewRate() {
		return reviewRate;
	}
	public void setReviewRate(int reviewRate) {
		this.reviewRate = reviewRate;
	}
	public int getRateTotal() {
		return rateTotal;
	}
	public void setRateTotal(int rateTotal) {
		this.rateTotal = rateTotal;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getDisLikeCnt() {
		return disLikeCnt;
	}
	public void setDisLikeCnt(int disLikeCnt) {
		this.disLikeCnt = disLikeCnt;
	}
	public int getRateCnt() {
		return rateCnt;
	}
	public void setRateCnt(int rateCnt) {
		this.rateCnt = rateCnt;
	}
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", customerNo=" + customerNo + ", reviewWriter=" + reviewWriter
				+ ", hotelId=" + hotelId + ", reviewRate=" + reviewRate + ", rateTotal=" + rateTotal + ", reviewTitle="
				+ reviewTitle + ", reviewContent=" + reviewContent + ", writtenDate=" + writtenDate + ", modifiedDate="
				+ modifiedDate + ", readCnt=" + readCnt + ", likeCnt=" + likeCnt + ", disLikeCnt=" + disLikeCnt
				+ ", rateCnt=" + rateCnt + "]";
	}

}