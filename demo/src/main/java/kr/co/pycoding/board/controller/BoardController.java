package kr.co.pycoding.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pycoding.board.service.BoardService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board/getPosts")	
	public ResponseEntity<?> getPosts(@RequestBody Map<String, String> params) {
		//return ResponseEntity.ok().body(memberService.login(param));
		System.out.println("getPosts START : " + params.toString());
		int offSet = (Integer.parseInt(params.get("_page")) -1) * Integer.parseInt(params.get("_limit"));
		params.put("offSet", String.valueOf(offSet));
		Map<String, Object> rtnMap = boardService.getPosts(params);
		return new ResponseEntity<Map<String, Object>>(rtnMap, HttpStatus.OK);
	}
	
	@PostMapping("/api/board/posts")
	public ResponseEntity<?> createPosts(@RequestBody Map<String, String> params) {
		System.out.println("createPosts START : " + params.toString());
		Map<String, Object> rtnMap = boardService.createPosts(params);
		return new ResponseEntity<Map<String, Object>>(rtnMap, HttpStatus.OK);
	}
	
	@GetMapping("/api/board/posts/{uuid}")
	public ResponseEntity<?> detailPost(@PathVariable ("uuid") int uuid) {
		System.out.println("uuid ==> " + uuid);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uuid", uuid);
		Map<String, Object> rtnMap = boardService.detailPost(params);
		
		return new ResponseEntity<Map<String, Object>>(rtnMap, HttpStatus.OK);
	}
	
	@PutMapping("/api/board/posts/{uuid}")
	public ResponseEntity<?> updatePost(@PathVariable ("uuid") int uuid
									, @RequestBody Map<String, String> params) {
		System.out.println("uuid ==> " + uuid);
		System.out.println("params ==> " + params.toString());
		params.put("uuid", String.valueOf(uuid));
		Map<String, Object> rtnMap = boardService.updatePost(params);
		
		return new ResponseEntity<Map<String, Object>>(rtnMap, HttpStatus.OK);
	}
	
	@DeleteMapping("/api/board/posts/{uuid}")
	public ResponseEntity<?> deletePost(@PathVariable ("uuid") int uuid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uuid", uuid);
		Map<String, Object> rtnMap = boardService.deletePost(params);
		return new ResponseEntity<Map<String, Object>>(rtnMap, HttpStatus.OK);
	}
}
