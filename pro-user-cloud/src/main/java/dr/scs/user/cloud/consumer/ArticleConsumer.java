package dr.scs.user.cloud.consumer;

import dr.scs.article.api.article.ArticleApi;
import dr.scs.base.util.SysUtils;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
    value = SysUtils.ARTICLE_SERVER_PROVIDER,
    fallbackFactory = ArticleConsumerFallback.class)
public interface ArticleConsumer extends ArticleApi {}
