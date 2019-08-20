package com.project.dto.cms;

/**
 * 登录DTO
 * @author huangh
 */
public class LoginDto {

    /** 登录账号 */
    private String login;
    /** 用户id */
    private Integer userid;
    /** 角色名称 */
    private String rolename;
    /** 用户昵称*/
    private String nickname;

    /**
     * Gets the value of login.
     *
     * @return the value of login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login.
     *
     * <p>You can use getLogin() to get the value of login</p>
     *
     * @param login login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the value of userid.
     *
     * @return the value of userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * Sets the userid.
     *
     * <p>You can use getUserid() to get the value of userid</p>
     *
     * @param userid userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * Gets the value of rolename.
     *
     * @return the value of rolename
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * Sets the rolename.
     *
     * <p>You can use getRolename() to get the value of rolename</p>
     *
     * @param rolename rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * Gets the value of nickname.
     *
     * @return the value of nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the nickname.
     *
     * <p>You can use getNickname() to get the value of nickname</p>
     *
     * @param nickname nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
