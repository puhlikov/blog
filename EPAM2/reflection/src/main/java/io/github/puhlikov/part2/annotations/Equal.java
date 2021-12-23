package com.epam.training.part2.annotations;

import com.epam.training.part2.enums.Compare;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)

    public @interface Equal{
        Compare compareBy();
}
