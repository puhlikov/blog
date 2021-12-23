package by.epam.belsut.kdv.todolist.util;

import by.epam.belsut.kdv.todolist.model.Attachment;
import com.sun.jersey.multipart.FormDataBodyPart;

import java.io.*;

/**
 * Класс для работы с файлом.
 *
 *
 */
public class FileUtils {

    private static final String FILE_STORE = "file/file.properties";
    private static final String UPLOAD_FOLDER = "upload_folder";

    /*
    Сохраняем Файл на диск и возвращаем его модель.
     */
    public Attachment saveFile(Long taskId, InputStream inputStream, FormDataBodyPart fileDetail) {

        String baseFolder = PropertyReader.getProperties(FILE_STORE).getProperty(UPLOAD_FOLDER);
        String generatedPath = baseFolder + "/" + taskId;
        File fileStorageDir = new File(generatedPath);

        if (fileStorageDir.mkdir()) {
            String fileName = fileDetail.getContentDisposition().getFileName();
            try (FileOutputStream fileOutputStream = new FileOutputStream(generatedPath + "/" + fileName);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {

                byte[] buffer = getByteArray(inputStream);
                bufferedOutputStream.write(buffer, 0, buffer.length);

                Attachment attachment = new Attachment();
                attachment.setTaskId(taskId);
                attachment.setFileName(fileName);
                attachment.setFilePath(generatedPath);
                return attachment;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }

    /*
     * превращаем наш файл (InputStream) в массив байт
     */
    private static byte[] getByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, length);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /*
     * удаляем файл и папку физически
     */
    public boolean removeFile(String filePath, String fileName) {
        File file = new File(filePath + "/" + fileName);
        File folder = new File(filePath);
        if (file.exists()) {
            file.delete();
            return folder.delete();
        }
        return false;
    }
}
