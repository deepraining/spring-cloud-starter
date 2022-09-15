package dr.scs.user.cloud.service;

import dr.scs.base.model.ArticleModel;
import dr.scs.base.model.UserModel;
import dr.scs.user.cloud.consumer.ArticleConsumer;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
  @Autowired private ArticleConsumer articleConsumer;

  private UserModel generateFakeUserModel(Long id) {
    UserModel userModel = new UserModel();
    userModel.setId(id);
    userModel.setUsername("你好呀" + id);
    userModel.setAvatar("你好你好呀" + id);
    userModel.setNickname("你好你好你好呀" + id);
    return userModel;
  }

  @Override
  public UserModel getUserById(Long id) {
    return generateFakeUserModel(id);
  }

  @Override
  public List<UserModel> getUserByIds(List<Long> ids) {
    List<UserModel> result = new ArrayList<>();
    for (Long id : ids) {
      result.add(generateFakeUserModel(id));
    }
    return result;
  }

  @Override
  public int updateUserById(UserModel userModel) {
    // do something with userModel
    return 1;
  }

  @Override
  public List<ArticleModel> getArticleList(Integer pageSize, Integer pageNum) {
    return articleConsumer.getArticlesByUserId(pageSize, pageNum, 1L);
  }
}
