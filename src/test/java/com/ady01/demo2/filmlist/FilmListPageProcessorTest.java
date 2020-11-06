package com.ady01.demo2.filmlist;

import com.ady01.util.FrameUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <b>description</b>： <br>
 * <b>time</b>：2019/4/21 13:59 <br>
 * <b>author</b>：微信公众号：路人甲Java，专注于java技术分享（爬虫、分布式事务、异步消息服务、任务调度、分库分表、大数据等），喜欢请关注！
 */
@Slf4j
public class FilmListPageProcessorTest {

    @Test
    public void collect() {
        String url = "http://m.ady01.com/rs/film/listJson/1/1";
        PageModel collector = FilmListPageProcessor.collector(url);
        log.info("\n\n\n列表页面数:{}", FrameUtil.json(collector,true));
    }
}
