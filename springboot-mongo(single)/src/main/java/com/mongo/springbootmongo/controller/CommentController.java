package com.mongo.springbootmongo.controller;

import com.mongo.springbootmongo.entity.Comment;
import com.mongo.springbootmongo.service.CommentService;
import com.mongo.springbootmongo.util.Result;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description
 * Date 2020/9/23 22:15
 * Created by kwz
 */
@RestController
@RequestMapping("comment")
public class CommentController {

    @Setter(onMethod_ = @Autowired)
    private CommentService commentService;

    @PostMapping
    public Result saveComment(@RequestBody Comment comment){

        return Result.success(commentService.saveComment(comment));
    }

    @GetMapping("/list")
    public Result get(){

        return Result.success(commentService.findCommentList());
    }

    @PutMapping("/{id}/likeNum")
    public Result updateCommentLikeNum(@PathVariable String id){
        commentService.updateCommentLikeNum(id);
        return Result.success();
    }
}
