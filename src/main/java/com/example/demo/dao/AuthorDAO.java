package com.example.demo.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.AuthorInfoDto;

import java.util.List;

@Component
public class AuthorDAO extends AbstractHibernateDAO {

    public List<AuthorInfoDto> getAuthorInfo(Integer authoroid) {

        Query<AuthorInfoDto> query = getCurrentSession().createQuery(
                "select new com.example.demo.model.dto.AuthorInfoDto( "
                        + "author.oid, author.name, book.name, book.publicationDate) "
                        + "from authorentity author "
                        + "left join bookentity book "
                        + "on author.oid = book.authorOid "
                        + "where author.oid = :authorOid", AuthorInfoDto.class
        );
        query.setParameter("authorOid", authoroid);
        return query.getResultList();
    }
}
