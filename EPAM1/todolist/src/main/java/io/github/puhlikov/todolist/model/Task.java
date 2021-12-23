package by.epam.belsut.kdv.todolist.model;

import java.sql.Date;

/**
 * Модель представления заметок (задач) в БД
 *
 *
 */
public class Task {

    private Long id;
    private String name;
    private String description;
    private Date eventDate;
    private Boolean deleted;
    private Long attachmentId;

    public Task() {
    }

    public Task(String name, String description, String eventDate, Boolean deleted) {
        this.name = name;
        this.description = description;
        this.eventDate = Date.valueOf(eventDate);
        this.deleted = deleted;
    }

    public Task(String name, String description, Date eventDate, Boolean deleted) {
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
        this.deleted = deleted;
    }


    public Task(Long id, String name, String description, Date eventDate, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
        this.deleted = deleted;
    }

    public Task(Long id, String name, String description, String eventDate, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventDate = Date.valueOf(eventDate);
        this.deleted = deleted;
    }

    public Task(Long id, String name, String description, Date eventDate, Boolean deleted, Long attachmentId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
        this.deleted = deleted;
        this.attachmentId = attachmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = Date.valueOf(eventDate);
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public void setDeleted(int deleted) {
        if (deleted == 0) {
            this.deleted = false;
        } else {
            this.deleted = true;
        }
    }

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", eventDate=" + eventDate +
                ", deleted=" + deleted +
                ", attachmentId=" + attachmentId +
                '}';
    }
}
