/**
 *
 */
package com.google.code.linkedinapi.client.oauth;

/**
 * Class description
 *
 *
 */
public abstract class LinkedInOAuthToken {

    /** Field description */
    private String token;

    /** Field description */
    private String tokenSecret;

    /**
     * Constructs ...
     *
     *
     * @param token
     * @param tokenSecret
     */
    public LinkedInOAuthToken(String token, String tokenSecret) {
        this.token       = token;
        this.tokenSecret = tokenSecret;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getToken() {
        return token;
    }

    /**
     * Method description
     *
     *
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getTokenSecret() {
        return tokenSecret;
    }

    /**
     * Method description
     *
     *
     * @param tokenSecret
     */
    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public int hashCode() {
        final int prime  = 31;
        int       result = 1;

        result = prime * result + ((token == null)
                                   ? 0
                                   : token.hashCode());
        result = prime * result + ((tokenSecret == null)
                                   ? 0
                                   : tokenSecret.hashCode());

        return result;
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final LinkedInOAuthToken other = (LinkedInOAuthToken) obj;

        if (token == null) {
            if (other.token != null) {
                return false;
            }
        } else if (!token.equals(other.token)) {
            return false;
        }

        if (tokenSecret == null) {
            if (other.tokenSecret != null) {
                return false;
            }
        } else if (!tokenSecret.equals(other.tokenSecret)) {
            return false;
        }

        return true;
    }
}
