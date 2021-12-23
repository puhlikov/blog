package by.epam.belsut.kdv.todolist.dao;

import by.epam.belsut.kdv.todolist.model.Attachment;

/**
 * интерфейс, обеспечивающий доступ к базе данных
 *
 *
 */
public interface AttachmentDAO {

    Attachment getOne(Long attachmentId);

    Attachment save(Attachment attachment);

    boolean remove(Long attachmentId);
}
