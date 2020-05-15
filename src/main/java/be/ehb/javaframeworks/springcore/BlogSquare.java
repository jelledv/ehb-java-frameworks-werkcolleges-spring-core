package be.ehb.javaframeworks.springcore;

import be.ehb.javaframeworks.springcore.dto.BlogPost;
import be.ehb.javaframeworks.springcore.dto.User;
import be.ehb.javaframeworks.springcore.service.api.BlogService;
import be.ehb.javaframeworks.springcore.service.api.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ComponentScan
@Configuration
public class BlogSquare {

    private static final Logger LOGGER = Logger.getLogger(BlogSquare.class.getSimpleName());

    private static BlogService blogService;
    private static UserService userService;

    private static void getBeans(ApplicationContext applicationContext) {
        blogService = applicationContext.getBean(BlogService.class);
        userService = applicationContext.getBean(UserService.class);
    }

    public static void main(String[] args) throws Exception {
        LOGGER.log(Level.INFO, "Starting application");
        ApplicationContext context = new AnnotationConfigApplicationContext(BlogSquare.class);
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
