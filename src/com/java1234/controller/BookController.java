 package com.java1234.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.java1234.entity.Book;
import com.java1234.entity.QueryVo;
import com.java1234.service.BookService;
import com.java1234.util.Page;



@Controller
@RequestMapping( "/book")
public class BookController {
	@Resource
	private BookService bookService;
	
	
	//转去查询页面
	@RequestMapping( "/read")
	public String read()
	{  
		return("list");
		
	}
	
/**
 * 
 * @param page
 * @param limit
 * @return

	@SuppressWarnings("rawtypes")
	@RequestMapping("/list")
	@ResponseBody
    public Map findallEmp(
    		@RequestParam(value = "page",required = false) Integer page,
            @RequestParam(value = "limit",required = false) Integer limit){ 
		
		System.out.println(page);
        int before = limit * (page - 1) ;  
        int after = page * limit;  
    	Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", before);
		map.put("size", after);  
        List<Book> data = bookService.searchBook(map) ;
        int count = bookService.count();
         
        //JSONArray json = JSONArray.fromObject(eilist); 
       // String js = json.toString();  
        //*****转为layui需要的json格式，必须要这一步，博主也是没写这一步，在页面上数据就是数据接口异常  
       // String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";  
       // return jso;  
        Map<String,Object> viewMap=new HashMap<>();
        viewMap.put("data",data);
        viewMap.put("count",count);
        viewMap.put("code",0);
        viewMap.put("msg","");
        return viewMap;

    }   */
	



  //进行查询操作
	@RequestMapping( value="/list")
	@SuppressWarnings("rawtypes")

	public @ResponseBody 
	Page list(@RequestParam(value = "id",required = false)Integer  id,
			@RequestParam(value = "bookName",required = false) String bookName,
			@RequestParam(value = "bookAuthor",required = false) String bookAuthor,
			@RequestParam(value = "publisher",required = false) String publisher,
			@RequestParam(value = "page",required = false) Integer page,
			@RequestParam(value = "limit",required = false) Integer limit)
			{    
		System.out.println(id);
		System.out.println(bookName);
		System.out.println(bookAuthor);
		System.out.println(publisher);
		System.out.println(page);
		System.out.println(limit);
		
		
		
	      QueryVo queryVo=new QueryVo();
	      queryVo.setId(id);
	      queryVo.setBookName(bookName);
	      queryVo.setBookAuthor(bookAuthor);
	      queryVo.setPublisher(publisher);
	      queryVo.setSize(limit);
	      queryVo.setPage(page);
	      
		@SuppressWarnings("unchecked")
		Page<Book> Page=bookService.selectBook(queryVo);
		
	     return Page;
		
	}
	
	//进行更新
	@SuppressWarnings("rawtypes")
	@RequestMapping( "/update")
	 @ResponseBody 
	public Map update(@RequestParam(value = "id") int id,
			@RequestParam(value = "bookName",required = false) String bookName)
	{    
		Book book=new Book();
		book.setId(id);
		book.setBookName(bookName);
		int state=bookService.updateBook(book);
		 Map<String,Object> viewMap=new HashMap<>();
	      viewMap.put("state",state);
		 return viewMap;
		
		
	}
/**
 * 	
 * @param book
 * @param request
 * @return

	//保存修改
		@RequestMapping( "/save")
		public String save(Book book,HttpServletRequest request)
		{   
		   System.out.println(book); 
		  bookService.updateBook(book);
		  HttpSession session=request.getSession();
		  session.setAttribute("book", book);
		  return("list");
			
		}
		 */
		
	
	//进行删除
	@SuppressWarnings("rawtypes")
	@RequestMapping( "/delete")
	 @ResponseBody 
	public Map delete(@RequestParam(value = "id") int id)
	{
		 int state= bookService.delete(id);
		 Map<String,Object> viewMap=new HashMap<>();
	      viewMap.put("state",state);
		 return viewMap;
		    
		
		
	}
	
	
	
	//在页面进行添加
	@RequestMapping( "/add")
	public String add()
	{
		
		return("add");
		
		}

	//在数据库进行添加
		@RequestMapping( "/operater")
		public String tip(Book book)
		{
			bookService.add(book);
			
			return ("tip");
			
			
			}
		
		
		//返回管理界面
		@RequestMapping( "/return")
		public String manager()
		{
			
			
			return ("success");
			
			
			}

	
	
}




