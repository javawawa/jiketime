package com.ady01.demo2.filmlist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * <b>description</b>：电影信息 <br>
 * <b>time</b>：2019/4/21 12:35 <br>
 * <b>author</b>：微信公众号：路人甲Java，专注于java技术分享（爬虫、分布式事务、异步消息服务、任务调度、分库分表、大数据等），喜欢请关注！
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class FilmModel implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    private java.lang.Long id;
    /**
     * 片名，完整名称，不包含无关文字
     */
    private java.lang.String name;
    /**
     * 片名全拼音(小写)，如英雄：yingxiong
     */
    private java.lang.String full_spell;
    /**
     * 片名简拼(小写)，如英雄：yx
     */
    private java.lang.String short_spell;
    /**
     * 标题，可能和片名不同，里面有可能包含推广相关文字
     */
    private java.lang.String title;
    /**
     * 关键词，多个之间用逗号隔开
     */
    private java.lang.String keywords;
    /**
     * 描述
     */
    private java.lang.String description;
    /**
     * 1：电影，2：自定义专辑系列
     */
    private java.lang.Integer type;
    /**
     * 来源站点
     */
    private java.lang.Long site_id;
    /**
     * 来源页面
     */
    private java.lang.String source_url;
    /**
     * 简介，关联t_content_id
     */
    private java.lang.Long content_id;
    /**
     * 评分
     */
    private java.lang.String score;
    /**
     * 来源页面中资源唯一标志，用于去重使用
     */
    private java.lang.String source_uid;
    /**
     * 创建时间
     */
    private java.lang.Long create_time;
    /**
     * 发布时间
     */
    private java.lang.Long pub_time;
    /**
     * 最后更新时间
     */
    private java.lang.Long update_time;
    /**
     * 状态信息
     */
    private java.lang.Integer status;
    /**
     * 版本号
     */
    private java.lang.Long version;
    /**
     * 扩展数据
     */
    private Map<Object, Object> extData;
}
