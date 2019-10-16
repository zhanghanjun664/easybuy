

public class Easybuy_news{
 /*   CREATE TABLE `easybuy_news` (
            `id` int(10) NOT NULL auto_increment COMMENT '主键',
            `title` varchar(40) NOT NULL COMMENT '标题',
            `content` varchar(1000) NOT NULL COMMENT '内容',
            `createTime` varchar(10) NOT NULL COMMENT '创建时间',
    PRIMARY KEY  (`id`),
    UNIQUE KEY `PK__EASYBUY___C63B5EE724927208` (`id`),
    UNIQUE KEY `UQ__EASYBUY___C12AD09D276EDEB3` (`title`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8
*/
//  商场新闻类
//  id 主键
    private int id;
//  标题
    private String title;
//  内容
    private String content;
//  创建时间
    private String createTime;

    public Easybuy_news() {
    }

    public Easybuy_news(int id, String title, String content, String createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Easybuy_news{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}