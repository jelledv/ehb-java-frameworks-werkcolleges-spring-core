package be.ehb.javaframeworks.springcore.dto;

public abstract class BaseDto {
    protected Integer id;

    BaseDto() {
        this.id = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

