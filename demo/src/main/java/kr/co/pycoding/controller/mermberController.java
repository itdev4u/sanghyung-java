package kr.co.pycoding.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pycoding.service.MemberService;

@RestController
public class mermberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping(value="/member/lists")
	public ResponseEntity<?> list() {
		return ResponseEntity.ok().body(memberService.list());
	}
	
	@PostMapping(value="/api/member/login")
	@CrossOrigin(origins = "http://localhost:5173/")
	public ResponseEntity<?> login(@RequestBody Map<String, String> param) {
		return ResponseEntity.ok().body(memberService.login(param));
	}
}
