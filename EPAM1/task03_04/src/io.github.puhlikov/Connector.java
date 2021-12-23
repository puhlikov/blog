package ru.mail.puh2012;


import ru.mail.puh2012.Collection.BoxCollection;

import java.io.*;

public class Connector {
    public static final String FILE_PATH = "box.txt";

    public  void saveToFill(BoxCollection fileName) {

        File file = new File(FILE_PATH);

        try (ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(file))) {
            ostream.writeObject(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException c) {
            c.printStackTrace();
        }
        System.out.println("File write in file - " + fileName);

    }

    public static BoxCollection loadFromFile(){
        BoxCollection boxCollection = null;
        File file = new File(FILE_PATH);

        try (ObjectInputStream istream = new ObjectInputStream(new FileInputStream((file)))) {
            boxCollection = (BoxCollection) istream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return boxCollection;
    }

}
