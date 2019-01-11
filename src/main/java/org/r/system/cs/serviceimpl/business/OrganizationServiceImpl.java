package org.r.system.cs.serviceimpl.business;

import java.util.ArrayList;
import java.util.List;
import org.r.system.cs.dao.business.OrganizationDao;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.OrganizationDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.OrganizationEntity;
import org.r.system.cs.exception.business.FileInsertException;
import org.r.system.cs.service.business.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDao orgDao;


	@Override
	public Object getFile(Object primaryKey) {
		return orgDao.selectFile(primaryKey);
	}

	@Override
	@Transactional
	public Object createFile(Object dto) {
		OrganizationDTO info = (OrganizationDTO) dto;
		OrganizationEntity org = null;
		if(info.getFaId() != null) {
			org = (OrganizationEntity) this.getFile(info.getFaId());
			if(org.getProjectId() != info.getProjectId())
				throw new FileInsertException("待增加的科室和父科室不在同一个项目中");
		}
		orgDao.insertFile(dto);
		return null;
	}

	@Override
	@Transactional
	public void updateFile(Object dto) {
		orgDao.updateFile(dto);
	}

	@Override
	public ListDTO<OrganizationDTO> getOrganizationList(SearchConditionDTO dto) {
		dto.setPageSize(null);
		ListDTO<OrganizationDTO> result = new ListDTO<>();
		result.setSize(orgDao.countFileList(dto));
		List<OrganizationDTO> list = new ArrayList<>();
		SearchConditionDTO childCondition = new SearchConditionDTO();
		childCondition.setProjectId(dto.getProjectId());

		for (OrganizationEntity item : orgDao.selectFileList(dto)) {
			childCondition.setOrgId(item.getId());
			OrganizationDTO target = new OrganizationDTO();
			target.setAddress(item.getAddress());
			target.setCode(item.getCode());
			target.setFaId(item.getFaId());
			target.setId(item.getId());
			target.setIsDisabled(item.getIsDisabled());
			target.setName(item.getName());
			target.setPhone(item.getPhone());
			target.setPrincipal(item.getPrincipal());
			target.setProjectId(item.getProjectId());
			target.setIsLeaf(orgDao.countFileList(childCondition) == 0);
			list.add(target);
		}
		result.setResult(list);
		return result;
	}

	@Override
	@Transactional
	public void disableOrg(Integer id, Boolean status) {
		OrganizationEntity org = new OrganizationEntity();
		org.setId(id);
		org.setIsDisabled(status);
		this.updateFile(org);
	}

}
