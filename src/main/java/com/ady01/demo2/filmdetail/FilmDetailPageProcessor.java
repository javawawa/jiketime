package com.ady01.demo2.filmdetail;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <b>description</b>：电影详情页采集器，采集电影详细信息 <br>
 * <b>time</b>：2019/4/21 12:40 <br>
 * <b>author</b>：微信公众号：路人甲Java，专注于java技术分享（爬虫、分布式事务、异步消息服务、任务调度、分库分表、大数据等），喜欢请关注！
 */
@Slf4j
public class FilmDetailPageProcessor implements PageProcessor {
    public static FilmDetailModel collector(long film_id) {
        return new FilmDetailPageProcessor(film_id).collect().getFilmDetailModel();
    }

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(10000);
    //电影资源id
    private long film_id;

    //采集的数据
    private FilmDetailModel filmDetailModel;

    public FilmDetailPageProcessor(long film_id) {
        this.film_id = film_id;
    }

    public FilmDetailPageProcessor collect() {
        Request request = new Request(String.format("http://m.ady01.com/rs/film/detail/%s", this.film_id));
        Spider.create(this).thread(1).addRequest(request).run();
        return this;
    }

    @Override
    public void process(Page page) {
        String text = page.getRawText();
        log.info("列表页面数据：{}", text);
        this.filmDetailModel = new FilmDetailModel();
        //电影标题
        String title = page.getHtml().$("span[class='film_title']","text").get();
        this.filmDetailModel.setId(this.film_id);
        this.filmDetailModel.setTitle(title);
        //电影下载地址downList
        List<Selectable> downNodes = page.getHtml().$("div.film_downurl_txt").nodes();
        if (Objects.nonNull(downNodes)) {
            List<String> downList = downNodes.stream().map(item -> item.$("div", "text").get()).collect(Collectors.toList());
            this.filmDetailModel.setDownList(downList);
        }
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public FilmDetailModel getFilmDetailModel() {
        return filmDetailModel;
    }

    public void setFilmDetailModel(FilmDetailModel filmDetailModel) {
        this.filmDetailModel = filmDetailModel;
    }
}
