package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.java1234.dao.BookDao;
import com.java1234.entity.Book;
import com.java1234.entity.QueryVo;
import com.java1234.service.BookService;
import com.java1234.util.Page;

@Service("bookService")
public class BookServiceImpl implements BookService {
 
	@Resource
	private BookDao bookDao;


	@SuppressWarnings("rawtypes")
	public Page selectBook(QueryVo queryVo) {
		
		Page<Book> page = new Page<Book>();
		if (null != queryVo) {
		
			if (null != queryVo.getPage()) {
				
				queryVo.setStartRow((queryVo.getPage() -1)*queryVo.getSize());
			}
		   page.setCount(bookDao.bookCountByQueryVo(queryVo));
			page.setData(bookDao.find(queryVo));
			page.setCode(0);
			page.setMsg("");
		}
		return page;
		
	}
	
	


public Book getBookById(Integer id) {
		
		return bookDao.getBookById(id);
	}


	public int updateBook(Book book) {
		return bookDao.updateBook(book);
		
	}



	public int delete(Integer id) {
	
		return bookDao.delete(id);
	}


	
	public int add(Book book) {
		
		return bookDao.add(book);
	}





	public List<Book> searchBook(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookDao.searchBook(map);
	}




	@Override
	public int count() {
		// TODO Auto-generated method stub
		return bookDao.count();
	}


	
	

}
