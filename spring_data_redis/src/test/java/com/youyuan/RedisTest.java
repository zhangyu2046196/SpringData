package com.youyuan;

import com.youyuan.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangyu
 * @version 1.0
 * @description redis测试类信息
 * @date 2019/3/11 14:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class RedisTest {

    @Autowired
    private RedisTemplate<String,Object > redisTemplate;

    /**
     * 添加
     */
    @Test
    public void insetStr(){
        redisTemplate.opsForValue().set("company","北京友缘在线科技股份有限公司");
    }

    @Test
    public void getStr(){
        String redisStr= (String) redisTemplate.opsForValue().get("company");
        System.out.println("redisStr:"+redisStr);
    }

    @Test
    public void insertObject(){
        //指定value的序列化器,用jdk序列化器,保存信息和查询信息必须用同一个序列化器,GenericJackson2JsonRedisSerializer存储的值在redisdasktop manger不是乱码
        //redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        //redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.opsForValue().set("user2",new User(1,"深圳",21));
    }

    @Test
    public void getObject(){
        //指定value的序列化器,用jdk序列化器,保存信息和查询信息必须用同一个序列化器,GenericJackson2JsonRedisSerializer存储的值在redisdasktop manger不是乱码
        //redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        //redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        User user= (User) redisTemplate.opsForValue().get("user2");
        System.out.println("user:"+user);
    }

}
