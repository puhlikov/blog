package by.epam.belsut.kdv.todolist.service.impl;

import by.epam.belsut.kdv.todolist.dao.TaskDAO;
import by.epam.belsut.kdv.todolist.dao.impl.TaskDAOImpl;
import by.epam.belsut.kdv.todolist.model.Task;
import by.epam.belsut.kdv.todolist.service.TaskService;

import java.util.List;

/**
 * имплементация контракта сервис-слоя
 *
 *
 */
public class TaskServiceImpl implements TaskService {

    private TaskDAO taskDAO = new TaskDAOImpl();

    /**
     * переопределеный метод выводит заметку (задание) по taskId
     *
     * @param taskId, уникальное имя, порядковый номер прикрепленного задания (заметки)
     * @return task, данные заметки из таблицы БД
     */
    @Override
    public Task getOne(Long taskId) {
        return taskDAO.getOne(taskId);
    }

    /**
     * переопределеный метод выводит список заметок (заданий) в определенный день
     *
     * @param day, день в который необходимо вывести в формате YYYY-MM-DD
     * @return List<Task>, список заданий в конктретный день
     */
    @Override
    public List<Task> findAllByDay(String day) {
        return taskDAO.findAllByDay(day);
    }

    /**
     * переопределеный метод выводит список всех заметок (заданий) которые будут послезавтра и далее
     *
     * @return List<Task>, список заданий которые будут послезавтра и далее
     */
    @Override
    public List<Task> findAllSomeday() {
        return taskDAO.findAllSomeday();
    }

    /**
     * переопределеный метод, сохраняет модель задания в базу данных
     *
     * @param task задание которое необходимо сохранить в базу данных
     * @return возвращает сохраненное задание
     */
    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setDeleted(false);
        }
        return taskDAO.save(task);
    }

    @Override
    public Task updateAttachmentIdFromTask(Long taskId, Long attachmentId) {
        return taskDAO.updateAttachmentIdFromTask(taskId, attachmentId);
    }

    /**
     * переопределеный метод, помечает задание на удаление (перемещение в корзину), если задание уже имеет положительный
     * статус метки на удаление (в корзине) восстанавливает его из корзины меняя дату на сегодняшнюю
     *
     * @param taskId    номер задания которое необходимо поменить на удаление (перемещение в корзину)
     * @param isDeleted статус удаления (в корзину или из нее)
     * @return задание (заметку) с изменениями.
     */
    @Override
    public Task markDeleted(Long taskId, boolean isDeleted) {
        return taskDAO.markDeleted(taskId, isDeleted);
    }

    /**
     * переопределеный метод выводит список всех заметок (заданий) которые находятся в корзине (имеют статус удалены)
     *
     * @return List<Task>, список заданий которые находятся в корзине (имеют статус удалены)
     */
    @Override
    public List<Task> findAllFromBasket() {
        return taskDAO.findAllFromBasket();
    }

    /**
     * переопределеный метод который удаляет заметку из БД.
     *
     * @param taskId номер заметки которую необходимо удалить
     * @return boolean возвращает статус удалена заметка или нет
     */
    @Override
    public boolean remove(Long taskId) {
        return taskDAO.remove(taskId);
    }
}
