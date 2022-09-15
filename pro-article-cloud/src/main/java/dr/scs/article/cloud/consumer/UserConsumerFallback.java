package dr.scs.article.cloud.consumer;

import dr.scs.base.exception.InternalInvokeException;
import dr.scs.base.model.UserModel;
import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserConsumerFallback implements FallbackFactory<UserConsumer> {
  public static final String ERR_MSG = "网路故障，请稍后再试！";

  @Override
  public UserConsumer create(Throwable throwable) {
    String msg = throwable == null ? "" : throwable.getMessage();
    if (!StringUtils.isEmpty(msg)) {
      log.error(msg);
    }

    return new UserConsumer() {
      @Override
      public UserModel getUserById(Long id) {
        throw new InternalInvokeException(ERR_MSG);
      }

      @Override
      public List<UserModel> getUserByIds(List<Long> ids) {
        throw new InternalInvokeException(ERR_MSG);
      }
    };
  }
}
