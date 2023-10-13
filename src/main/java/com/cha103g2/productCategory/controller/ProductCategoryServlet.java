package com.cha103g2.productCategory.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cha103g2.productCategory.entity.ProductCategory;
import com.cha103g2.productCategory.service.ProductCategoryService;
import com.cha103g2.productCategory.service.ProductCategoryServiceImpl;

public class ProductCategoryServlet extends HttpServlet {
	// 一個 servlet 實體對應一個 service 實體
		private ProductCategoryService productCategoryService;
		
		@Override
		public void init() throws ServletException {
			productCategoryService = (ProductCategoryService) new ProductCategoryServiceImpl();
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");
			String forwardPath = "";
			switch (action) {
				case "getAll":
					forwardPath = getAllProductCategorys(req, res);
					break;
				case "compositeQuery":
					forwardPath = getCompositeProductCategorysQuery(req, res);
					break;
				default:
					forwardPath = "/index.jsp";
			}
			
			res.setContentType("text/html; charset=UTF-8");
			RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
			dispatcher.forward(req, res);
		}

		private String getCompositeProductCategorysQuery(HttpServletRequest req, HttpServletResponse res) {
			Map<String, String[]> map = req.getParameterMap();
			if (map != null) {
				List<ProductCategory> productCategoryList = productCategoryService.getProductCategorysByCompositeQuery(map);
				req.setAttribute("productCategoryList", productCategoryList);
			} else {
				return "/index.jsp";
			}
			return "/emp/listCompositeQueryEmps.jsp";
		}

		private String getAllProductCategorys(HttpServletRequest req, HttpServletResponse res) {
			String page = req.getParameter("page");
			int currentPage = (page == null) ? 1 : Integer.parseInt(page);
			
			List<ProductCategory> productCategoryList = productCategoryService.getAllProductCategorys(currentPage);

			if (req.getSession().getAttribute("productCategoryPageQty") == null) {
				int productCategoryPageQty = productCategoryService.getPageTotal();
				req.getSession().setAttribute("productCategoryPageQty", productCategoryPageQty);
			}
			
			req.setAttribute("productCategoryList", productCategoryList);
			req.setAttribute("currentPage", currentPage);
			
			return "/emp/listAllEmps.jsp";
		}
}
