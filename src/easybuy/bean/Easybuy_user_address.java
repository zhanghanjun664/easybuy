package easybuy.bean;

import java.util.Date;

public class Easybuy_user_address {
//      `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
//            `userId` int(255) DEFAULT NULL COMMENT '用户主键',
//            `address` varchar(255) DEFAULT NULL COMMENT '地址',
//            `createTime` datetime DEFAULT NULL COMMENT '创建时间',
//            `isDefault` int(2) DEFAULT '0' COMMENT '是否是默认地址（1:是 0否）',
//            `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    private int id;
    private int userId;
    private String address;
    private Date createTime;
    private int isDefault;
    private String remark;

    public Easybuy_user_address(int id, int userId, String address, Date createTime, int isDefault, String remark) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.createTime = createTime;
        this.isDefault = isDefault;
        this.remark = remark;
    }

    public Easybuy_user_address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Easybuy_user_address{" +
                "id=" + id +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", isDefault=" + isDefault +
                ", remark='" + remark + '\'' +
                '}';
    }
}
