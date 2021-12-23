package by.epam.belsut.kdv.todolist.controller.rest;

import by.epam.belsut.kdv.todolist.converter.Converter;
import by.epam.belsut.kdv.todolist.dto.TaskDTO;
import by.epam.belsut.kdv.todolist.model.Attachment;
import by.epam.belsut.kdv.todolist.model.Task;
import by.epam.belsut.kdv.todolist.service.AttachmentService;
import by.epam.belsut.kdv.todolist.service.TaskService;
import by.epam.belsut.kdv.todolist.service.impl.AttachmentServiceImpl;
import by.epam.belsut.kdv.todolist.service.impl.TaskServiceImpl;
import by.epam.belsut.kdv.todolist.util.FileUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Сервлеты работы с заметками (заданиями)
 *
 *
 */

@Path("/task")
public class TaskServlet {
    private TaskService taskService = new TaskServiceImpl();
    private FileUtils fileUtils = new FileUtils();
    private AttachmentService attachmentService = new AttachmentServiceImpl();

    /*
     * получение заметки по taskId
     */
    @GET
    @Path("/getOne/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("taskId") Long taskId) {
        Task task = taskService.getOne(taskId);
        return task != null ?
                Response.ok().entity(task).build() :
                Response.noContent().build();
    }

    /*
     * получение списка заметок за определенный день
     */
    @GET
    @Path("findAllByDay/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllByDay(@PathParam("day") String day) {
        List<Task> task = taskService.findAllByDay(day);
        return task != null ?
                Response.ok().entity(task).build() :
                Response.noContent().build();
    }

    /*
     * получение списка заметок которые будут после завтра и дальше
     */
    @GET
    @Path("taskFindAllSomeday")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllSomeday() {
        List<Task> task = taskService.findAllSomeday();
        return task != null ?
                Response.ok().entity(task).build() :
                Response.noContent().build();
    }

    /*
     * сохранение заметки в БД
     */
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(TaskDTO taskDTO) {
        Task task = taskService.save(Converter.converterTaskDTOToTask(taskDTO));
        return task != null ?
                Response.ok().entity(task).build() :
                Response.noContent().build();
    }

    /*
     * получение списка заметок, которые находятся в корзине
     */
    @GET
    @Path("/findAllFromBasket")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllFromBasket() {
        List<Task> result = taskService.findAllFromBasket();
        return result != null ?
                Response.ok().entity(result).build() :
                Response.noContent().build();
    }

    /*
     * изменение статуза заметки в корзину или из корзины
     */
    @DELETE
    @Path("/markDeleted/{taskId}/{markDeleted}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response markDeleted(@PathParam("taskId") Long taskId, @PathParam("markDeleted") Boolean markDeleted) {
        Task task = taskService.markDeleted(taskId, markDeleted);

        return task != null ?
                Response.ok().entity(task).build() :
                Response.noContent().build();
    }

    /*
     * удаление заметки
     */
    @DELETE
    @Path("/deleted/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response markDeleted(@PathParam("taskId") Long taskId) {
        Task task = taskService.getOne(taskId);
        if (task.getAttachmentId() != null && task.getAttachmentId() > 0) {
            Attachment attachment = attachmentService.getOne(task.getAttachmentId());

            if (fileUtils.removeFile(attachment.getFilePath(), attachment.getFileName()) &&
                    attachmentService.remove(attachment.getId()) &&
                    taskService.remove(taskId)) {
                return Response.ok().build();
            }
        } else if (taskService.remove(taskId)) {
            return Response.ok().build();
        }
        return Response.noContent().build();
    }
}
