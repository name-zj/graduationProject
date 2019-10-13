package com.zj.service;

import java.util.List;

import com.zj.dao.ManagerDao;
import com.zj.entity.Customer;
import com.zj.entity.Goods;
import com.zj.entity.Manager;
import com.zj.entity.Notice;

public class ManagerService {

	ManagerDao dao = new ManagerDao();
	
	//��¼У��
	public Manager login(Manager manager){
		return dao.login(manager);
	}
	//����ȫ��ͨ����˵���Ʒ   
	public List<Goods> findAllGoods(int curPage){
		
		return dao.findAllGoods(curPage);
	}
	
	//����ȫ������˵���Ʒ    
	public List<Goods> findToBeAuditedGoods(int curPage){
		return dao.findToBeAuditedGoods(curPage);
	}

	//���������û���Ϣ
	public List<Customer> findAllCustomer(int curPage){
		return dao.findAllCustomer(curPage);
	}
	
	//��Ӻ�����
	public void forbiddenCustomer(int id){
		dao.forbiddenCustomer(id);
	}
	//���Һ����������û���Ϣ
	public List<Customer> findAllBlack(int curPage){
		return dao.findAllBlack(curPage);
	}
	
	//�����Ʒ
	public void postedGoods(int id){
		dao.postedGoods(id);	
	}
	//�ҵ�֪ͨ
		public Notice findNotice(){
			return dao.findNotice();
		}
	//�޸�֪ͨ
	public void notice(String notice){
		dao.notice(notice);
	}
}
