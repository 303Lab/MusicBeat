package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private static final long serialVersionUID = 4799602879543296825L;

    private Integer id;

    private String username;

    private String password;

    private Boolean gender;

    private String realname;

    private String country;

    private String province;

    private String city;

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String qq;

    private String phone;

    private String email;

    private String picture;

    private String privilege;

    private Boolean isRealPublic;

    private String address;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id == null ? null : id.toString());
        list.add(username);
        list.add(password);
        list.add(gender == null ? "嬲" : gender ? "男" : "女");
        list.add(realname);
        list.add(country);
        list.add(province);
        list.add(city);
        list.add(qq);
        list.add(phone);
        list.add(email);
        list.add(picture);
        list.add(privilege);
        list.add(isRealPublic == null ? "资料非公开" : isRealPublic ? "资料公开" : "资料非公开");
        list.add(address);

        return list.toString();
    }

    public User() {}

    public User(
      Integer id,
      String username,
      String password,
      Boolean gender,
      String realname,
      String country,
      String province,
      String city,
      String qq,
      String phone,
      String email,
      String picture,
      String privilege,
      Boolean isRealPublic,
      String address
    ) {
        this.id = id;
        this.username = username == null ? null : username.trim();
        this.password = password == null ? null : password.trim();
        this.gender = gender;
        this.realname = realname == null ? null : realname.trim();
        this.country = country == null ? null : country.trim();
        this.province = province == null ? null : province.trim();
        this.city = city == null ? null : city.trim();
        this.qq = qq == null ? null : qq.trim();
        this.phone = phone == null ? null : phone.trim();
        this.email = email == null ? null : email.trim();
        this.picture = picture == null ? null : picture.trim();
        this.privilege = privilege == null ? null : privilege.trim();
        this.isRealPublic = isRealPublic;
        this.address = address == null ? null : address.trim();
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}