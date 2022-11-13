package com.sonhaenono.member.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class MemberFavoriteRegion implements Serializable {
	private String memberId;
	private List<String> dongCodes;
	
	@Override
	public String toString() {
		return "MemberFavoriteRegion [memberId=" + memberId + ", dongCode=" + dongCodes + "]";
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public List<String> getDongCodes() {
		return dongCodes;
	}

	public void setDongCode(List<String> dongCodes) {
		this.dongCodes = dongCodes;
	}

	public MemberFavoriteRegion() {}
	
	public MemberFavoriteRegion(String memberId, List<String> dongCodes) {
		this.memberId = memberId;
		this.dongCodes = dongCodes;
	}
	
	
}
