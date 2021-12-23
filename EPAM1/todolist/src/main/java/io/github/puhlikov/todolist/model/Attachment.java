package by.epam.belsut.kdv.todolist.model;

/**
 * Модель представления файлов (приложений) в БД
 *
 *
 */
public class Attachment {

    private Long id;
    private Long taskId;
    private String fileName;
    private String filePath;

    public Attachment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
