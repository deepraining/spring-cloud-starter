package dr.scs.base.model;

import lombok.Getter;
import lombok.Setter;

// 用户模型
@Setter
@Getter
public class UserModel {
  private Long id; // Id
  private String username; // 用户名
  private String avatar; // 头像
  private String nickname; // 昵称
}
