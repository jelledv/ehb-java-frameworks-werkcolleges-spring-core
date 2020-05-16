package be.ehb.javaframeworks.springcore.service.impl;

import be.ehb.javaframeworks.springcore.dao.api.BlogCommentDao;
import be.ehb.javaframeworks.springcore.dao.api.BlogPostDao;
import be.ehb.javaframeworks.springcore.dto.BlogComment;
import be.ehb.javaframeworks.springcore.dto.BlogPost;
import be.ehb.javaframeworks.springcore.dto.User;
import be.ehb.javaframeworks.springcore.service.api.BlogService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class BlogServiceImpl implements BlogService {

    private final BlogPostDao blogPostDao;
    private final BlogCommentDao blogCommentDao;

    public BlogServiceImpl(BlogPostDao blogPostDao, BlogCommentDao blogCommentDao) {
        this.blogPostDao = blogPostDao;
        this.blogCommentDao = blogCommentDao;
    }

    public List<BlogPost> getAllBlogPosts() throws SQLException {
        return blogPostDao.findAll();
    }

    public void writeBlogPost(BlogPost blogPost) throws SQLException {
        blogPostDao.save(blogPost);
    }

    public void writeBlogPostComment(BlogComment blogComment) throws SQLException {
        blogCommentDao.save(blogComment);
    }

    public List<BlogComment> getAllBlogCommentsWrittenByUser(User user) throws SQLException {
        List<BlogComment> all = blogCommentDao.findAll();

        return all.stream()
                .filter(x -> x.getUser().getId().equals(user.getId()))
                .collect(Collectors.toList());
    }
}
