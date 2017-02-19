package com.musicbeat.web.service;

import com.musicbeat.web.model.User;
import com.musicbeat.web.model.cache.RetrieveCache;
import org.apache.log4j.Logger;

/**
 * ${DESCRIPTION}
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/02/18 18:11
 * @since 1.0.0
 */
public interface RedisService {
    Logger logger = Logger.getLogger(RedisService.class);

    static final String RetrievePrefix = "retrieve:";

    RetrieveCache findRetrieveCode(User user);

    boolean addRetrieveCode(RetrieveCache cache);

    boolean deleteRetrieveCode(User user);
}
