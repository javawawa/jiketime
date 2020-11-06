package com.ady01.demo2.filmlist;

import com.ady01.demo2.filmdetail.FilmDetailModel;
import com.ady01.demo2.filmdetail.FilmDetailPageProcessor;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * <b>description</b>：电影列表页面数据采集器 <br>
 * <b>time</b>：2019/4/21 12:40 <br>
 * <b>author</b>：微信公众号：路人甲Java，专注于java技术分享（爬虫、分布式事务、异步消息服务、任务调度、分库分表、大数据等），喜欢请关注！
 */
@Slf4j
public class FilmListPageProcessor implements PageProcessor {

    public static PageModel collector(String url) {
        return new FilmListPageProcessor(url).collect().getPageModel();
    }

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(10000);
    //需要采集的页面
    private String url;

    //采集的数据
    private PageModel pageModel;

    public FilmListPageProcessor(String url) {
        this.url = url;
    }

    public FilmListPageProcessor collect() {
        Request request = new Request(url);
        Spider.create(this).thread(1).addRequest(request).run();
        return this;
    }

    @Override
    public void process(Page page) {
        String text = page.getRawText();
        log.info("列表页面数据：{}", text);
        this.pageModel = JSON.parseObject(text, PageModel.class);
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public PageModel getPageModel() {
        return pageModel;
    }

    public void setPageModel(PageModel pageModel) {
        this.pageModel = pageModel;
    }
}
