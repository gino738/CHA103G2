package com.cha103g2.promotion.model;

import java.sql.Date;
import java.util.List;

public class PromotionService {
 
		private PromotionDAO_interface pro;

		public PromotionService() {
			 pro = new PromotionDAO();
		}

		public PromotionVO addPro(Integer prono,String proname,String prodes,Date startdate,
				Date enddate,Double discount,Integer status) 
		{

			PromotionVO proVO = new PromotionVO();

			proVO.setProno(prono);
			proVO.setProname(proname);
			proVO.setProdes(prodes);
			proVO.setStartdate(startdate);
			proVO.setEnddate(enddate);
			proVO.setDiscount(discount);
			proVO.setStatus(status);
			pro.insert(proVO);
			

			return proVO;
		}

		public PromotionVO updateEmp(Integer prono,String proname,String prodes,Date startdate,
				Date enddate,Double discount,Integer status) {

			PromotionVO proVO = new PromotionVO();

			proVO.setProno(prono);
			proVO.setProname(proname);
			proVO.setProdes(prodes);
			proVO.setStartdate(startdate);
			proVO.setEnddate(enddate);
			proVO.setDiscount(discount);
			proVO.setStatus(status);
			pro.update(proVO);
			

			return proVO;
		}

		public void deletePro(Integer prono) {
			pro.delete(prono);
		}

		public PromotionVO getOneEmp(Integer prono) {
			return pro.findByPrimaryKey(prono);
		}

		public List<PromotionVO> getAll() {
			return  pro.getAll();
		}
	}


