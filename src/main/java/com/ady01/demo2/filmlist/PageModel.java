package com.ady01.demo2.filmlist;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * <b>description</b>：分页对象 <br>
 * <b>time</b>：2019-04-21 13:46 <br>
 * <b>author</b>： 微信公众号：路人甲Java，专注于java技术分享（爬虫、分布式事务、异步消息服务、任务调度、分库分表、大数据等），喜欢请关注！
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PageModel implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 每页显示数量
     */
    private long pageSize;
    /**
     * 当前页行的开始行的索引，如1,2,3....
     */
    private long startIndex;
    /**
     * 当前页行的结束索引
     */
    private long endIndex;
    /**
     * 当前页
     */
    private long currentPage;

    /**
     * 上一页索引
     */
    private long prePage;

    /**
     * 下一页索引
     */
    private long nextPage;

    /**
     * 总记录数
     */
    private long count;

    /**
     * 是否有上一页
     */
    private boolean hasPrePage;

    /**
     * 是否有下一页
     */
    private boolean hasNextPage;

    /**
     * 总页数
     */
    private long pageCount;

    /**
     * 数据集合
     */
    private List<FilmModel> dataList;
}
