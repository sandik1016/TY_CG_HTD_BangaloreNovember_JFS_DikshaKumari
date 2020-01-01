package com.capgemini.forestrymanagementsystem.bean;
public class LandBean {
        @Override
	public String toString() {
		return "LandBean [landId=" + landId + ", landLocation=" + landLocation + ", landCost=" + landCost
				+ ", acquiredDate=" + acquiredDate + "]";
	}
		private int landId;
        private String landLocation;
        private double landCost;
        private String acquiredDate;
		public int getLandId() {
			return landId;
		}
		public void setLandId(int landId) {
			this.landId = landId;
		}
		public String getLandLocation() {
			return landLocation;
		}
		public void setLandLocation(String landLocation) {
			this.landLocation = landLocation;
		}
		public double getLandCost() {
			return landCost;
		}
		public void setLandCost(double landCost) {
			this.landCost = landCost;
		}
		public String getAcquiredDate() {
			return acquiredDate;
		}
		public void setAcquiredDate(String acquiredDate) {
			this.acquiredDate = acquiredDate;
		}
		
        
}
