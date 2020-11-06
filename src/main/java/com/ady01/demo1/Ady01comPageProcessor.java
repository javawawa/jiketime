package com.ady01.demo1;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * <b>description</b>：第一个爬虫示例，爬去动作片列表信息 <br>
 * <b>time</b>：2019/4/20 10:58 <br>
 * <b>author</b>：微信公众号：路人甲Java，专注于java技术分享（爬虫、分布式事务、异步消息服务、任务调度、分库分表、大数据等），喜欢请关注！
 */
@Slf4j
public class Ady01comPageProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        log.info("爬取成功!");
        log.info("爬取的内容：" + page.getRawText());
    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(1000).setRetryTimes(3);
    }

    public static void main(String[] args) {
        String url = "http://m.ady01.com/rs/film/listJson/1/2?_=1555726508180";
        Spider.create(new Ady01comPageProcessor()).addUrl(url).thread(1).run();
    }
}
