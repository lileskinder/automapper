package io.github.lileskinder.automapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutoMapper {

    /**
     * Maps an object of source type to target type by matching fields.
     *
     * @param source      The source object.
     * @param targetClass The target class.
     * @param <S>         The source type.
     * @param <T>         The target type.
     * @return The mapped target object.
     */
    public static <S, T> T map(S source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }

        try {
            // Check if the target is a record
            if (targetClass.isRecord()) {
                return mapToRecord(source, targetClass);
            }

            // Non-record target: use field matching
            T target = targetClass.getDeclaredConstructor().newInstance();
            for (Field sourceField : source.getClass().getDeclaredFields()) {
                sourceField.setAccessible(true);
                Field targetField;
                try {
                    targetField = targetClass.getDeclaredField(sourceField.getName());
                    targetField.setAccessible(true);
                    targetField.set(target, sourceField.get(source));
                } catch (NoSuchFieldException ignored) {
                    // Field not present in target, skip it
                }
            }
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping objects", e);
        }
    }


    /**
     * Maps a source object to a record class by matching constructor parameters.
     *
     * @param source      The source object.
     * @param targetClass The target record class.
     * @param <S>         The source type.
     * @param <T>         The target type.
     * @return The mapped record object.
     */
    private static <S, T> T mapToRecord(S source, Class<T> targetClass) {
        try {
            Constructor<?>[] constructors = targetClass.getDeclaredConstructors();
            if (constructors.length == 0) {
                throw new RuntimeException("Record class must have a constructor");
            }

            Constructor<?> primaryConstructor = constructors[0];
            primaryConstructor.setAccessible(true);

            // Match constructor parameters to source fields
            Class<?>[] parameterTypes = primaryConstructor.getParameterTypes();
            String[] parameterNames = Arrays.stream(primaryConstructor.getParameters())
                    .map(Parameter::getName)
                    .toArray(String[]::new);

            Object[] args = new Object[parameterTypes.length];
            for (int i = 0; i < parameterNames.length; i++) {
                Field sourceField = source.getClass().getDeclaredField(parameterNames[i]);
                sourceField.setAccessible(true);
                args[i] = sourceField.get(source);
            }

            // Invoke the record constructor
            return targetClass.cast(primaryConstructor.newInstance(args));
        } catch (Exception e) {
            throw new RuntimeException("Error mapping to record", e);
        }
    }
}
