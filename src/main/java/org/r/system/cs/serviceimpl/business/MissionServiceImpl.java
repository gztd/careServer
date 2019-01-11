package org.r.system.cs.serviceimpl.business;

import java.text.ParseException;
import java.util.List;

import org.r.system.cs.dao.business.MissionDao;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.MissionDTO;
import org.r.system.cs.dto.business.MissionDetailInfoDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.MissionEntity;
import org.r.system.cs.entity.business.RequestEntity;
import org.r.system.cs.enums.business.PropertyEnum;
import org.r.system.cs.enums.business.SettleTypeEnum;
import org.r.system.cs.exception.business.CloseMissionException;
import org.r.system.cs.exception.business.FileInsertException;
import org.r.system.cs.exception.business.FileSelectException;
import org.r.system.cs.service.business.MissionService;
import org.r.system.cs.service.business.RequestService;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MissionServiceImpl implements MissionService {

	@Autowired
	private MissionDao missionDao;
	@Autowired
	private RequestService requestService;

	@Override
	public Object getFile(Object primaryKey) {
		return null;
	}

	/**
	 * 传入MissionDTO,创建任务记录。如果dto的陪护人员id数组不为空，将视为批量创建
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午3:54:49
	 * @param primaryKey
	 * @return
	 */
	@Override
	@Transactional
	public Object createFile(Object dto) {

		MissionDTO missions = (MissionDTO) dto;
		MissionEntity mission = new MissionEntity();
		mission.setDateTime(
				missions.getDateTime() == null ? UtilTool.getSystemCurrentDateTime() : missions.getDateTime());
		mission.setRequestCode(missions.getRequestCode());

		if (missions.getCareworkerIds() == null || missions.getCareworkerIds().isEmpty()) {
			if (missions.getCareworkerId() == null)
				throw new FileInsertException("陪护人员id不能为空");
			mission.setCareworkerId(missions.getCareworkerId());
			mission.setCode("MI" + System.currentTimeMillis());
			missionDao.insertFile(mission);
		} else {
			for (Long careworkerId : missions.getCareworkerIds()) {
				mission.setCareworkerId(careworkerId);
				mission.setCode("MI" + System.currentTimeMillis());
				missionDao.insertFile(mission);
			}
		}
		return null;
	}

	@Override
	public void updateFile(Object dto) {

	}

	@Override
	public ListDTO<MissionDetailInfoDTO> getMissionList(SearchConditionDTO dto) {
		ListDTO<MissionDetailInfoDTO> result = new ListDTO<>();
		result.setResult(buildList(missionDao.selectMissionList(dto)));
		result.setSize(missionDao.countFileList(dto));
		return result;
	}

	@Override
	public ListDTO<MissionDetailInfoDTO> getMissionDetail(SearchConditionDTO dto) {
		if (dto.getRequestCode() == null)
			throw new FileSelectException("查询任务详细信息时，服务请求单编号不能为空");
		ListDTO<MissionDetailInfoDTO> result = new ListDTO<>();
		result.setResult(buildList(missionDao.selectMissionDetailList(dto)));
		result.setSize(missionDao.countFileList(dto));
		return result;
	}

	private List<MissionDetailInfoDTO> buildList(List<MissionDetailInfoDTO> list) {
		for (MissionDetailInfoDTO item : list) {
			if (item.getCareTypePorperty() != null)
				item.setCareTypePorperty(PropertyEnum.getSate((int) item.getCareTypePorperty()));
			if (item.getCareTypeSettleType() != null)
				item.setCareTypeSettleType(SettleTypeEnum.getSate((int) item.getCareTypeSettleType()));
		}
		return list;
	}

	@Override
	@Transactional
	public void closeMission(String requestCode, String date) {
		if (date == null)
			date = UtilTool.getSystemCurrentDateTime();

		RequestEntity request = (RequestEntity) requestService.getFile(requestCode);
		try {
			request.setEndDateTime(UtilTool.getTimestampByDateTimeString(date));
			requestService.updateFile(request);
			request.setStartDateTime(request.getEndDateTime());
			request.setEndDateTime(null);
			requestService.createFile(request);
		} catch (ParseException e) {
			throw new CloseMissionException("时间格式有误");
		}
	}

}
