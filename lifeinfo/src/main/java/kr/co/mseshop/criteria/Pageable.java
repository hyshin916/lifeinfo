package kr.co.mseshop.criteria;

public class Pageable {
    public int page = 1;
    
    public int listSize = 20;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }
    
    public int skipCount() {
        return (page - 1) * listSize;
    }
}
