package com.java1234.service;



import java.util.List;
import java.util.Map;

import com.java1234.entity.Book;
import com.java1234.entity.QueryVo;
import com.java1234.util.Page;

public interface BookService {
	
	
	@SuppressWarnings("rawtypes")
	public  Page selectBook(QueryVo queryVo);
	public Book getBookById(Integer id);
	public int updateBook(Book book);
	public int delete(Integer id);
	public int add(Book book);
	public List<Book> searchBook(Map<String,Object> map);
	 public int count(); 

	

}
