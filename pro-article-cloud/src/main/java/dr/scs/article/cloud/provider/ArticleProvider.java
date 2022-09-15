package dr.scs.article.cloud.provider;

import dr.scs.article.api.article.ArticleApi;
import dr.scs.article.cloud.service.ArticleService;
import dr.scs.base.model.ArticleModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleProvider implements ArticleApi {
  @Autowired private ArticleService articleService;

  @Override
  public ArticleModel getArticleById(@RequestParam("id") Long id) {
    return articleService.getArticleById(id);
  }

  @Override
  public List<ArticleModel> getArticleByIds(@RequestParam("ids") List<Long> ids) {
    return articleService.getArticleByIds(ids);
  }

  @Override
  public List<ArticleModel> getArticlesByUserId(Integer pageSize, Integer pageNum, Long userId) {
    return articleService.getArticlesByUserId(pageSize, pageNum, userId);
  }
}
