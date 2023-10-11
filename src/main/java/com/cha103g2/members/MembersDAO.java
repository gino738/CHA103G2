package com.cha103g2.members;

import java.util.List;

public interface MembersDAO {
	
	void add(Members members);
	void update(Members members);
	Members findByPK(Integer memno);
	List <Members> gatAll();

}
