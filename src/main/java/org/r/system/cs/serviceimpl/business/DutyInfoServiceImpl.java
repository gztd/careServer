package org.r.system.cs.serviceimpl.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.r.system.cs.dao.business.DutyInfoDao;
import org.r.system.cs.dto.business.DutyDetailDTO;
import org.r.system.cs.dto.business.DutyInfoDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.RoutineInfoDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.DutyInfoEntity;
import org.r.system.cs.enums.business.DutyPropertyEnum;
import org.r.system.cs.enums.business.ScheduleEnum;
import org.r.system.cs.service.business.DutyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DutyInfoServiceImpl implements DutyInfoService {

	@Autowired
	private DutyInfoDao dutyDao;

	@Override
	public Object getFile(Object primaryKey) {
		return null;
	}

	@Override
	@Transactional
	public Object createFile(Object dto) {

		DutyInfoDTO info = (DutyInfoDTO) dto;
		DutyInfoEntity duty = new DutyInfoEntity();
		String[] dates = info.getDate().split("-");
		duty.setYear(dates[0]);
		duty.setMonth(dates[1]);
		duty.setDay(dates[2]);
		duty.setDayIndex(info.getDayIndex());
		duty.setProperty(info.getProperty());
		duty.setSchedule(info.getSchedule());
		for (Long careworkerId : info.getCareworkerIds()) {
			duty.setCareworkerId(careworkerId);
			dutyDao.deleteFile(duty);
			dutyDao.insertFile(duty);
		}

		return null;
	}

	@Override
	@Transactional
	public void updateFile(Object dto) {
		DutyInfoEntity duty = new DutyInfoEntity();

		DutyInfoDTO info = (DutyInfoDTO) dto;
		String[] dates = info.getDate().split("-");
		duty.setYear(dates[0]);
		duty.setMonth(dates[1]);
		duty.setDay(dates[2]);
		duty.setIsWorked(info.getIsWorked());
		for (Long careworkerId : info.getCareworkerIds()) {
			duty.setCareworkerId(careworkerId);
			dutyDao.updateFile(duty);
		}
	}

	@Override
	public ListDTO<DutyDetailDTO> getDutyInfoList(SearchConditionDTO dto) {
		ListDTO<DutyDetailDTO> result = new ListDTO<>();
		List<Map<String, Object>> dutyDetails = dutyDao.selectDutyInfoDetail(dto);
		Map<Long, DutyDetailDTO> tmp = new HashMap<>();

		for (Map<String, Object> dutyInfo : dutyDetails) {
			DutyDetailDTO detail = tmp.get(dutyInfo.get("careworkerId"));
			if (detail == null) {
				detail = new DutyDetailDTO();
				detail.setCareworkerId((Long) dutyInfo.get("careworkerId"));
				detail.setCareworkerName((String) dutyInfo.get("careworkerName"));
				detail.setRoutineInfoDTO(new ArrayList<>());
				tmp.put((Long) dutyInfo.get("careworkerId"), detail);
			}
			RoutineInfoDTO routine = new RoutineInfoDTO();
			routine.setDate((String) dutyInfo.get("year") + "-" + dutyInfo.get("month") + "-" + dutyInfo.get("day"));
			routine.setProperty(DutyPropertyEnum.getSate((int) dutyInfo.get("property")));
			routine.setSchedule(ScheduleEnum.getSate((int) dutyInfo.get("schedule")));
			routine.setIsWorked((Boolean) dutyInfo.get("isWorked"));
			routine.setDayIndex((Integer) dutyInfo.get("dayIndex"));
			detail.getRoutineInfoDTO().add(routine);
		}

		result.setResult(new ArrayList<>());
		result.setSize(dutyDao.countFileList(dto));

		for (Entry<Long, DutyDetailDTO> item : tmp.entrySet()) {
			result.getResult().add(item.getValue());
		}

		return result;
	}

}
