package com.cha103g2.productCategory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_category_no", updatable = false)
	private Integer productCategoryNo;
	
	@Column(name = "product_category_name")
	private String productCategoryName;
	
	@Column(name = "product_category_desc")
	private String productCategoryDesc;

	public Integer getProductCategoryNo() {
		return productCategoryNo;
	}

	public void setProductCategoryNo(Integer productCategoryNo) {
		this.productCategoryNo = productCategoryNo;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public String getProductCategoryDesc() {
		return productCategoryName;
	}

	public void setProductCategoryDesc(String productCategoryDesc) {
		this.productCategoryDesc = productCategoryDesc;
	}

	@Override
	public String toString() {
		return "ProductCategory [product_category_no=" + productCategoryNo + ", product_category_name="
				+ productCategoryName + ", product_category_desc=" + productCategoryDesc + "]";
	}
	
	
}
