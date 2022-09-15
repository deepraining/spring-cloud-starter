package dr.scs.article.api.article;

import dr.scs.base.model.ArticleModel;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/rpc-api")
public interface ArticleApi {
  // 获取文章信息
  @RequestMapping(value = "/article/get-article-by-id", method = RequestMethod.GET)
  ArticleModel getArticleById(@RequestParam("id") Long id);

  // 获取文章信息
  @RequestMapping(value = "/article/get-article-by-ids", method = RequestMethod.GET)
  List<ArticleModel> getArticleByIds(@RequestParam("ids") List<Long> ids);

  // 获取用户的文章列表
  @RequestMapping(value = "/article/get-articles-by-user-id", method = RequestMethod.GET)
  List<ArticleModel> getArticlesByUserId(
      @RequestParam("pageSize") Integer pageSize,
      @RequestParam("pageNum") Integer pageNum,
      @RequestParam("userId") Long userId);
}
