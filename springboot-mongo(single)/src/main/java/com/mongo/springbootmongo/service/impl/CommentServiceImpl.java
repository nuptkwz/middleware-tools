package com.mongo.springbootmongo.service.impl;

import com.mongo.springbootmongo.dao.CommentDao;
import com.mongo.springbootmongo.dao.CommentRepository;
import com.mongo.springbootmongo.entity.Comment;
import com.mongo.springbootmongo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Description
 * Date 2020/9/21 22:56
 * Created by kwz
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentDao commentDao;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(String id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findCommentList() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findCommentById(String id) {
        return commentRepository.findById(id);
    }

    @Override
    public Page<Comment> findByArticleId(String articleId, int page, int size) {
        return commentRepository.findByArticleId(articleId, PageRequest.of(page - 1, size));
    }

    @Override
    public void updateCommentLikeNum(String id) {
        commentDao.updateCommentLikeNum(id);
    }

}