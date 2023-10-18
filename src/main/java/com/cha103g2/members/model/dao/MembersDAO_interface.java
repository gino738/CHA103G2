package com.cha103g2.members.model.dao;

import java.util.List;
import java.util.*;

public interface MembersDAO_interface {
	
	  public void insert(MembersVO mVo);
	    public void update(MembersVO mVo);
	    public void delete(Integer mVo);
	    public MembersVO findByPK(Integer mVo);
	    public List<MembersVO> getAll();

}
