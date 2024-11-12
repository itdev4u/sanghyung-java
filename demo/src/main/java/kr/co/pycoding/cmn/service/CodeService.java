package kr.co.pycoding.cmn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pycoding.Mapper.CodeMapper;

@Service
public class CodeService {
	@Autowired
	private CodeMapper codeMapper;
	public List<Map> masterLists() {
		return codeMapper.selectMasterList(null);
	}
	public Object detailList(String subject) {
		// TODO Auto-generated method stub
		return codeMapper.selectDetailList(subject);
	}

}
