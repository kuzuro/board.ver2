package com.kboard.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kboard.dao.BoardDAO;
import com.kboard.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
	}

}
