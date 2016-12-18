package com.learn.web.test.redisTest.bean;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linkage on 2016-12-15.
 */
public class ProtostuffTest {
    private static Logger logger = Logger.getLogger(ProtostuffTest.class);

    /**
     * 序列化
     * @param pList
     * @param typeKClass
     * @param typeVClass
     * @param <K>
     * @param <V>
     * @return
     */
    public <K extends Object,V extends Object> Map<byte[],byte[]> serializeMap(
            Map<K,V> pList,Class<K> typeKClass,Class<V>typeVClass){
        if (pList == null || pList.size() <= 0) {
            return null;
        }
        long start = System.currentTimeMillis();
        Map<byte[],byte[]> bytes = new HashMap<>();
        Schema<V> schema = RuntimeSchema.getSchema(typeVClass);
        Schema<K> KeySchema = RuntimeSchema.getSchema(typeKClass);
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        byte[] KeyProtostuff = null;
        byte[] valueProtostuff=null;
        for (K key: pList.keySet()) {
            try {
                KeyProtostuff = ProtostuffIOUtil.toByteArray(key, KeySchema, buffer);
                buffer.clear();
                valueProtostuff=ProtostuffIOUtil.toByteArray(pList.get(key), schema, buffer);
                buffer.clear();
                bytes.put(KeyProtostuff,valueProtostuff);
            } finally {
                buffer.clear();
            }
        }
        long end = System.currentTimeMillis();
        logger.info("序列化消耗时间为：" + (end - start));
        return bytes;
    }

    /**
     * 反序列化
     * @param map
     * @param typeKClass
     * @param typeVClass
     * @param <K>
     * @param <V>
     * @return
     */
    public <K extends Object,V extends Object> Map<K,V> deserializeToMap(
            Map<byte[],byte[]>map,Class<K> typeKClass,Class<V>typeVClass){
        if (map == null || map.keySet().size() <= 0) {
            return null;
        }
        long start = System.currentTimeMillis();
        Schema<V> schema = RuntimeSchema.getSchema(typeVClass);
        Schema<K> KeySchema = RuntimeSchema.getSchema(typeKClass);
        Map<K,V> mapRes = new HashMap<>();
        for (byte[] key : map.keySet()) {
            K k=null;
            V v=null;
            try{
                k=typeKClass.newInstance();
                v = typeVClass.newInstance();
            }catch (Exception e){
                e.printStackTrace();
            }
            ProtostuffIOUtil.mergeFrom(map.get(key), v, schema);
            ProtostuffIOUtil.mergeFrom(key, k, KeySchema);
            mapRes.put(k,v);
        }
        long end = System.currentTimeMillis();
        logger.info("反序列化消耗时间为：" + (end - start));
        return mapRes;
    }
}
