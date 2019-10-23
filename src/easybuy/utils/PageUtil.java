package easybuy.utils;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {

    private int pageNum = 1;
    private int pageSize = 5;

//    总页数
    private int pages;
//    总条数
    private int total;

    public PageUtil() {
    }

    public PageUtil(int pageNum, int pageSize, int pages, int total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = pages;
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if(pageNum < 1){
            this.pageNum = 1;
        }else if(pageNum > pages){
            this.pageNum = pages;
        }else{
            this.pageNum = pageNum;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int total, int pageSize) {
        if(total % pageSize == 0){
            this.pages = total/pageSize;
        }else{
            this.pages = (total/pageSize)+1;
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPageNumAndPageSize(HttpServletRequest req){
        if(req.getParameter("pageNum") != null){
            this.pageNum = Integer.parseInt(req.getParameter("pageNum"));
        }
        if(req.getParameter("pageSize") != null){
            this.pageSize = Integer.parseInt(req.getParameter("pageSize"));
        }

    }
}
