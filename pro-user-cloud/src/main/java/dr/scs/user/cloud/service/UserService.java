package dr.scs.user.cloud.service;

import dr.scs.base.model.ArticleModel;
import dr.scs.base.model.UserModel;
import java.util.List;

public interface UserService {

  UserModel getUserById(Long id);

  List<UserModel> getUserByIds(List<Long> ids);

  int updateUserById(UserModel userModel);

  List<ArticleModel> getArticleList(Integer pageSize, Integer pageNum);
}
