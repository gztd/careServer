package org.r.system.cs.serviceimpl.business;

import java.util.ArrayList;
import java.util.List;

import org.r.system.cs.dao.business.CareTypeDao;
import org.r.system.cs.dto.business.CareTypeInfoDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.CareTypeEntity;
import org.r.system.cs.enums.business.PropertyEnum;
import org.r.system.cs.enums.business.SettleTypeEnum;
import org.r.system.cs.exception.business.FileDeleteException;
import org.r.system.cs.exception.business.FileInsertException;
import org.r.system.cs.service.business.CareTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CareTypeSerivceImpl implements CareTypeService {

	@Autowired
	private CareTypeDao careTypeDao;

	@Override
	public Object getFile(Object primaryKey) {
		CareTypeEntity entity = (CareTypeEntity) careTypeDao.selectFile(primaryKey);
		CareTypeInfoDTO info = new CareTypeInfoDTO();
		info.setId(entity.getId());
		info.setIsDefault(entity.getIsDefault());
		info.setName(entity.getName());
		info.setPrice(entity.getPrice());
		info.setProjectId(entity.getProjectId());
		info.setSalaryIndex(entity.getSalaryIndex());
		info.setProperty(entity.getProperty());
		info.setSettleType(entity.getSettleType());
		info.setSettleTypeName(SettleTypeEnum.getSate(entity.getSettleType()));
		info.setPropertyName(PropertyEnum.getSate(entity.getProperty()));
		return info;
	}

	@Override
	@Transactional
	public Object createFile(Object dto) {
		CareTypeEntity careType = (CareTypeEntity) dto;
		careType.setSalaryIndex(careType.getSalaryIndex() / 100);
		if (careType.getSalaryIndex() > 1 || careType.getSalaryIndex() <= 0)
			throw new FileInsertException("工资计算系数不能为负数/大于100");

		careTypeDao.insertFile(careType);
		return null;
	}

	@Override
	@Transactional
	public void updateFile(Object dto) {
		CareTypeEntity careType = (CareTypeEntity) dto;
		careType.setSalaryIndex(careType.getSalaryIndex() / 100);
		if (careType.getSalaryIndex() > 1 || careType.getSalaryIndex() <= 0)
			throw new FileInsertException("工资计算系数不能为负数/大于100");
		try {
			careTypeDao.deleteFile(careType.getId());
			this.createFile(careType);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new FileDeleteException(
					"id:" + careType.getId() + " name:" + careType.getName() + " 的陪护类型有服务单关联，不能修改");
		}
	}

	@Override
	public ListDTO<CareTypeInfoDTO> getFileList(SearchConditionDTO dto) {

		ListDTO<CareTypeInfoDTO> result = new ListDTO<>();

		List<CareTypeInfoDTO> list = new ArrayList<>();

		for (CareTypeEntity item : careTypeDao.selectFileList(dto)) {
			CareTypeInfoDTO info = new CareTypeInfoDTO();
			info.setId(item.getId());
			info.setIsDefault(item.getIsDefault());
			info.setName(item.getName());
			info.setPrice(item.getPrice());
			info.setProjectId(item.getProjectId());
			info.setSalaryIndex(item.getSalaryIndex()*100);
			info.setPropertyName(PropertyEnum.getSate(item.getProperty()));
			info.setSettleTypeName(SettleTypeEnum.getSate(item.getSettleType()));
			list.add(info);
		}
		result.setResult(list);
		result.setSize(careTypeDao.countFileList(dto));
		return result;
	}

}
