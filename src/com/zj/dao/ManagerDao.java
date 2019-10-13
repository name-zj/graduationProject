package com.zj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zj.entity.Customer;
import com.zj.entity.Goods;
import com.zj.entity.Manager;
import com.zj.entity.Notice;
import com.zj.utils.JDBCUtils;

public class ManagerDao {
	
	//登录校验
		public Manager login(Manager manager){
			Connection conn = null;	
			PreparedStatement state = null;
			ResultSet rs = null;
			try {
				conn = JDBCUtils.getConnection();
			
				state = conn.prepareStatement("select * from manager where mname=? and mpassword=?");
				state.setString(1,manager.getMname() );
				state.setString(2,manager.getMpassword() );
				rs = state.executeQuery();
				Manager m = new Manager();
				while(rs.next()){
					m.setId(rs.getInt("id"));
					m.setMname(rs.getString("mname"));
					m.setMpassword(rs.getString("mpassword"));
					m.setMimgurl(rs.getString("mimgurl"));
					return m;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JDBCUtils.close(conn, state, rs);
			}
			return null;
		}
	//查找全部通过审核的商品 
	public List<Goods> findAllGoods(int curPage){

		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		int startRow = (curPage - 1) * 10;
//		System.out.println(startRow);
		try {
			conn = JDBCUtils.getConnection();
			state = conn.prepareStatement("select * from goods where gifaduiting =1 ORDER BY id limit "+startRow+",10");
			rs = state.executeQuery();
			List<Goods> goods = new ArrayList<Goods>();
			Goods good = null;
			while(rs.next()){
				good = new Goods();
				good.setId(rs.getInt("id"));
				good.setGname(rs.getString("gname"));
				good.setGdescribe(rs.getString("gdescribe"));
				good.setGnum(rs.getString("gnum"));
				good.setGprice(rs.getString("gprice"));
				good.setGowner(rs.getString("gowner"));
				good.setGimgurl(rs.getString("gimgurl"));
				
				goods.add(good);
			}
			return goods;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, rs);
		}
		return null;
	}
	
	//查找全部待审核的商品    
		public List<Goods> findToBeAuditedGoods(int curPage){

			Connection conn = null;	
			PreparedStatement state = null;
			ResultSet rs = null;
			int startRow = (curPage - 1) * 10;
			try {
				conn = JDBCUtils.getConnection();
				String sql = "select * from goods where gifaduiting =0 ORDER BY id limit "+startRow+",10";
//				System.out.println(sql);
				state = conn.prepareStatement(sql);
				rs = state.executeQuery();
				List<Goods> goods = new ArrayList<Goods>();
				Goods good = null;
				while(rs.next()){
					good = new Goods();
					good.setId(rs.getInt("id"));
					good.setGname(rs.getString("gname"));
					good.setGdescribe(rs.getString("gdescribe"));
					good.setGnum(rs.getString("gnum"));
					good.setGprice(rs.getString("gprice"));
					good.setGowner(rs.getString("gowner"));
					good.setGimgurl(rs.getString("gimgurl"));
					goods.add(good);
				}
				return goods;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JDBCUtils.close(conn, state, rs);
			}
			return null;
		}
		
		
		//查找所有用户信息
	public List<Customer> findAllCustomer(int curPage){
		Connection conn = null;	
		PreparedStatement state = null;
		ResultSet rs = null;
		int startRow = (curPage - 1) * 10;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from customer ORDER BY id limit "+startRow+",10";
//			System.out.println(sql);
			state = conn.prepareStatement(sql);
			rs = state.executeQuery();
			List<Customer> customers = new ArrayList<Customer>();
			Customer c = null;
			while(rs.next()){
				c = new Customer();
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("cname"));
				c.setCpassword(rs.getString("cpassword"));
				c.setCimgurl(rs.getString("cimgurl"));
				customers.add(c);
			}
			return customers;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, rs);
		}
		return null;
	}
	
	//添加黑名单
	public void forbiddenCustomer(int id){
		Connection conn = null;	
		PreparedStatement state = null;
		try {
			conn = JDBCUtils.getConnection();
			state = conn.prepareStatement("insert into black(userid) values(?)");
			state.setInt(1, id);
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, null);
		}
	}
	
	//查找黑名单所有用户信息
		public List<Customer> findAllBlack(int curPage){
			Connection conn = null;	
			PreparedStatement state = null;
			ResultSet rs = null;
			int startRow = (curPage - 1) * 10;
			try {
				conn = JDBCUtils.getConnection();
				String sql = "select * from customer where id=(select userid from black) ORDER BY id limit "+startRow+",10";
//				System.out.println(sql);
				state = conn.prepareStatement(sql);
				rs = state.executeQuery();
				List<Customer> customers = new ArrayList<Customer>();
				Customer c = null;
				while(rs.next()){
					c = new Customer();
					c.setId(rs.getInt("id"));
					c.setCname(rs.getString("cname"));
					c.setCpassword(rs.getString("cpassword"));
					c.setCimgurl(rs.getString("cimgurl"));
					customers.add(c);
				}
				return customers;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JDBCUtils.close(conn, state, rs);
			}
			return null;
		}
		
	//审核商品
	public void postedGoods(int id){
		Connection conn = null;	
		PreparedStatement state = null;
		try {
			conn = JDBCUtils.getConnection();
			state = conn.prepareStatement("update goods set gifaduiting=1 where id=?");
			state.setInt(1, id);
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, null);
		}
	}
	
	//找到通知
	public Notice findNotice(){
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from notice";
			state = conn.prepareStatement(sql);
			rs = state.executeQuery();
			Notice notice = null;
			while(rs.next()){
				notice = new Notice();
				notice.setNotice(rs.getString("notice"));
				return notice;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, rs);
		}
		return null;
	}
	//修改通知
	public void notice(String notice){
		Connection conn = null;	
		PreparedStatement state = null;
		try {
			conn = JDBCUtils.getConnection();
			state = conn.prepareStatement("update notice set notice=?");
			state.setString(1, notice);
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, null);
		}
	}
}
