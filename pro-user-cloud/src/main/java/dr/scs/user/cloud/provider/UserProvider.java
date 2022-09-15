package dr.scs.user.cloud.provider;

import dr.scs.base.model.UserModel;
import dr.scs.user.api.user.UserApi;
import dr.scs.user.cloud.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProvider implements UserApi {
  @Autowired private UserService userService;

  @Override
  public UserModel getUserById(@RequestParam("id") Long id) {
    return userService.getUserById(id);
  }

  @Override
  public List<UserModel> getUserByIds(@RequestParam("ids") List<Long> ids) {
    return userService.getUserByIds(ids);
  }
}
