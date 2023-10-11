package com.cha103g2.product;

import java.util.List;

public interface ProductDAO_interface {
	public void insert(ProductVO productVO);
    public void update(ProductVO productVO);
    public void delete(Integer productno);
    public ProductVO findByPrimaryKey(Integer productno);
    public List<ProductVO> getAll();
}
