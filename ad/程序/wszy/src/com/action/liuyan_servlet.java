//-------------------------请加下面QQ获取完整代码 ID:2000--------------------------
//-----------------更多毕设,课设下载地址: www.wisdomdd.cn-------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------请加下面QQ获取完整代码----------------------------
//-------------------------请加下面QQ获取完整代码 ID:2000--------------------------
//-----------------更多毕设,课设下载地址: www.wisdomdd.cn-------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------请加下面QQ获取完整代码----------------------------
package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.Tliuyan;
import com.service.liuService;

public class liuyan_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("liuyanAdd"))
		{
			liuyanAdd(req, res);
		}
		if(type.endsWith("liuyanAll"))
		{
			liuyanAll(req, res);
		}
		if(type.endsWith("liuyanDel"))
		{
			liuyanDel(req, res);
		}
		if(type.endsWith("liuyanMana"))
		{
			liuyanMana(req, res);
		}
	}
	
	
	public void liuyanAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String shijian=new Date().toLocaleString();
		
		String sql="insert into t_liuyan(`id`,`title`,`content`,`shijian`) values(?,?,?,?)";
		Object[] params={id,title,content,shijian};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "liuyan?type=liuyanAll");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
        
	}
	
	public void liuyanAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List liuyanList=new ArrayList();
		String sql="select * from t_liuyan";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tliuyan liuyan=new Tliuyan();
				
				liuyan.setId(rs.getString("id"));
				liuyan.setTitle(rs.getString("title"));
				liuyan.setContent(rs.getString("content"));
				liuyan.setShijian(rs.getString("shijian"));
				liuyanList.add(liuyan);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("liuyanList", liuyanList);
		req.getRequestDispatcher("qiantai/liuyan/liuyanAll.jsp").forward(req, res);
	}
	
	
	public void liuyanDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="delete from t_liuyan where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "liuyan?type=liuyanMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void liuyanMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List liuyanList=new ArrayList();
		String sql="select * from t_liuyan";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tliuyan liuyan=new Tliuyan();
				
				liuyan.setId(rs.getString("id"));
				liuyan.setTitle(rs.getString("title"));
				liuyan.setContent(rs.getString("content"));
				liuyan.setShijian(rs.getString("shijian"));
				liuyanList.add(liuyan);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("liuyanList", liuyanList);
		req.getRequestDispatcher("admin/liuyan/liuyanMana.jsp").forward(req, res);
	}
	
	
	
	
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
//-------------------------请加下面QQ获取完整代码 ID:2000--------------------------
//-----------------更多毕设,课设下载地址: www.wisdomdd.cn-------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------请加下面QQ获取完整代码----------------------------
//-------------------------请加下面QQ获取完整代码 ID:2000--------------------------
//-----------------更多毕设,课设下载地址: www.wisdomdd.cn-------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------作者QQ: 549710689-----------------------------
//-------------------------请加下面QQ获取完整代码----------------------------
