package hotel.model.vo;

public class Hotel {
	
	private String hotelId;
	private int review;
	private String region;
	private String picture;
	private String info;
	
	public Hotel() {
		
	}

	public Hotel(String hotelId, int review, String region, String picture, String info) {
		super();
		this.hotelId = hotelId;
		this.review = review;
		this.region = region;
		this.picture = picture;
		this.info = info;
	}
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", review=" + review + ", region=" + region + ", picture=" + picture
				+ ", info=" + info + "]";
	}
	
	
	


}
