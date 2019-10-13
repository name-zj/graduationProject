package com.zj.service;

import java.util.List;

import com.zj.dao.CustomerDao;
import com.zj.entity.Customer;
import com.zj.entity.Goods;
import com.zj.entity.Notice;

public class CustomerService {

	CustomerDao dao = new CustomerDao();
	//注册
	public void register(Customer customer){
		dao.register(customer);
	}
	//登录校验
	public Customer login(Customer customer){
		return dao.login(customer);
	}
	
	//查找全部审核通过的商品
	public List<Goods> findAllGoods(int curPage){
		
		return dao.findAllGoods(curPage);
	}
	
	//查找用户个人发布的商品
	public List<Goods> findAllGoods(int id,int curPage){
		return dao.findPostedGoodsByUserid(id,curPage);
	}
	
	public Goods findGoodsById(int id){
		return dao.findGoodsById(id);
	}
	//发布商品
	public void postedGoods(Goods goods){
		dao.postedGoods(goods);
	}
	//根据用户id查找用户信息
	public Customer findCustomerByid(int id){
		return dao.findCustomerByid(id);
	}
	
	/**
	 * 更新用户信息
	 * @param c
	 */
	public void updateUserinfo(Customer c) {
		dao.updateUserinfo(c);
	}
	
	/**
	 * 根据商品名称模糊搜索商品
	 * @param gname
	 * @return
	 */
	public List<Goods> findGoodsByName(String gname,int curPage){
		return dao.findGoodsByName(gname,curPage);
	}
	
	//查看我关注的资源
	public List<Goods> findFocusGoods(int id,int curPage){
		return dao.findFocusGoods(id, curPage);
	}
	
	//通知
	public Notice Notice(){
		return dao.Notice();
	}
}
