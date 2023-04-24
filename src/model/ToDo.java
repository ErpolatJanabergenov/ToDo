package model;

import java.util.UUID;

public class ToDo extends BaseModel {
    private String name;
    private String text;
    private UUID userId;

    public ToDo(String name, String text, UUID userId) {
        this.name = name;
        this.text = text;
        this.userId = userId;
    }

    public ToDo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "{" +
                "name=" + name  +
                "text=" + text  +
                "createdDate=" + createdDate +
                "updatedDate=" + updatedDate +
                '}';
    }
}
