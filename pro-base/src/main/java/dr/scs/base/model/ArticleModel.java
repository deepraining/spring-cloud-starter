package dr.scs.base.model;

import lombok.Getter;
import lombok.Setter;

// 文章模型
@Setter
@Getter
public class ArticleModel {
  private Long id; // Id
  private Long authorId; // 作者Id
  private String title; // 标题
  private String intro; // 介绍
  private String detail; // 详情
}
