package org.r.system.cs.service.business;

import org.r.system.cs.dto.business.EntryDTO;
import org.r.system.cs.dto.business.CareworkerInfoDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.CareworkerEntity;

public interface CareworkerService extends BaseService {

	/**
	 * 员工入职
	 * 
	 * @param info
	 * @return
	 */
	public String entry(EntryDTO info);

	/**
	 * 员工离职
	 * 
	 * @param code
	 *            （员工记录号）
	 * @param enddatetime
	 * @return
	 */
	public void leave(Long careworkerId, String endDateTime);

	/**
	 * 变更陪护人员的在职信息（所属科室）
	 * 
	 * @author Casper
	 * @date 2018年11月22日 上午12:38:04
	 * @param info
	 */
	public void change(EntryDTO info);

	/**
	 * 获取陪护人员档案资料列表
	 * 
	 * @author Casper
	 * @date 2018年11月11日 下午2:09:10
	 * @param dto
	 * @return
	 */
	public ListDTO<CareworkerEntity> getFileList(SearchConditionDTO dto);

	/**
	 * 查询陪护人员简要信息列表，包括姓名，编号，科室，入职时间，离职时间
	 * 
	 * @author Casper
	 * @date 2018年11月11日 下午2:44:33
	 * @param dto
	 * @return
	 */
	public ListDTO<CareworkerInfoDTO> getCareworkerInfoList(SearchConditionDTO dto);

}
