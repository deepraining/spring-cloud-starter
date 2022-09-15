package dr.scs.base.model;

import lombok.Getter;
import lombok.Setter;

// 文章模型
@Setter
@Getter
public class ArticleRecord extends ArticleModel {
  private UserModel authorItem;
}
