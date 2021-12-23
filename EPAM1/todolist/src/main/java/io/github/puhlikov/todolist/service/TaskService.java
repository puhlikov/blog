package by.epam.belsut.kdv.todolist.service;

import by.epam.belsut.kdv.todolist.model.Task;

import java.util.List;

/**
 * Контракт сервис-слоя для заметок (задач)
 *
 *
 */
public interface TaskService {

    Task getOne(Long taskId);

    List<Task> findAllByDay(String day);

    List<Task> findAllSomeday();

    Task save(Task task);

    Task updateAttachmentIdFromTask(Long taskId, Long attachmentId);

    Task markDeleted(Long taskId, boolean isDeleted);

    List<Task> findAllFromBasket();

    boolean remove(Long taskId);

}
