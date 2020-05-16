package be.ehb.javaframeworks.springcore.dao;

import be.ehb.javaframeworks.springcore.dao.api.BlogCommentDao;
import be.ehb.javaframeworks.springcore.dao.api.BlogPostDao;
import be.ehb.javaframeworks.springcore.dao.api.UserDao;
import be.ehb.javaframeworks.springcore.dao.impl.BlogCommentDaoImpl;
import be.ehb.javaframeworks.springcore.dao.impl.BlogPostDaoImpl;
import be.ehb.javaframeworks.springcore.dao.impl.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogSquareDaoConfig {

    @Bean
    BlogCommentDao blogCommentDao() {
        return new BlogCommentDaoImpl();
    }

    @Bean
    BlogPostDao blogPostDao() {
        return new BlogPostDaoImpl();
    }

    @Bean
    UserDao userDao() {
        return new UserDaoImpl();
    }

}
