package be.ehb.javaframeworks.springcore.dao;

import be.ehb.javaframeworks.springcore.dto.BlogComment;
import be.ehb.javaframeworks.springcore.dto.BlogPost;
import be.ehb.javaframeworks.springcore.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BlogCommentDao implements AbstractDao<BlogComment> {

    @Override
    public void save(BlogComment entity) throws SQLException {
        Connection c = ConnectionSingleton.getConnection();
        try (PreparedStatement ps = c.prepareStatement("insert into blogcomments(comment,blogPostId, userId) values (?,?,?)")) {

            ps.setString(1, entity.getComment());
            ps.setInt(2, entity.getBlogPost().getId());
            ps.setInt(3, entity.getUser().getId());

            ps.executeUpdate();
        }
    }

    @Override
    public Optional<BlogComment> findById(int entityId) throws SQLException {
        Connection c = ConnectionSingleton.getConnection();
        try (PreparedStatement ps = c.prepareStatement("select * from blogcomments " +
                "left join users u on blogcomments.userId = u.id " +
                "left join blogposts b on blogcomments.blogPostId = b.id" +
                " where blogcomments.id=?")) {

            ps.setInt(1, entityId);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String comment = resultSet.getString("comment");

                BlogPost blogPost = new BlogPost(
                        resultSet.getInt("blogPostId"),
                        resultSet.getString("title"),
                        resultSet.getString("postText")
                );

                User user = new User(
                        resultSet.getInt("userId"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );

                BlogComment blogComment = new BlogComment(id, comment, blogPost, user);
                return Optional.of(blogComment);
            }

            return Optional.empty();
        }
    }


    @Override
    public List<BlogComment> findAll() throws SQLException {
        Connection c = ConnectionSingleton.getConnection();

        try (Statement s = c.createStatement();
             ResultSet resultSet = s.executeQuery("select * from blogcomments " +
                     "left join users u on blogcomments.userId = u.id " +
                     "left join blogposts b on blogcomments.blogPostId = b.id")) {

            List<BlogComment> blogPosts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String comment = resultSet.getString("comment");

                BlogPost blogPost = new BlogPost(
                        resultSet.getInt("blogPostId"),
                        resultSet.getString("title"),
                        resultSet.getString("postText")
                );

                User user = new User(
                        resultSet.getInt("userId"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );

                BlogComment blogComment = new BlogComment(id, comment, blogPost, user);
                blogPosts.add(blogComment);
            }

            return blogPosts;
        }
    }
}
