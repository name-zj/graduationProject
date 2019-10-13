package com.zj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zj.entity.Customer;
import com.zj.entity.Goods;
import com.zj.entity.Notice;
import com.zj.utils.JDBCUtils;


public class CustomerDao {
	
	public void register(Customer customer){
		Connection conn = null;	
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			Customer c = new Customer();
			state = conn.prepareStatement("insert into customer "
					+ "(cname,cpassword,cimgurl,cphone) "
					+ "values(?,?,?,?)");
			state.setString(1,customer.getCname() );
			state.setString(2,customer.getCpassword() );
			state.setString(3,customer.getCimgurl() );
			state.setString(4,customer.getCphone() );
			state.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, rs);
		}
	}
	//登录校验
	public Customer login(Customer customer){
		Connection conn = null;	
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			Customer c = new Customer();
			state = conn.prepareStatement("select * from customer where cname=? and cpassword=?");
			state.setString(1,customer.getCname() );
			state.setString(2,customer.getCpassword() );
			rs = state.executeQuery();
			while(rs.next()){
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("cname"));
				c.setCpassword(rs.getString("cpassword"));
				c.setCphone(rs.getString("cphone"));
				c.setCimgurl(rs.getString("cimgurl"));
				return c;
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
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from goods where gifaduiting =1 ORDER BY id limit "+startRow+",10";
//			System.out.println(sql);
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

	//查找用户个人发布的商品
	public List<Goods> findPostedGoodsByUserid(int id,int curPage){

		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		int startRow = (curPage - 1) * 10;
		try {
			conn = JDBCUtils.getConnection();
			state = conn.prepareStatement("select * from goods where gowner ="+id+" ORDER BY id limit "+startRow+",10");
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

	//根据商品id查找商品    
	public Goods findGoodsById(int id){

		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			state = conn.prepareStatement("select * from goods where id="+id);
			rs = state.executeQuery();
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

			}
			return good;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, rs);
		}
		return null;
	}

	/**
	 * 根据商品名称模糊搜索商品
	 * @param gname
	 * @return
	 */
	public List<Goods> findGoodsByName(String gname,int curPage){
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		int startRow = (curPage - 1) * 10;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from goods where gname like \'%"+gname+"%\' ORDER BY id limit "+startRow+",10";
			System.out.println(sql);
			state = conn.prepareStatement(sql);
			rs = state.executeQuery();
			List<Goods> goodss = new ArrayList<Goods>();
			Goods goodd = null;
			while(rs.next()){
				goodd = new Goods();
				goodd.setId(rs.getInt("id"));
				goodd.setGname(rs.getString("gname"));
				goodd.setGdescribe(rs.getString("gdescribe"));
				goodd.setGnum(rs.getString("gnum"));
				goodd.setGprice(rs.getString("gprice"));
				goodd.setGowner(rs.getString("gowner"));
				goodd.setGimgurl(rs.getString("gimgurl"));
				goodss.add(goodd);
				System.out.println("dao.good="+goodd.getGname());
			}
			System.out.println("dao.goods="+goodss);
			return goodss;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, rs);
		}
		return null;
	}

	//发布商品
	public void postedGoods(Goods goods){
		Connection conn = null;
		PreparedStatement state = null;
		//		System.out.println(goods);
		try {
			conn = JDBCUtils.getConnection();
			state = conn.prepareStatement("insert into goods "
					+ "(gname,gdescribe,gnum,gprice,gowner,gimgurl,gifaduiting) "
					+ "values(?,?,?,?,?,?,?)");
			state.setString(1,goods.getGname());
			state.setString(2,goods.getGdescribe());
			state.setString(3,goods.getGnum());
			state.setString(4,goods.getGprice());
			state.setString(5,goods.getGowner());
			state.setString(6,goods.getGimgurl());
			state.setString(7,goods.getGifaduiting());
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, null);
		}
	}

	//根据用户id查找用户信息
	public Customer findCustomerByid(int id){

		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			state = conn.prepareStatement("select * from customer where id="+id);
			rs = state.executeQuery();
			Customer c = null;
			while(rs.next()){
				c = new Customer();
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("cname"));
				c.setCpassword(rs.getString("cpassword"));
				c.setCphone(rs.getString("cphone"));
				c.setCimgurl(rs.getString("cimgurl"));

			}
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, rs);
		}
		return null;
	}


	/**
	 * 更新用户信息
	 * @param c
	 */
	public void updateUserinfo(Customer c) {
		Connection conn = null;
		PreparedStatement state = null;

		try {
			conn = JDBCUtils.getConnection();
			state = conn.prepareStatement("update customer set cname=?,"
					+ "cpassword=?,cimgurl=?,cphone=? where id=?");
			state.setString(1, c.getCname());
			state.setString(2, c.getCpassword());
			state.setString(3, c.getCimgurl());
			state.setString(4, c.getCphone());
			state.setInt(5, c.getId());
			state.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, null);
		}
	}
	
	//查看我关注的资源
	public List<Goods> findFocusGoods(int id,int curPage){
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		int startRow = (curPage - 1) * 10;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from goods where gowner="+id+" ORDER BY id limit "+startRow+",10";
//			System.out.println(sql);
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
//				System.out.println("dao.good="+good);
			}
//			System.out.println("dao.goods="+goods);
			return goods;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, state, rs);
		}
		return null;
	}
	
	//通知
	public Notice Notice(){
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

}
