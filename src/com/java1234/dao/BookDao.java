package com.java1234.dao;

import java.util.List;
import java.util.Map;


import com.java1234.entity.Book;
import com.java1234.entity.QueryVo;







public interface BookDao {
	//计算查询总数
	public Integer bookCountByQueryVo(QueryVo queryVo);
	//查找书籍
	public List<Book> find(QueryVo queryVo);
	
	//通过id查找书本
	public Book getBookById(Integer id);

	//更新数据库里面这个书的信息并返回更新信息
	public int updateBook(Book book);
    
	//根据ID在数据库删除这本书的信息
	public Integer delete(Integer id);
	
	
	//往数据库里添加数据
	public int add(Book book);
	
	//在数据库里查找分页里显示的数据
	public List<Book> searchBook(Map<String,Object> map);
	
	//返回数据库里总条数
	 public Integer count(); 

	
}
