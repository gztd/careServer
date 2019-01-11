package org.r.system.cs.serviceimpl.business;

import java.util.ArrayList;
import java.util.List;

import org.r.system.cs.dao.business.DocFileDao;
import org.r.system.cs.dto.business.DocFileDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.DocFileEntity;
import org.r.system.cs.service.business.DocFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocFileServiceImpl implements DocFileService {

	@Autowired
	private DocFileDao docFiledao;

	@Override
	public Object getFile(Object primaryKey) {
		return docFiledao.selectFile(primaryKey);
	}

	@Override
	@Transactional
	public Object createFile(Object dto) {
		DocFileEntity file = (DocFileEntity) dto;
		file.setCurrentCode(file.getStartCode());
		docFiledao.insertFile(file);
		return null;
	}

	@Override
	@Transactional
	public void updateFile(Object dto) {
		docFiledao.updateFile((DocFileEntity) dto);
	}

	@Override
	public ListDTO<DocFileDTO> getDocFileList(SearchConditionDTO dto) {
		ListDTO<DocFileDTO> result = new ListDTO<>();
		result.setSize(docFiledao.countFileList(dto));
		List<DocFileDTO> list = new ArrayList<>();
		for (DocFileEntity item : docFiledao.selectFileList(dto)) {
			DocFileDTO target = new DocFileDTO();
			target.setCurrentCode(item.getCurrentCode());
			target.setStartCode(item.getStartCode());
			target.setEndCode(item.getEndCode());
			target.setName(item.getName());
			target.setId(item.getId());
			target.setProjectId(item.getProjectId());
			
			list.add(target);
		}
		result.setResult(list);
		return result;
	}

}
