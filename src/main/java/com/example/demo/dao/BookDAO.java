package com.example.demo.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import com.example.demo.model.dto.BookInfoDto;

@Component
public class BookDAO extends AbstractHibernateDAO {
	
	public BookInfoDto getBookInfo(Integer bookoid) {
		
		Query<BookInfoDto> query = getCurrentSession().createQuery(
				"select new com.example.demo.modle.dto.BookInfoDto( "
				+ "book.oid, author.name, book.name, book.publicationDate ) "
                + "from bookentity book "
                + "left join AuthorEntity author "
                + "on book.authorOid = author.oid "
                + "where book.oid = :bookOid",BookInfoDto.class
				);
		query.setParameter("bookOid", bookoid);
		return query.getSingleResult();
		
	}
}