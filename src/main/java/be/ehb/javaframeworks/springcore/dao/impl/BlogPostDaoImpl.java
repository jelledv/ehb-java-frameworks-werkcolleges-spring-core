package be.ehb.javaframeworks.springcore.dao.impl;

import be.ehb.javaframeworks.springcore.dao.api.BlogPostDao;
import be.ehb.javaframeworks.springcore.dto.BlogPost;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BlogPostDaoImpl implements BlogPostDao {

    @Override
    public void save(BlogPost entity) throws SQLException {
        Connection c = ConnectionSingleton.getConnection();
        try(PreparedStatement ps = c.prepareStatement("insert into blogposts(title,postText) values (?,?)")) {

            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getPostText());

            ps.executeUpdate();
        }
    }

    @Override
    public Optional<BlogPost> findById(int entityId) throws SQLException {
        Connection c = ConnectionSingleton.getConnection();
        try(PreparedStatement ps = c.prepareStatement("select * from blogposts where id=?")) {

            ps.setInt(1, entityId);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String postText = resultSet.getString("postText");
                return Optional.of(new BlogPost(id, title, postText));
            }

            return Optional.empty();
        }
    }

    @Override
    public List<BlogPost> findAll() throws SQLException {
        Connection c = ConnectionSingleton.getConnection();

        try(Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery("select * from blogposts")) {

            List<BlogPost> blogPosts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String postText = resultSet.getString("postText");

                BlogPost blogPost = new BlogPost(id, title, postText);
                blogPosts.add(blogPost);
            }

            return blogPosts;
        }
    }
}
