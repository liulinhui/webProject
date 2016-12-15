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
     *
     * @param pList
     * @return
     */
    public Map<byte[],byte[]> serializeProtoStuffProductsList(Map<String,Person> pList) {
        if (pList == null || pList.size() <= 0) {
            return null;
        }
        long start = System.currentTimeMillis();
        Map<byte[],byte[]> bytes = new HashMap<>();
        Schema<Person> schema = RuntimeSchema.getSchema(Person.class);
        Schema<String> KeySchema = RuntimeSchema.getSchema(String.class);
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        byte[] KeyProtostuff = null;
        byte[] valueProtostuff=null;
        for (String key: pList.keySet()) {
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
     * @return
     */
    public Map<String,Person> deserializeProtoStuffDataListToProductsList(Map<byte[],byte[]>map) {
        if (map == null || map.keySet().size() <= 0) {
            return null;
        }
        long start = System.currentTimeMillis();
        Schema<Person> schema = RuntimeSchema.getSchema(Person.class);
        Schema<String> KeySchema = RuntimeSchema.getSchema(String.class);
        Map<String,Person> mapRes = new HashMap<>();
        for (byte[] key : map.keySet()) {
            String s=new String();
            Person person = new Person();
            ProtostuffIOUtil.mergeFrom(map.get(key), person, schema);
            ProtostuffIOUtil.mergeFrom(key, s, KeySchema);
            mapRes.put(s,person);
        }
        long end = System.currentTimeMillis();
        logger.info("反序列化消耗时间为：" + (end - start));
        return mapRes;
    }
}
