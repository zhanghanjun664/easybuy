package easybuy.bean;

public class Legends {
    private int id;
    private String name;
    private int ages;
    private String catalog_id;
    private String sex;

    public Legends(int id, String name, int ages, String catalog_id, String sex) {
        this.id = id;
        this.name = name;
        this.ages = ages;
        this.catalog_id = catalog_id;
        this.sex = sex;
    }

    public Legends() {
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

    public int getAges() {
        return ages;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }

    public String getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(String catalog_id) {
        this.catalog_id = catalog_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Legends{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ages=" + ages +
                ", catalog_id='" + catalog_id + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

}
