package com.ady01.demo2.filmdetail;

import com.ady01.util.FrameUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <b>description</b>： <br>
 * <b>time</b>：2019/4/21 13:59 <br>
 * <b>author</b>：微信公众号：路人甲Java，专注于java技术分享（爬虫、分布式事务、异步消息服务、任务调度、分库分表、大数据等），喜欢请关注！
 */
@Slf4j
public class FilmDetailPageProcessorTest {
    @Test
    public void collect() {
        long film_id = 46612L;
        FilmDetailModel filmDetailModel = FilmDetailPageProcessor.collector(46612L);
        log.info("\n\n\n电影《海王》详情:{}", FrameUtil.json(filmDetailModel, true));
    }

}
