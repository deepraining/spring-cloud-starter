package dr.scs.article.cloud.consumer;

import dr.scs.base.util.SysUtils;
import dr.scs.user.api.user.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = SysUtils.USER_SERVER_PROVIDER, fallbackFactory = UserConsumerFallback.class)
public interface UserConsumer extends UserApi {}
