package util;

import java.util.Collection;

/**
 * Created by zf on 21.05.2019.
 */
public class Util {
    /**
     * Метод который петает на консоль любую коллекцию без квадратных скобок.
     * Берет каждый элемент и печатает его на новой строке.
     * Если необходимо напечатать все в одну строку нужно использовать метод print без окончания "ln"
     * "ln" - это переход на новую строку.
     * в этом методе испозьзуется "generic" (обощенный тип данных).
     * @param collection коллекция которую необходимо распечатать.
     */
    public static void printCollection(Collection<?> collection){
        collection.forEach(System.out::println);

//        или так можно написать Идея сама предлагает метов впереди
//        for (Object element : collection) {
//            System.out.println(element);
//        }
    }
}
