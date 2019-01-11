/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.dao 
 * @author: Casper   
 * @date: 2018年10月30日 下午8:12:13 
 */
package org.r.system.cs.dao.baseinfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.baseinfo.SearchConditionDTO;
import org.r.system.cs.entity.baseinfo.ArrearageEntity;

/**
 * @author Casper
 *
 */
@Mapper
public interface ArrearageRecordDao {
	/**
	 * 查询欠费记录列表
	 * 
	 * @author Casper
	 * @date 2018年10月30日 上午11:57:07
	 * @param dto
	 * @return 欠费记录列表
	 */
	public List<ArrearageEntity> selectArrearageList(SearchConditionDTO dto);

	/**
	 * 统计欠费列表的总长度，即所有查询结果的数量
	 * 
	 * @author Casper
	 * @date 2018年10月30日 下午12:04:45
	 * @param dto
	 * @return 所有查询结果的数量
	 */
	public int countArrearageListLength(SearchConditionDTO dto);

}
