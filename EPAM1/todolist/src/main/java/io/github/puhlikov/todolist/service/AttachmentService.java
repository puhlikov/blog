package by.epam.belsut.kdv.todolist.service;

import by.epam.belsut.kdv.todolist.model.Attachment;

/**
 * Контракт сервис-слоя для прикрепленных файлов.
 *
 *
 */
public interface AttachmentService {

    Attachment getOne(Long attachmentId);

    Attachment save(Attachment attachment);

    boolean remove(Long attachmentId);

}
