package easybuy.bean;

public class Easybuy_product_category {
//      `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
//            `name` varchar(20) NOT NULL COMMENT '名称',
//            `parentId` int(10) NOT NULL COMMENT '父级目录id',
//            `type` int(11) DEFAULT NULL COMMENT '级别(1:一级 2：二级 3：三级)',
//            `iconClass` varchar(255) DEFAULT NULL COMMENT '图标',

    private int id;
    private String name;
    private int parentId;
    private int type;
    private String iconClass;

    public Easybuy_product_category(int id, String name, int parentId, int type, String iconClass) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.type = type;
        this.iconClass = iconClass;
    }

    public Easybuy_product_category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    @Override
    public String toString() {
        return "Easybuy_product_category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", type=" + type +
                ", iconClass='" + iconClass + '\'' +
                '}';
    }
}
