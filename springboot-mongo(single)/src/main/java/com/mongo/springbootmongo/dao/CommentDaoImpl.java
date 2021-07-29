package com.mongo.springbootmongo.dao;

import com.mongo.springbootmongo.entity.Comment;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * Description
 * Date 2020/9/24 5:59
 * Created by kwz
 */
@Repository
public class CommentDaoImpl implements CommentDao{

    @Setter(onMethod_ = @Autowired)
    private MongoTemplate mongoTemplate;

    @Override
    public void updateCommentLikeNum(String id) {
        //查询条件
        Query query = Query.query(Criteria.where("_id").is(id));
        //更新条件
        Update update = new Update();
        update.inc("likeNum");
        mongoTemplate.updateFirst(query,update, Comment.class);
    }
}
