package com.musicbeat.web.service.impl;

import com.musicbeat.web.model.User;
import com.musicbeat.web.model.cache.RetrieveCache;
import com.musicbeat.web.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Redis操作服务实现
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/02/18 18:09
 * @since 1.0.0
 */
@Service("RedisService")
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String, RetrieveCache> redisTemplate;

    @Override
    public boolean addRetrieveCode(RetrieveCache cache) {
        try {
            ValueOperations<String, RetrieveCache> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(RetrievePrefix + cache.getEmail(), cache, 30, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }
        return false;
    }

    @Override
    public RetrieveCache findRetrieveCode(User user) {
        ValueOperations<String, RetrieveCache> valueOperations = redisTemplate.opsForValue();

        return valueOperations.get(RetrievePrefix + user.getEmail());
    }

    @Override
    public boolean deleteRetrieveCode(User user) {
        try {
            redisTemplate.delete(RetrievePrefix + user.getEmail());
            return true;
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }
        return false;
    }
}
