package com.cha103g2.members;

public class MembersJDBCDAO {
	
	public static void main(String[] args) {
		MembersDAO dao=new MembersDAOImpl();
		
		List<Members> list=dao.getAll();
		for(Members mem:list) {
			System.out.println(mem.getMemno()+",");
			System.out.println(mem.getMemstau()+",");
			System.out.println(mem.getMemno()+",");
			System.out.println(mem.getMemno()+",");
			System.out.println(mem.getMemno()+",");
			System.out.println(mem.getMemno()+",");
			System.out.println(mem.getMemno()+",");
			
		}
	}

}
