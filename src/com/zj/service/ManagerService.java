package com.zj.service;

import java.util.List;

import com.zj.dao.ManagerDao;
import com.zj.entity.Customer;
import com.zj.entity.Goods;
import com.zj.entity.Manager;
import com.zj.entity.Notice;

public class ManagerService {

	ManagerDao dao = new ManagerDao();
	
	//登录校验
	public Manager login(Manager manager){
		return dao.login(manager);
	}
	//查找全部通过审核的商品   
	public List<Goods> findAllGoods(int curPage){
		
		return dao.findAllGoods(curPage);
	}
	
	//查找全部待审核的商品    
	public List<Goods> findToBeAuditedGoods(int curPage){
		return dao.findToBeAuditedGoods(curPage);
	}

	//查找所有用户信息
	public List<Customer> findAllCustomer(int curPage){
		return dao.findAllCustomer(curPage);
	}
	
	//添加黑名单
	public void forbiddenCustomer(int id){
		dao.forbiddenCustomer(id);
	}
	//查找黑名单所有用户信息
	public List<Customer> findAllBlack(int curPage){
		return dao.findAllBlack(curPage);
	}
	
	//审核商品
	public void postedGoods(int id){
		dao.postedGoods(id);	
	}
	//找到通知
		public Notice findNotice(){
			return dao.findNotice();
		}
	//修改通知
	public void notice(String notice){
		dao.notice(notice);
	}
}
