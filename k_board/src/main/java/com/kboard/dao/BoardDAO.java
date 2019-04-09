package com.kboard.dao;

import com.kboard.domain.BoardVO;

public interface BoardDAO {

	public void write(BoardVO vo) throws Exception;
	
}
