package com.cha103g2.photoAlbum;

import java.util.List;

//此介面定義對資料庫的相關存取抽象方法
public interface PhotoAlbumDAO_interface {
    public void insert(PhotoAlbumVO photoAlbumVO);
    public void update(PhotoAlbumVO photoAlbumVO);
    public void delete(Integer albNo);
    public PhotoAlbumVO findByPrimaryKey(Integer albNo);
    public List<PhotoAlbumVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 

}
