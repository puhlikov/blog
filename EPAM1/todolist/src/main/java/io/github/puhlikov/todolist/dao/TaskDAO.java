package by.epam.belsut.kdv.todolist.dao;

import by.epam.belsut.kdv.todolist.model.Task;

import java.util.List;

/**
 * интерфейс, обеспечивающий доступ к базе данных
 *
 *
 */
public interface TaskDAO {

    Task getOne(Long taskId);

    List<Task> findAllByDay(String day);

    List<Task> findAllSomeday();

    Task save(Task task);

    Task updateAttachmentIdFromTask(Long taskId, Long attachmentId);

    Task markDeleted(Long taskId, boolean isDeleted);

    List<Task> findAllFromBasket();

    boolean remove(Long taskId);
}
