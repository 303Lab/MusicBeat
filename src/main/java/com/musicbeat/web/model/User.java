package com.musicbeat.web.model;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Boolean gender;

    private String realname;

    private String country;

    private String province;

    private String city;

    private String qq;

    private String phone;

    private String email;

    private String picture;

    private String privilege;

    private Boolean isRealPublic;

    private String address;

    public User(Integer id, String username, String password, Boolean gender, String realname, String country, String province, String city, String qq, String phone, String email, String picture, String privilege, Boolean isRealPublic, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.realname = realname;
        this.country = country;
        this.province = province;
        this.city = city;
        this.qq = qq;
        this.phone = phone;
        this.email = email;
        this.picture = picture;
        this.privilege = privilege;
        this.isRealPublic = isRealPublic;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getRealname() {
        return realname;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getQq() {
        return qq;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPicture() {
        return picture;
    }

    public String getPrivilege() {
        return privilege;
    }

    public Boolean getIsRealPublic() {
        return isRealPublic;
    }

    public String getAddress() {
        return address;
    }
}