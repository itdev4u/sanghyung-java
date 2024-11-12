package kr.co.pycoding.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardMapper {

	List<Map<String, Object>> getPosts(Map<String, String> params);

}
