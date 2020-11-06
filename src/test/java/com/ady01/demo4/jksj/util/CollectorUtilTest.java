package com.ady01.demo4.jksj.util;


import com.ady01.demo4.jksj.column.ColumnCollectorResponse;
import com.ady01.demo4.jksj.detail.ArticleCollectorResponse;
import com.ady01.demo4.jksj.dto.ColumnDto;
import com.ady01.util.FrameUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * <b>极客时间专栏课程采集；修改 cid 为课程id；修改{@link com.ady01.demo4.jksj.util.CollectorUtil#COOKIE_VALUE}的值; <br/>
 * 然后运行{@link com.ady01.demo4.jksj.util.CollectorUtilTest#articleList}</b>
 * <b>time</b>：2018-10-15 09:48 <br>
 * <b>author</b>： 微信公众号：路人甲Java，专注于java技术分享（带你玩转 爬虫、分布式事务、异步消息服务、任务调度、分库分表、大数据等），喜欢请关注！
 */
@Slf4j
public class CollectorUtilTest {

    @Test
    public void articleList() throws Exception {
        //需要采集的专栏id
        long cid = 274L;
        ColumnDto columnDto = CollectorUtil.articleList(cid);
        ColumnCollectorResponse columnCollectorResponse = columnDto.getColumnCollectorResponse();
        List<ArticleCollectorResponse> articleCollectorResponseList = columnDto.getArticleCollectorResponseList();
        String articleCollectorResponseListJson = FrameUtil.json(articleCollectorResponseList, true);
        log.info("articleCollectorResponseList:{}", articleCollectorResponseListJson);
        String s = FreemarkerUtil.getFtlToString("column",
                FrameUtil.newHashMap(
                        "articleCollectorResponseListJson", articleCollectorResponseListJson,
                        "columnCollectorResponse", columnCollectorResponse));
        //将采集生成的html保存到本地
        FileUtils.write(new File("D:\\极客时间\\" + columnCollectorResponse.getColumn_title() + ".html"), s, "utf-8");
    }
}
