package by.epam.belsut.kdv.todolist.converter;

import by.epam.belsut.kdv.todolist.dto.TaskDTO;
import by.epam.belsut.kdv.todolist.model.Task;

/**
 * Класс конверторов
 *
 *
 */
public class Converter {

    /**
     * Метод конвертирует taskDTO в task
     *
     * @param taskDTO
     * @return task
     */
    public static Task converterTaskDTOToTask(TaskDTO taskDTO) {
        if (taskDTO != null) {
            Task task = new Task();
            if (taskDTO.getId() != null) {
                task.setId(taskDTO.getId());
            }
            task.setName(taskDTO.getName());
            task.setDescription(taskDTO.getDescription());
            task.setEventDate(taskDTO.getEventDate());
            task.setDeleted(taskDTO.getDeleted());
            task.setAttachmentId(taskDTO.getAttachmentId());
            return task;
        }
        return null;
    }
}
