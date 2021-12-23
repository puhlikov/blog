package by.epam.belsut.kdv.todolist.dto;

import by.epam.belsut.kdv.todolist.model.Task;

/**
 * слой ДТО заданий (заметок) используется только для сохранения и изменения заметок (заданий) при передачи от UI на server
 *
 *
 */
public class TaskDTO {

    private Long id;
    private String name;
    private String description;
    private String eventDate;
    private Boolean deleted = false;
    private Long attachmentId;

    public TaskDTO() {
    }

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.eventDate = task.getEventDate().toString();
        this.deleted = task.getDeleted();
    }

    public TaskDTO(String name, String description, String eventDate) {
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
    }

    public TaskDTO(Long id, String name, String description, String eventDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
    }

    public TaskDTO(Long id, String name, String description, String eventDate, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
        this.deleted = deleted;
    }

    public TaskDTO(Long id, String name, String description, String eventDate, Boolean deleted, Long attachmentId) {
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

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
