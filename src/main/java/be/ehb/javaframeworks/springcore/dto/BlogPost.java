package be.ehb.javaframeworks.springcore.dto;

public class BlogPost extends BaseDto {

    private String title;
    private String postText;

    public BlogPost() {
    }

    public BlogPost(String title, String postText) {
        this.title = title;
        this.postText = postText;
    }

    public BlogPost(int id, String title, String postText) {
        this.id = id;
        this.title = title;
        this.postText = postText;
    }

    public String getTitle() {
        return title;
    }

    public String getPostText() {
        return postText;
    }

    @Override
    public String toString() {
        return "\nBlogPost{" +
                "title='" + title + '\'' +
                ", postText='" + postText + '\'' +
                ", id=" + id +
                '}';
    }
}
