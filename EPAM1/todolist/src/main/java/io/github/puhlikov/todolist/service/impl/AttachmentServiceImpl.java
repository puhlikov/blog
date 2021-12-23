package by.epam.belsut.kdv.todolist.service.impl;

import by.epam.belsut.kdv.todolist.dao.AttachmentDAO;
import by.epam.belsut.kdv.todolist.dao.impl.TaskDAOImpl;
import by.epam.belsut.kdv.todolist.model.Attachment;
import by.epam.belsut.kdv.todolist.service.AttachmentService;

/**
 * имплементация контракта сервис-слоя
 *
 *
 */
public class AttachmentServiceImpl implements AttachmentService {

    private AttachmentDAO attachmentDAO = new TaskDAOImpl.AttachmentDAOImpl();

    /**
     * переопределеный метод выводит прикрепленный файл по по attachmentId
     *
     * @param attachmentId, уникальное имя, порядковый номер прикрепленного файла
     * @return Attachment, данные файла из таблицы БД
     */
    @Override
    public Attachment getOne(Long attachmentId) {
        return attachmentDAO.getOne(attachmentId);
    }

    /**
     * переопределеный метод сохраняет информацию о прикрепленном файле в базу
     *
     * @param attachment, уникальное имя, порядковый номер прикрепленного файла
     * @return Attachment, данные файла из таблицы БД
     */
    @Override
    public Attachment save(Attachment attachment) {
        return attachmentDAO.save(attachment);
    }

    /**
     * переопределеный метод удаляет физически файл и информацию о прикрепленном файле из базу
     *
     * @param attachmentId уникальное имя, порядковый номер прикрепленного файла
     * @return boolean удален файл или нет.
     */
    @Override
    public boolean remove(Long attachmentId) {
        return attachmentDAO.remove(attachmentId);

    }
}
