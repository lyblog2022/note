package com.service.impl;
import com.mapper.ProductMapper;
import com.pojo.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * ProductServiceImpl
 *
 * @author liuyong
 * @version 1.0
 * @description com.service.impl
 * @date 2022/6/25 16:01
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Product findProductById(Integer id) {

        String key = "product:" +id;
        //先从redis中获取数据
        if(redisTemplate.hasKey(key))
        {
            System.out.println("执行缓存");
            redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));
            Product product = (Product) redisTemplate.opsForValue().get(key);
            return product;
        }
        System.out.println("执行mysql");

        Product product = productMapper.findProductById(id);
        redisTemplate.opsForValue().set(key, product);
        return product;
    }

}
