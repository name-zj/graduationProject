package com.zj.service;

import java.util.List;

import com.zj.dao.CustomerDao;
import com.zj.entity.Customer;
import com.zj.entity.Goods;
import com.zj.entity.Notice;

public class CustomerService {

	CustomerDao dao = new CustomerDao();
	//ע��
	public void register(Customer customer){
		dao.register(customer);
	}
	//��¼У��
	public Customer login(Customer customer){
		return dao.login(customer);
	}
	
	//����ȫ�����ͨ������Ʒ
	public List<Goods> findAllGoods(int curPage){
		
		return dao.findAllGoods(curPage);
	}
	
	//�����û����˷�������Ʒ
	public List<Goods> findAllGoods(int id,int curPage){
		return dao.findPostedGoodsByUserid(id,curPage);
	}
	
	public Goods findGoodsById(int id){
		return dao.findGoodsById(id);
	}
	//������Ʒ
	public void postedGoods(Goods goods){
		dao.postedGoods(goods);
	}
	//�����û�id�����û���Ϣ
	public Customer findCustomerByid(int id){
		return dao.findCustomerByid(id);
	}
	
	/**
	 * �����û���Ϣ
	 * @param c
	 */
	public void updateUserinfo(Customer c) {
		dao.updateUserinfo(c);
	}
	
	/**
	 * ������Ʒ����ģ��������Ʒ
	 * @param gname
	 * @return
	 */
	public List<Goods> findGoodsByName(String gname,int curPage){
		return dao.findGoodsByName(gname,curPage);
	}
	
	//�鿴�ҹ�ע����Դ
	public List<Goods> findFocusGoods(int id,int curPage){
		return dao.findFocusGoods(id, curPage);
	}
	
	//֪ͨ
	public Notice Notice(){
		return dao.Notice();
	}
}
