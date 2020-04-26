package com.zm.common.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 10:00
 * ==================================
 **/
public class BeanUtil<T, E> {

    /**
     * @param o     被copy的对象
     * @param clazz 需要的结果对象
     * @param <E>   结果对象的类型
     * @return o->clazz
     */
    public static <E> E copyProperties(Object o, Class<E> clazz) {
        //o->clazz
        if (o == null) {
            return null;
        }
        if (clazz == null) {
            return null;
        }
        try {
            E newInstance = clazz.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(o, newInstance);
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * @param objectList copy集合
     * @param clazz      需要的类型
     * @param <T>
     * @param <E>
     * @return list-》list<clazz>
     */
    public static <T, E> List<E> copyList(List<T> objectList, Class<E> clazz) {
        //list->list<clazz>
        if (CollectionUtils.isEmpty(objectList)) {
            return null;
        }
        if (clazz == null) {
            return null;
        }
        try {
            List<E> list = new ArrayList<>();
            for (Object o : objectList) {
                E e = clazz.newInstance();
                org.springframework.beans.BeanUtils.copyProperties(o, e);
                list.add(e);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
