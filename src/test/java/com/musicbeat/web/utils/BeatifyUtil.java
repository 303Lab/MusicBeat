package com.musicbeat.web.utils;

import com.musicbeat.web.model.User;

import java.util.List;

/**
 * 美化输出
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/02/16 19:55
 * @since 1.0.0
 */
public class BeatifyUtil {
    public static String beatifyPassword(User user) {
        if (user.getPassword() != null && user.getPassword().length() == 64) {
            return user.getPassword().substring(0, 5) + "...";
        }

        return null;
    }

    public static List<User> beatifyPassword(List<User> users) {
        for (User user : users) {
            user.setPassword(beatifyPassword(user));
        }

        return users;
    }
}
