package dr.scs.article.cloud.service;

import dr.scs.base.model.ArticleModel;
import dr.scs.base.model.ArticleRecord;
import java.util.List;

public interface ArticleService {

  // 获取文章信息
  ArticleModel getArticleById(Long id);

  // 获取文章信息
  List<ArticleModel> getArticleByIds(List<Long> ids);

  // 创建文章
  int createArticle(ArticleModel articleModel);

  // 获取用户的文章列表
  List<ArticleModel> getArticlesByUserId(Integer pageSize, Integer pageNum, Long userId);

  // 获取文章列表
  List<ArticleRecord> getArticleList(Integer pageSize, Integer pageNum);
}
