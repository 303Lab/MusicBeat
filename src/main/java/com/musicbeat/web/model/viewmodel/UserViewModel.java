package com.musicbeat.web.model.viewmodel;

/**
 * User视图类
 *
 * @author windawings
 * @time.creation 2017/01/20 19:20
 * @version 1.0.0
 * @since 1.0.0
 */
public class UserViewModel {

  private Integer id;

  private String username;

  private Boolean gender;

  private String realname;

  private String country;

  private String province;

  private String city;

  private String qq;

  private String phone;

  private String email;

  private String picture;

  private Boolean isRealPublic;

  private String address;

  public UserViewModel() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Boolean getGender() {
    return gender;
  }

  public void setGender(Boolean gender) {
    this.gender = gender;
  }

  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public Boolean getRealPublic() {
    return isRealPublic;
  }

  public void setRealPublic(Boolean realPublic) {
    isRealPublic = realPublic;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
