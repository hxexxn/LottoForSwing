package dto;

public class MemberDTO {

	private int mNum;
	private String mId;
	private String mPW;
	
	public int getmNum() {
		return mNum;
	}
	public void setmNum(int mNum) {
		this.mNum = mNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPW() {
		return mPW;
	}
	public void setmPW(String mPW) {
		this.mPW = mPW;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [mNum=" + mNum + ", mId=" + mId + ", mPW=" + mPW + "]";
	}
	
	
	
	
}
