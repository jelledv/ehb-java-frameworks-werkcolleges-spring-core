package be.ehb.javaframeworks.springcore;

import be.ehb.javaframeworks.springcore.dto.BlogPost;
import be.ehb.javaframeworks.springcore.dto.User;
import be.ehb.javaframeworks.springcore.service.BlogService;
import be.ehb.javaframeworks.springcore.service.UserService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlogSquare {

    private static final Logger LOGGER = Logger.getLogger(BlogSquare.class.getSimpleName());

    private static BlogService blogService;
    private static UserService userService;

    private static void initialize() {
        blogService = new BlogService();
        userService = new UserService();
    }

    public static void main(String[] args) throws Exception {
        LOGGER.log(Level.INFO, "Starting application");
        initialize();

        User user1 = new User(1, "Jan Parlo", "jan.parlo@gmail.com");
        User user2 = new User(2, "Erik Meier", "erik.meier@gmail.com");
        List<BlogPost> blogPosts = blogService.getAllBlogPosts();

        LOGGER.info("Those users currently exist: " + userService.getAllUsers());

        LOGGER.info("Those blog posts have been written: " + blogPosts);

        LOGGER.info(user1.getName() + " has written the following comments: " + blogService.getAllBlogCommentsWrittenByUser(user1));
        LOGGER.info(user2.getName() + " has written the following comments: " + blogService.getAllBlogCommentsWrittenByUser(user2));
    }
}
