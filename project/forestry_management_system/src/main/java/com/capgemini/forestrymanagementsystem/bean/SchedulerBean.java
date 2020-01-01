package com.capgemini.forestrymanagementsystem.bean;

import java.io.Serializable;

public class SchedulerBean implements Serializable{
	private int schedulerId;
    private int haulId;
    private int prodId;
    private int quantity;
    private String deliveryDate;
		@Override
	public String toString() {
		return "SchedulerBean [schedulerId=" + schedulerId + ", haulId=" + haulId + ", prodId=" + prodId + ", quantity="
				+ quantity + ", deliveryDate=" + deliveryDate + "]";
	}
		
		public int getSchedulerId() {
			return schedulerId;
		}
		public void setSchedulerId(int schedulerId) {
			this.schedulerId = schedulerId;
		}
		public int getHaulId() {
			return haulId;
		}
		public void setHaulId(int haulId) {
			this.haulId = haulId;
		}
		public int getProdId() {
			return prodId;
		}
		public void setProdId(int prodId) {
			this.prodId = prodId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getDeliveryDate() {
			return deliveryDate;
		}
		public void setDeliveryDate(String deliveryDate) {
			this.deliveryDate = deliveryDate;
		}
}
