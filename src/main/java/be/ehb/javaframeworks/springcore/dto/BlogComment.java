package be.ehb.javaframeworks.springcore.dto;

public class BlogComment extends BaseDto {
    private String comment;
    private BlogPost blogPost;
    private User user;

    public BlogComment() {
    }

    public BlogComment(int id, String comment, BlogPost blogPost, User user) {
        this.id = id;
        this.comment = comment;
        this.blogPost = blogPost;
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public User getUser() {
        return user;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "\nBlogComment{" +
                comment + " at post with title " + blogPost.getTitle();
    }
}
