package ads.model.vo;

import java.sql.Date;

public class Ads {
	private int adsNo; //게시글번호
	private int customerNo; //작성자 회원번호
	private String adsWriter;	//작성자
	private int adsRate;	//광고글 점수
	private int rateTotal;//광고글 점수 합계
	private String adsTitle;	//광고글 제목
	private String fullAddress;	//주소
	private String facilities;
	private String adsContent;	//광고글 내용
	private Date writtenDate;	//작성한 날짜
	private Date modifiedDate;	//수정한 날짜
	private int readCnt;	//조회수
	private int likeCnt;	//추천수
	private int disLikeCnt;	//비추천수
	private int rateCnt;	//평가수
	
	public Ads() {
		super();
	}

	public Ads(int adsNo, int customerNo, String adsWriter, int adsRate, int rateTotal, String adsTitle,
			String fullAddress, String facilities, String adsContent, Date writtenDate, Date modifiedDate,
			int readCnt, int likeCnt, int disLikeCnt, int rateCnt) {
		super();
		this.adsNo = adsNo;
		this.customerNo = customerNo;
		this.adsWriter = adsWriter;
		this.adsRate = adsRate;
		this.rateTotal = rateTotal;
		this.adsTitle = adsTitle;
		this.fullAddress = fullAddress;
		this.facilities = facilities;
		this.adsContent = adsContent;
		this.writtenDate = writtenDate;
		this.modifiedDate = modifiedDate;
		this.readCnt = readCnt;
		this.likeCnt = likeCnt;
		this.disLikeCnt = disLikeCnt;
		this.rateCnt = rateCnt;
	}

	public int getAdsNo() {
		return adsNo;
	}

	public void setAdsNo(int adsNo) {
		this.adsNo = adsNo;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public String getAdsWriter() {
		return adsWriter;
	}

	public void setAdsWriter(String adsWriter) {
		this.adsWriter = adsWriter;
	}

	public int getAdsRate() {
		return adsRate;
	}

	public void setAdsRate(int adsRate) {
		this.adsRate = adsRate;
	}

	public int getRateTotal() {
		return rateTotal;
	}

	public void setRateTotal(int rateTotal) {
		this.rateTotal = rateTotal;
	}

	public String getAdsTitle() {
		return adsTitle;
	}

	public void setAdsTitle(String adsTitle) {
		this.adsTitle = adsTitle;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getAdsContent() {
		return adsContent;
	}

	public void setAdsContent(String adsContent) {
		this.adsContent = adsContent;
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
		return "Ads [adsNo=" + adsNo + ", customerNo=" + customerNo + ", adsWriter=" + adsWriter + ", adsRate="
				+ adsRate + ", rateTotal=" + rateTotal + ", adsTitle=" + adsTitle + ", fullAddress=" + fullAddress
				+ ", facilities=" + facilities + ", adsContent=" + adsContent + ", writtenDate="
				+ writtenDate + ", modifiedDate=" + modifiedDate + ", readCnt=" + readCnt + ", likeCnt=" + likeCnt
				+ ", disLikeCnt=" + disLikeCnt + ", rateCnt=" + rateCnt + "]";
	}
	
	
}