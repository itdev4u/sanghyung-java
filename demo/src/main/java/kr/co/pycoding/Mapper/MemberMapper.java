package kr.co.pycoding.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {

	List<Map> selectList(HashMap param);

	int loginMember(Map<String, String> param);

}
