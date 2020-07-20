package com.bbs.starter.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bbs.starter.dto.Article;
@Mapper//Mybatis 使用の為
public interface ArticleDao {
	public List<Article> getList();

	public void add(Map<String,Object> param);


}
