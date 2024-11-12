package kr.co.pycoding.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pycoding.Mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;

	public Map<String, Object> getPosts(Map<String, String> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> boardList = boardMapper.getPosts(params);
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("boardList", boardList);
		return response;
	}
}
