package com.epam.training.part2.analyzer;

import com.epam.training.part2.annotations.Equal;
import com.epam.training.part2.enums.Compare;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FieldAnalyzer {
//    public boolean equalObject(final Object objectOne, Object objectTwo) throws IllegalAccessException {
//        boolean equal = true;
//        Class class1 = objectOne.getClass();
//        Class class2 = objectTwo.getClass();
//        Field[] field1 = getFieldsAll(class1);
//        Field[] field2 = getFieldsAll(class2);
//        for (int i = 0; i < field1.length; i++) {
//            field1[i].setAccessible(true);
//            field2[i].setAccessible(true);
//            if (field1[i].isAnnotationPresent(Equal.class) && field2[i].isAnnotationPresent(Equal.class)) {
//                Equal equalAnnotation1 = field1[i].getAnnotation(Equal.class);
//                Equal equalAnnotation2 = field2[i].getAnnotation(Equal.class);
//                Enum enum1 = equalAnnotation1.compareBy();
//                Enum enum2 = equalAnnotation2.compareBy();
//                if (enum1.equals(Compare.REFERENCE) && enum2.equals(Compare.REFERENCE) && field1[i].get(objectOne) != field2[i].get(objectTwo)) {
//                    equal = false;
//                    return equal;
//                }
//                if (enum1.equals(Compare.VALUE) && enum2.equals(Compare.VALUE) && !field1[i].get(objectOne).equals(field2[i].get(objectTwo))) {
//                    equal = false;
//                    return equal;
//                }
//            }
//        } return equal;
//    }
//
//    private static Field[] getFieldsAll(Class childClass) {
//        List <Field> childClassField = new ArrayList<>(Arrays.asList(childClass.getDeclaredFields()));
//        Class parentClass = childClass.getSuperclass();
//        if (parentClass != null){
//            List<Field> parentsClassField = new ArrayList<>(Arrays.asList(parentClass.getDeclaredFields()));
//            childClassField.addAll(parentsClassField);
//        } return childClassField.toArray(new Field[0]);
//    }

 private static final Logger LOGGER = Logger.getLogger(FieldAnalyzer.class.getName());

    public FieldAnalyzer(){}

    public static class FieldAnalyzerHolder {
        public static final FieldAnalyzer
                HOLDER_INSTANCE = new FieldAnalyzer();
    }
    public  static FieldAnalyzer getInstance(){
        return FieldAnalyzerHolder.HOLDER_INSTANCE;
    }

    public boolean equalObject(Object object1, Object object2){
        boolean result = false;
        if (object1 == null || object2 == null || object1.getClass() != object2.getClass()){
            return false;
        }
        List<Field> fieldWithAnnotation = getFieldWithAnnotation(object1);
        if (fieldWithAnnotation.isEmpty()){
            return false;
        }
        for (Field field : fieldWithAnnotation){
            field.setAccessible(true);
            Compare value = field.getAnnotation(Equal.class).compareBy();
            try {
                result = value.compareBy(object1, object2, field);
                if (!result) break;
            } catch (IllegalAccessException e){
                LOGGER.info(String.format("No access - ", field));
            } finally {
                field.setAccessible(false);
            }
        } return result;
    }

    private List<Field> getFieldWithAnnotation(Object object){
        List<Field> fieldsWithAnnotation = Arrays.stream(object.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Equal.class))
                .collect(Collectors.toList());
        return fieldsWithAnnotation;
    }


}
