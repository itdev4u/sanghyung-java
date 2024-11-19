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

	public Map<String, Object> createPosts(Map<String, String> params) {
		// TODO Auto-generated method stub
		int insCnt = boardMapper.createPosts(params);
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		return response;
	}

	public Map<String, Object> detailPost(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Map<String, Object> boardMap = boardMapper.detailPost(params);
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("boardMap", boardMap);
		
		return response;
	}

	public Map<String, Object> deletePost(Map<String, Object> params) {
		// TODO Auto-generated method stub
		
		int delCnt = boardMapper.deletePost(params);
		Map<String, Object> response = new HashMap<String, Object>();
		return response;
	}

	public Map<String, Object> updatePost(Map<String, String> params) {
		// TODO Auto-generated method stub
		int updCnt = boardMapper.updatePost(params);
		Map<String, Object> response = new HashMap<String, Object>();
		return response;
	}
}
