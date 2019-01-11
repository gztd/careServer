package org.r.system.cs.serviceimpl.baseinfo;

import java.util.List;

import org.r.system.cs.dao.baseinfo.BehaivorDao;
import org.r.system.cs.dto.baseinfo.BehaivorDTO;
import org.r.system.cs.dto.baseinfo.EmpinfoDTO;
import org.r.system.cs.service.baseinfo.BehaivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BehaivorServiceImpl implements BehaivorService {

	@Autowired
	private BehaivorDao dao;
	
	/**
	 * 添加行为记录
	 */
	@Override
	@Transactional
	public String addBehaivor(BehaivorDTO dto) {
		
		String code="BE"+System.currentTimeMillis();
		dto.setCode(code);		
		dao.insertBehaivor(dto);		
		return code;
	}
    /**
     * 查询行为记录列表
     */
	@Override
	public List<BehaivorDTO> getBehaivorinfo(EmpinfoDTO dto) {
		
		return dao.selectByBehaivorinfo(dto);
	}

	/**
	 * 查询行为记录
	 */
	@Override
	public BehaivorDTO getCode(String code) {
		return dao.selectByCode(code);
	}
	/**
	 * 查询行为记录的总条数
	 */
	@Override
	public int getbListCount(EmpinfoDTO dto) {
		return dao.selectbListCount(dto);
	}

	
	
}
