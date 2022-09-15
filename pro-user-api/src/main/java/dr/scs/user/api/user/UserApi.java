package dr.scs.user.api.user;

import dr.scs.base.model.UserModel;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/rpc-api")
public interface UserApi {
  // 获取用户信息
  @RequestMapping(value = "/user/get-user-by-id", method = RequestMethod.GET)
  UserModel getUserById(@RequestParam("id") Long id);

  // 获取用户信息
  @RequestMapping(value = "/user/get-user-by-ids", method = RequestMethod.GET)
  List<UserModel> getUserByIds(@RequestParam("ids") List<Long> ids);
}
