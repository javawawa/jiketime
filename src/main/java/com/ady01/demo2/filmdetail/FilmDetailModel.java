package com.ady01.demo2.filmdetail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <b>description</b>：电影详细信息 <br>
 * <b>time</b>：2019/4/21 13:18 <br>
 * <b>author</b>：微信公众号：路人甲Java，专注于java技术分享（爬虫、分布式事务、异步消息服务、任务调度、分库分表、大数据等），喜欢请关注！
 */
@Setter
@Getter
@ToString
public class FilmDetailModel implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    private java.lang.Long id;
    /**
     * 片名，完整名称，不包含无关文字
     */
    private java.lang.String title;

    /**
     * 下载地址列表
     */
    private List<String> downList;
}
