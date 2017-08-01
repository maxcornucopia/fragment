package com.fragment.business.guava;

import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by leo on 2017/7/31.
 */
public class OptionalLearning {

    public static final Logger logger = LoggerFactory.getLogger(OptionalLearning.class);
    public static void main(String[] args) {

        //---------1.Optional<T>.of(T) 当T为Null直接抛NullPointException 2.T get() 获取Optional的值,当Optional的值为null时，抛出IllegalStateException-------------------------------
//        //抛空指针异常
//        Optional<Object> nullOf = Optional.of(null);
//        logger.debug("----------------"+nullOf.get());

        Optional<Integer> of = Optional.of(1);
        logger.debug("----------------" + of.get());

        //--------Optional<T> fromNullable(@Nullable T nullableReference) 当T为Null则使用默认值,可与or方法一起用------------------
        Optional<Object> objectOptional = Optional.fromNullable(null);
        logger.debug("----------------" + objectOptional);

        //-----------------当Optional的值为null时，使用or赋予的值返回,可与fromNullable一起使用---------------
        Object or = Optional.fromNullable(null).or(Integer.valueOf(1));
        logger.debug("----------------" + or);

        //-----------------isPresent() 如果Optional存在值，则返回True---------------
        Optional<Object> nullOptional = Optional.fromNullable(null);
        logger.debug("----------------" + nullOptional.isPresent());
        logger.debug("----------------" + of.isPresent());


    }
}
