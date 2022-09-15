package dr.scs.article.cloud.controller;

import dr.scs.article.cloud.service.ArticleService;
import dr.scs.base.CommonResult;
import dr.scs.base.model.ArticleModel;
import dr.scs.base.model.ArticleRecord;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {
  @Autowired private ArticleService articleService;

  @RequestMapping(value = "/articleList", method = RequestMethod.GET)
  public CommonResult<List<ArticleRecord>> articleList(
      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
    List<ArticleRecord> list = articleService.getArticleList(pageSize, pageNum);
    return CommonResult.success(list);
  }

  @RequestMapping(value = "/createArticle", method = RequestMethod.POST)
  public CommonResult<Integer> createArticle(@RequestBody ArticleModel articleModel) {
    return CommonResult.success(articleService.createArticle(articleModel));
  }
}
