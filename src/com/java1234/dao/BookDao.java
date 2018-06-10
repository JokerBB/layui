package com.java1234.dao;

import java.util.List;
import java.util.Map;


import com.java1234.entity.Book;
import com.java1234.entity.QueryVo;







public interface BookDao {
	//�����ѯ����
	public Integer bookCountByQueryVo(QueryVo queryVo);
	//�����鼮
	public List<Book> find(QueryVo queryVo);
	
	//ͨ��id�����鱾
	public Book getBookById(Integer id);

	//�������ݿ�������������Ϣ�����ظ�����Ϣ
	public int updateBook(Book book);
    
	//����ID�����ݿ�ɾ���Ȿ�����Ϣ
	public Integer delete(Integer id);
	
	
	//�����ݿ����������
	public int add(Book book);
	
	//�����ݿ�����ҷ�ҳ����ʾ������
	public List<Book> searchBook(Map<String,Object> map);
	
	//�������ݿ���������
	 public Integer count(); 

	
}
