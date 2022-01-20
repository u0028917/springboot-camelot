package com.camelot.common.util;

import com.camelot.common.exception.AutomaticAccrualException;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * map容器工具类
 *
 * @date 2019-1-7
 */
public class MapUtils {

    private MapUtils() {}

    /**
     * 根据key值获取ArrayList类型值,如果不存在则创建一个新ArrayList返回并put到map中
     */
    public static <K> List getArrayListNXNew(Map<K, ArrayList> map, K key) {
        return MapUtils.getNXPutInstance(map, key, ArrayList.class);
    }

    public static <T, K> T getNXPutInstance(Map<K, T> map, K key, Class<? extends T> clazz) {
        Objects.requireNonNull(map);
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            try {
                T t = clazz.newInstance();
                map.put(key, t);
                return t;
            } catch (Exception e) {
                throw new AutomaticAccrualException(e.getMessage());
            }
        }
    }


    /**
     * <p>Discription:[存储map]</p>
     * Created on 2018/12/21
     *
     * @param key   mapKey值
     * @param value mapValue值
     * @param map   需要存储的map
     * @author:[孙少波]
     */
    public static <K, T> Map mapPut(Map<K, List<T>> map, K key, T value) {
        if (CollectionUtils.isEmpty(map.get(key))) {
            List<T> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        } else {
            map.get(key).add(value);
        }
        return map;
    }

    /**
     * <p>Discription:[存储map]</p>
     * Created on 2018/12/21
     *
     * @param key   mapKey值
     * @param value mapValue值
     * @param map   需要存储的map
     * @author:[孙少波]
     */
    public static <K, T> Map mapSetPut(Map<K, Set<T>> map, K key, T value) {
        if (CollectionUtils.isEmpty(map.get(key))) {
            Set<T> list = new HashSet<>();
            list.add(value);
            map.put(key, list);
        } else {
            map.get(key).add(value);
        }
        return map;
    }

    public static <K, T> Map mapPut(Map<K, List<T>> map, K key, List<T> value) {
        if (CollectionUtils.isEmpty(map.get(key))) {
            List<T> list = new ArrayList<>();
            list.addAll(value);
            map.put(key, list);
        } else {
            map.get(key).addAll(value);
        }
        return map;
    }
}
