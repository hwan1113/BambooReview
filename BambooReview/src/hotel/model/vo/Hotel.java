package hotel.model.vo;

public class Hotel {
	
	private String hotelId;
	private int hotelRate;
	private String pictureRef;
	private String region;
	private String info;
	
	public Hotel() {
		
	}

	public Hotel(String hotelId, int hotelRate, String region, String pictureRef, String info) {
		super();
		this.hotelId = hotelId;
		this.hotelRate = hotelRate;
		this.region = region;
		this.pictureRef = pictureRef;
		this.info = info;
	}
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public int gethotelRate() {
		return hotelRate;
	}
	public void sethotelRate(int hotelRate) {
		this.hotelRate = hotelRate;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getpictureRef() {
		return pictureRef;
	}
	public void setpictureRef(String pictureRef) {
		this.pictureRef = pictureRef;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelRate=" + hotelRate + ", region=" + region + ", pictureRef=" + pictureRef
				+ ", info=" + info + "]";
	}
	
	
	


}
