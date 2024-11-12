package kr.co.pycoding.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pycoding.board.service.BoardService;

@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board/getPosts")
	@CrossOrigin(origins = "http://localhost:5173/")
	public ResponseEntity<?> getPosts(@RequestBody Map<String, String> params) {
		//return ResponseEntity.ok().body(memberService.login(param));
		System.out.println("getPosts START : " + params.toString());
		Map<String, Object> rntMap = boardService.getPosts(params);
		return new ResponseEntity<Map<String, Object>>(rntMap, HttpStatus.OK);
	}
}
