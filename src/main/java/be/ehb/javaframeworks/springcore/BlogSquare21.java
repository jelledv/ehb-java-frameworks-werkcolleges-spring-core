package be.ehb.javaframeworks.springcore;

import be.ehb.javaframeworks.springcore.dao.api.BlogCommentDao;
import be.ehb.javaframeworks.springcore.dao.api.BlogPostDao;
import be.ehb.javaframeworks.springcore.dao.api.UserDao;
import be.ehb.javaframeworks.springcore.dao.impl.BlogCommentDaoImpl;
import be.ehb.javaframeworks.springcore.dao.impl.BlogPostDaoImpl;
import be.ehb.javaframeworks.springcore.dao.impl.UserDaoImpl;
import be.ehb.javaframeworks.springcore.dto.BlogPost;
import be.ehb.javaframeworks.springcore.dto.User;
import be.ehb.javaframeworks.springcore.service.api.BlogService;
import be.ehb.javaframeworks.springcore.service.api.UserService;
import be.ehb.javaframeworks.springcore.service.impl.BlogServiceImpl;
import be.ehb.javaframeworks.springcore.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class BlogSquare21 {

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

    @Bean
    BlogService blogService() {
        return new BlogServiceImpl(blogPostDao(), blogCommentDao());
    }

    @Bean
    UserService userService() {
        return new UserServiceImpl(userDao());
    }

    private static final Logger LOGGER = Logger.getLogger(BlogSquare21.class.getSimpleName());

    private static BlogService blogService;
    private static UserService userService;

    private static void getBeans(ApplicationContext applicationContext) {
        blogService = applicationContext.getBean(BlogService.class);
        userService = applicationContext.getBean(UserService.class);
    }

    public static void main(String[] args) throws Exception {
        LOGGER.log(Level.INFO, "Starting application");
        ApplicationContext context = new AnnotationConfigApplicationContext(BlogSquare21.class);
        getBeans(context);

        User user1 = new User(1, "Jan Parlo", "jan.parlo@gmail.com");
        User user2 = new User(2, "Erik Meier", "erik.meier@gmail.com");
        List<BlogPost> blogPosts = blogService.getAllBlogPosts();

        LOGGER.info("Those users currently exist: " + userService.getAllUsers());

        LOGGER.info("Those blog posts have been written: " + blogPosts);

        LOGGER.info(user1.getName() + " has written the following comments: " + blogService.getAllBlogCommentsWrittenByUser(user1));
        LOGGER.info(user2.getName() + " has written the following comments: " + blogService.getAllBlogCommentsWrittenByUser(user2));
    }
}
