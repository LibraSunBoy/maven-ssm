package cn.com.entity;

import java.io.Serializable;
import java.util.Date;

public class mmUser implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * 账号
     *
     * @mbggenerated
     */
    private String username;

    /**
     * 密码
     *
     * @mbggenerated
     */
    private String password;

    /**
     * 昵称
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * 头像
     *
     * @mbggenerated
     */
    private String headImg;

    /**
     * 视频头像
     *
     * @mbggenerated
     */
    private String headVedio;

    /**
     * 性别 0:女 1:男
     *
     * @mbggenerated
     */
    private Byte sex;

    /**
     * 年龄
     *
     * @mbggenerated
     */
    private Short age;

    /**
     * 地区
     *
     * @mbggenerated
     */
    private String region;

    /**
     * 签名
     *
     * @mbggenerated
     */
    private String autograph;

    /**
     * 详细地址
     *
     * @mbggenerated
     */
    private String address;

    private String hxusername;

    private String hxpassword;

    /**
     * 绑定手机号码
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * 是否编辑过基本信息（第一次进入app填写资料）
     *
     * @mbggenerated
     */
    private Byte isEdit;

    /**
     * 账号创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 是否被禁用
     *
     * @mbggenerated
     */
    private Byte isForbidden;

    /**
     * vip过期时间
     *
     * @mbggenerated
     */
    private Date vipExpireTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getHeadVedio() {
        return headVedio;
    }

    public void setHeadVedio(String headVedio) {
        this.headVedio = headVedio;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHxusername() {
        return hxusername;
    }

    public void setHxusername(String hxusername) {
        this.hxusername = hxusername;
    }

    public String getHxpassword() {
        return hxpassword;
    }

    public void setHxpassword(String hxpassword) {
        this.hxpassword = hxpassword;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Byte isEdit) {
        this.isEdit = isEdit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getIsForbidden() {
        return isForbidden;
    }

    public void setIsForbidden(Byte isForbidden) {
        this.isForbidden = isForbidden;
    }

    public Date getVipExpireTime() {
        return vipExpireTime;
    }

    public void setVipExpireTime(Date vipExpireTime) {
        this.vipExpireTime = vipExpireTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", headImg=").append(headImg);
        sb.append(", headVedio=").append(headVedio);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", region=").append(region);
        sb.append(", autograph=").append(autograph);
        sb.append(", address=").append(address);
        sb.append(", hxusername=").append(hxusername);
        sb.append(", hxpassword=").append(hxpassword);
        sb.append(", mobile=").append(mobile);
        sb.append(", isEdit=").append(isEdit);
        sb.append(", createTime=").append(createTime);
        sb.append(", isForbidden=").append(isForbidden);
        sb.append(", vipExpireTime=").append(vipExpireTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}