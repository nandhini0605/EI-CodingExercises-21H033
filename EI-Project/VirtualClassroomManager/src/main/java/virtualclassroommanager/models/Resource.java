package VirtualClassroomManager.src.main.java.virtualclassroommanager.models;

public class Resource {
    private String title;
    private String description;
    private String url;
    private String className;

    public Resource(String title, String description, String url, String className) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.className = className;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nURL: " + url;
    }
}
