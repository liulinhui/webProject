package com.learn.web.test.redisTest.bean;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.Pipe;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

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
    public List<byte[]> serializeProtoStuffProductsList(List<Person> pList) {
        if (pList == null || pList.size() <= 0) {
            return null;
        }
        long start = System.currentTimeMillis();
        List<byte[]> bytes = new ArrayList<byte[]>();
        Schema<Person> schema = RuntimeSchema.getSchema(Person.class);
        LinkedBuffer buffer = LinkedBuffer.allocate(4096);
        byte[] protostuff = null;
        for (Person p : pList) {
            try {
                protostuff = ProtostuffIOUtil.toByteArray(p, schema, buffer);
                bytes.add(protostuff);
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
     *
     * @param bytesList
     * @return
     */
    public List<Person> deserializeProtoStuffDataListToProductsList(List<byte[]> bytesList) {
        if (bytesList == null || bytesList.size() <= 0) {
            return null;
        }
        long start = System.currentTimeMillis();
        Schema<Person> schema = RuntimeSchema.getSchema(Person.class);
        List<Person> list = new ArrayList<Person>();
        for (byte[] bs : bytesList) {
            Person product = new Person();
            ProtostuffIOUtil.mergeFrom(bs, product, schema);
            list.add(product);
        }
        long end = System.currentTimeMillis();
        logger.info("反序列化消耗时间为：" + (end - start));
        return list;
    }
}
