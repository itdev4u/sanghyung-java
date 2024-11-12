package kr.co.pycoding.cmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pycoding.cmn.service.CodeService;

@RestController
public class CodeController {
	@Autowired
	private CodeService codeService;
	
	@GetMapping("/cmn/code/master-lists")
	public ResponseEntity<?> masterLists() {
		System.out.println(">>>>>>>>>>>>>>>>>>>");
		return ResponseEntity.ok().body(codeService.masterLists());
	}
	
	@GetMapping("/cmn/code/detail/{subject}")
	public ResponseEntity<?> detailList(@PathVariable("subject") String subject) {
		System.out.println("subject ==> " + subject);
		return ResponseEntity.ok().body(codeService.detailList(subject));
	}
}
