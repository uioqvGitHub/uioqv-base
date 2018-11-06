package com.uioqv.base.entity;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.HashMap;

/**
 * @author LiuGuoQing
 * @since 2018-11-06
 */
public class Query {
    private HashMap<String, Object> data = new HashMap<>();

    private void keys(String keys, boolean isDesc) {
        if(StringUtils.isBlank(keys)) {
            return;
        }
        String[] keyArray = keys.replaceAll("\\s","").split(",");
        Sort.Order[] orderArray = new Sort.Order[keyArray.length];

        if(isDesc) {
            for (int i = 0; i<keyArray.length; i++) {
                orderArray[i] = Sort.Order.desc(keyArray[i]);
            }
        } else {
            for (int i = 0; i<keyArray.length; i++) {
                orderArray[i] = Sort.Order.asc(keyArray[i]);
            }
        }

        Sort sort = get("keys", Sort.class);
        if(sort != null) {
            sort.and(Sort.by(orderArray));
        } else {
            sort = Sort.by(orderArray);
        }
        data.put("keys",sort);
    }

    /**
     * get key="keys"获取Sort对象
     * 添加降序字段
     * @param keys
     */
    public void desc(String keys){
       keys(keys, true);
    }

    /**
     * get key="keys"获取Sort对象
     * 添加升序字段
     * @param keys
     */
    public void asc(String keys) {
        keys(keys, false);
    }

    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     */
    public void page(int pageIndex, int pageSize){
        data.put("pageIndex", pageIndex);
        data.put("pageSize", pageSize);
    }

    /**
     * 添加字段
     * @param key
     * @param object
     */
    public void put(String key, Object object){
        data.put(key, object);
    }

    /**
     * 获取字段
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key,Class<T> clazz){
        return clazz.cast(data.get(key));
    }

    /**
     * 获取排序Sort对象
     * @return
     */
    public Sort getSort() {
        return get("keys", Sort.class);
    }

    /**
     * 获取分页对象
     * @return
     */
    public PageRequest getPage(){
        Integer pageIndex = get("pageIndex", Integer.class);
        Integer pageSize = get("pageSize", Integer.class);
        if(pageIndex == null || pageSize == null) {
            return null;
        }
        return PageRequest.of(pageIndex, pageSize, getSort());
    }
}
