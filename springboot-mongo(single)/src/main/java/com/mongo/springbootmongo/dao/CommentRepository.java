package com.mongo.springbootmongo.dao;

import com.mongo.springbootmongo.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Description
 * Date 2020/9/21 22:54
 * Created by kwz
 */
public interface CommentRepository extends MongoRepository<Comment,String> {

    Page<Comment> findByArticleId(String articleId, Pageable pageable);
}
