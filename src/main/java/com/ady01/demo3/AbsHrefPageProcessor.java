package com.ady01.demo3;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * <b>description</b>：webmagic中获取绝对路径 <br>
 * <b>time</b>：2019/4/22 10:42 <br>
 * <b>author</b>：微信公众号：路人甲Java，专注于java技术分享（带你玩转 爬虫、分布式事务、异步消息服务、任务调度、分库分表、大数据等），喜欢请关注！
 */
@Slf4j
public class AbsHrefPageProcessor implements PageProcessor {
    Site site = Site.me().setSleepTime(1000);

    @Override
    public void process(Page page) {
        //获取超链接绝对路径的方式
        log.info("----------------------xpath方式获取------------------------");
        //xpath方式获取
        log.info("{}", page.getHtml().xpath("//div[@id='cyldata']").links().all());
        log.info("{}", page.getHtml().xpath("//div[@id='cyldata']//a//@abs:href").all());

        //xpath+css选择器方式获取
        log.info("----------------------xpath+css选择器方式获取------------------------");
        log.info("{}", page.getHtml().xpath("//div[@id='cyldata']").css("a", "abs:href").all());

        //css选择器方式获取
        log.info("----------------------css选择器方式获取------------------------");
        log.info("{}", page.getHtml().css("div[id='cyldata']").css("a", "abs:href").all());
        log.info("{}", page.getHtml().css("div[id='cyldata']").links().all());
        log.info("{}", page.getHtml().css("div[id='cyldata'] a").links().all());
        log.info("{}", page.getHtml().css("div[id='cyldata'] a", "abs:href").all());

        //jsoup方式获取
        log.info("----------------------jsoup方式获取------------------------");
        for (Element element : Jsoup.parse(page.getRawText(), page.getRequest().getUrl()).select("#cyldata a")) {
            log.info("{}", element.attr("abs:href"));
            log.info("{}", element.absUrl("href"));
        }

        //jsoup中stringutil工具类方式获取
        log.info("----------------------jsoup中stringutil工具类方式获取------------------------");
        for (Element element : Jsoup.parse(page.getRawText(), page.getRequest().getUrl()).select("#cyldata a")) {
            log.info("{}", StringUtil.resolve(page.getRequest().getUrl(), element.attr("href")));
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Request request = new Request("http://industry.hexun.com/c193_59.shtml");
        Spider.create(new AbsHrefPageProcessor()).addRequest(request).run();
    }
}
