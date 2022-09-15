package dr.scs.user.cloud.consumer;

import dr.scs.base.exception.InternalInvokeException;
import dr.scs.base.model.ArticleModel;
import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ArticleConsumerFallback implements FallbackFactory<ArticleConsumer> {
  public static final String ERR_MSG = "网路故障，请稍后再试！";

  @Override
  public ArticleConsumer create(Throwable throwable) {
    String msg = throwable == null ? "" : throwable.getMessage();
    if (!StringUtils.isEmpty(msg)) {
      log.error(msg);
    }

    return new ArticleConsumer() {
      @Override
      public ArticleModel getArticleById(Long id) {
        throw new InternalInvokeException(ERR_MSG);
      }

      @Override
      public List<ArticleModel> getArticleByIds(List<Long> ids) {
        throw new InternalInvokeException(ERR_MSG);
      }

      @Override
      public List<ArticleModel> getArticlesByUserId(
          Integer pageSize, Integer pageNum, Long userId) {
        throw new InternalInvokeException(ERR_MSG);
      }
    };
  }
}
