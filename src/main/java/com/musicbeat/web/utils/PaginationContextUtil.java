package com.musicbeat.web.utils;

/**
 * ${DESCRIPTION}
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/02/20 14:47
 * @since 1.0.0
 */
public class PaginationContextUtil {
    // 定义两个threadLocal变量：pageNum和pageSize
    private ThreadLocal<Integer> pageNum = new ThreadLocal<Integer>();    // 保存第几页
    private ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();    // 保存每页记录条数

    /*
     * pageNum ：get、set、remove
     */
    public int getPageNum() {
        Integer pn = pageNum.get();
        if (pn == null) {
            return 0;
        }
        return pn;
    }

    public void setPageNum(int pageNumValue) {
        pageNum.set(pageNumValue);
    }

    public void removePageNum() {
        pageNum.remove();
    }

    /*
     * pageSize ：get、set、remove
     */
    public int getPageSize() {
        Integer ps = pageSize.get();
        if (ps == null) {
            return 0;
        }
        return ps;
    }

    public void setPageSize(int pageSizeValue) {
        pageSize.set(pageSizeValue);
    }

    public void removePageSize() {
        pageSize.remove();
    }
}
