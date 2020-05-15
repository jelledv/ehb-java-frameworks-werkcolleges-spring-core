package be.ehb.javaframeworks.springcore.service.api;

import be.ehb.javaframeworks.springcore.dto.BlogComment;
import be.ehb.javaframeworks.springcore.dto.BlogPost;
import be.ehb.javaframeworks.springcore.dto.User;

import java.sql.SQLException;
import java.util.List;

public interface BlogService {

    List<BlogPost> getAllBlogPosts() throws SQLException;

    void writeBlogPost(BlogPost blogPost) throws SQLException;

    void writeBlogPostComment(BlogComment blogComment) throws SQLException;

    List<BlogComment> getAllBlogCommentsWrittenByUser(User user) throws SQLException;
}
