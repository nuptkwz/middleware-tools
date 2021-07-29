package com.mongo.springbootmongo.dao;

/**
 * Description
 * 使用mongoTemplate实现更复杂的查询功能
 * Date 2020/9/24 5:57
 * Created by kwz
 */
public interface CommentDao {

    /**
     * Description
     * Param [id]
     * return void
     */
    void updateCommentLikeNum(String id);
}
