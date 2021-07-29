package com.mongo.springbootmongo.service;

import com.mongo.springbootmongo.entity.Comment;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * Description
 * Date 2020/9/21 22:56
 * Created by kwz
 */
public interface CommentService {
    /**
     * Description保存一个评论
     * Param [comment]
     * return Comment
     */
    Comment saveComment(Comment comment);

    /**
     * 更新评论
     * Description
     * Param [comment]
     * return void
     */
    void updateComment(Comment comment);

    /**
     * Description 根据id删除评论
     * Param [id]
     * return void
     */
    void deleteCommentById(String id);

    /**
     * Description 查询所有评论
     * Param []
     * return java.util.List<com.mongo.springbootmongo.entity.Comment>
     */
    List<Comment> findCommentList();

    /**
     * Description 根据id查询评论
     * Param [id]
     * return com.mongo.springbootmongo.entity.Comment
     */
    Optional<Comment> findCommentById(String id);

    /**
     * Description 分页（根据articleId去查询）
     * <p>
     * Param [parentId, page, size]
     * return org.springframework.data.domain.Page<com.mongo.springbootmongo.entity.Comment>
     */
    Page<Comment> findByArticleId(String parentId, int page, int size);

    /**
     * Description
     * Param [id]
     * return void
     */
    void updateCommentLikeNum(String id);
}
