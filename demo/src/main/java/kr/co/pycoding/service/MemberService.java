package kr.co.pycoding.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pycoding.Mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;

	public List<Map> list() {
		// TODO Auto-generated method stub
		HashMap param = new HashMap();
		param.put("id", 1);
		return memberMapper.selectList(param);
	}
	
	public Map<String, String> login(Map<String, String>param) {
		int rtnCnt = memberMapper.loginMember(param);
		System.out.println("rtnCnt : " + rtnCnt);
		if(rtnCnt > 0) {
			param.put("RESULT", "SUCCESS");
		} else {
			param.put("RESULT", "FAIL");
		}
		return param;
	}
}
