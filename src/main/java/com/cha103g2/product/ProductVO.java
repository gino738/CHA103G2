package com.cha103g2.product;

import java.util.Objects;

public class ProductVO implements java.io.Serializable{
	private Integer productno;
	private Integer productcategoryno;
	private String productname;
	private Integer productprice;
	private Integer productquantity;
	private Integer productstatus;
	private Integer producttotalreviewcount;
	private Integer producttotalreviewstatus;
	
	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(productcategoryno, productname, productno, productprice, productquantity, productstatus,
				producttotalreviewcount, producttotalreviewstatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductVO other = (ProductVO) obj;
		return Objects.equals(productcategoryno, other.productcategoryno)
				&& Objects.equals(productname, other.productname) && Objects.equals(productno, other.productno)
				&& Objects.equals(productprice, other.productprice)
				&& Objects.equals(productquantity, other.productquantity)
				&& Objects.equals(productstatus, other.productstatus)
				&& Objects.equals(producttotalreviewcount, other.producttotalreviewcount)
				&& Objects.equals(producttotalreviewstatus, other.producttotalreviewstatus);
	}

	@Override
	public String toString() {

		return "ProductVO [productno=" + productno + ", productcategoryno=" + productcategoryno + ", productname="
				+ productname + ", productprice=" + productprice + ", productquantity=" + productquantity
				+ ", productstatus=" + productstatus + ", producttotalreviewcount=" + producttotalreviewcount
				+ ", producttotalreviewstatus=" + producttotalreviewstatus + "]";
	}
	
	
	public Integer getProductno() {
		return productno;
	}
	public void setProductno(Integer productno) {
		this.productno = productno;
	}
	public Integer getProductcategoryno() {
		return productcategoryno;
	}
	public void setProductcategoryno(Integer productcategoryno) {
		this.productcategoryno = productcategoryno;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getProductprice() {
		return productprice;
	}
	public void setProductprice(Integer productprice) {
		this.productprice = productprice;
	}
	public Integer getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(Integer productquantity) {
		this.productquantity = productquantity;
	}
	public Integer getProductstatus() {
		return productstatus;
	}
	public void setProductstatus(Integer productstatus) {
		this.productstatus = productstatus;
	}
	public Integer getProducttotalreviewcount() {
		return producttotalreviewcount;
	}
	public void setProducttotalreviewcount(Integer producttotalreviewcount) {
		this.producttotalreviewcount = producttotalreviewcount;
	}
	public Integer getProducttotalreviewstatus() {
		return producttotalreviewstatus;
	}
	public void setProducttotalreviewstatus(Integer producttotalreviewstatus) {
		this.producttotalreviewstatus = producttotalreviewstatus;
	}
	
	
	
	
	
	

}
