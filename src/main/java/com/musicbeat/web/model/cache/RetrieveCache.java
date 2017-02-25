package com.musicbeat.web.model.cache;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/02/18 18:33
 * @since 1.0.0
 */
public class RetrieveCache implements Serializable {

    private static final long serialVersionUID = 8813564170509570068L;

    public String email;

    public String random;

    public RetrieveCache() {
    }

    public RetrieveCache(String email, String random) {
        this.email = email;
        this.random = random;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }
}
