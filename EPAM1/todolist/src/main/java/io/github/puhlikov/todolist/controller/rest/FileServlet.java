package by.epam.belsut.kdv.todolist.controller.rest;

import by.epam.belsut.kdv.todolist.converter.TimeConverter;
import by.epam.belsut.kdv.todolist.model.Attachment;
import by.epam.belsut.kdv.todolist.model.Task;
import by.epam.belsut.kdv.todolist.service.AttachmentService;
import by.epam.belsut.kdv.todolist.service.TaskService;
import by.epam.belsut.kdv.todolist.service.impl.AttachmentServiceImpl;
import by.epam.belsut.kdv.todolist.service.impl.TaskServiceImpl;
import by.epam.belsut.kdv.todolist.util.FileUtils;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.text.NumberFormat;


/**
 * Сервлеты работы с файлом
 *
 *
 */

@Path("/file")
public class FileServlet {

    private FileUtils fileUtils = new FileUtils();
    private AttachmentService attachmentService = new AttachmentServiceImpl();
    private TaskService taskService = new TaskServiceImpl();
    private TimeConverter timeConverter = new TimeConverter();

    /**
     * сохраняем файл на диск сервера, записываем информацию о файле в БД и получаем сведения и нем
     */
    @POST
    @Path("/save")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@FormDataParam("taskId") Long taskId,
                         @FormDataParam("file") InputStream inputStream,
                         @FormDataParam("file") FormDataBodyPart fileDetail) {
        if (inputStream == null || fileDetail == null) {
            return Response.status(400).build();
        } else {
            Attachment attachment = attachmentService.save(fileUtils.saveFile(taskId, inputStream, fileDetail));
            Task task = taskService.updateAttachmentIdFromTask(taskId, attachment.getId());

            if (task.getDeleted()) {
                return Response.seeOther(URI.create("../basket")).build();
            } else if (timeConverter.getLongToday().equals(timeConverter.convertStringToLongTime(task.getEventDate().toString()))) {
                return Response.seeOther(URI.create("../today")).build();
            } else if ((timeConverter.getLongToday() + 86400000L) == (timeConverter.convertStringToLongTime(task.getEventDate().toString()))) {
                return Response.seeOther(URI.create("../tomorrow")).build();
            } else if ((timeConverter.getLongToday() + 86400000L) < (timeConverter.convertStringToLongTime(task.getEventDate().toString()))) {
                return Response.seeOther(URI.create("../someday")).build();
            }
            return Response.noContent().build();

//            return attachment != null ?
//                    Response.ok().entity(attachment).build() :
//                    Response.noContent().build();
        }
    }

    /**
     * отдаем файл по attachmentId
     */
    @GET
    @Path("/getFile/{attachmentId}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFile(@PathParam("attachmentId") Long attachmentId) {
        return download(attachmentId);
    }

    /**
     * метод непосредственно отдачи файла клиенту
     */
    private Response download(Long attachmentId) {
        Attachment attachment = attachmentService.getOne(attachmentId);
        String filePath = attachment.getFilePath() + "/" + attachment.getFileName();
        Response response = null;
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
        // Получение файла с жеткого диска
        File file = new File(filePath);
        if (file.exists()) {
            Response.ResponseBuilder builder = Response.ok(file);
            builder.header("Content-Disposition", "attachment; filename=" + file.getName());
            response = builder.build();
        } else {
            response = Response.status(404).
                    entity("FILE NOT FOUND: " + filePath).
                    type("text/plain").
                    build();
        }
        return response;
    }

    /**
     * удаляем файл физически, а также из БД.
     */
    @DELETE
    @Path("/remove/{attachmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("attachmentId") Long attachmentId) {
        Attachment attachment = attachmentService.getOne(attachmentId);
        boolean result1 = fileUtils.removeFile(attachment.getFilePath(), attachment.getFileName());
        boolean result2 = attachmentService.remove(attachmentId);
        taskService.updateAttachmentIdFromTask(attachment.getTaskId(), 0L);
        if (result1 & result2) {
            return Response.ok().entity(true).build();
        }
        return Response.ok().entity(false).build();
    }
}
