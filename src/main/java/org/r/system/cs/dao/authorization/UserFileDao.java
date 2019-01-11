/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.dao.authorization 
 * @author: Casper   
 * @date: 2018年11月1日 上午9:31:11 
 */
package org.r.system.cs.dao.authorization;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.entity.authorization.UserFileEntity;

/**
 * @author Casper
 *
 */
@Mapper
public interface UserFileDao {

	/**
	 * 插入一条用户记录
	 * 
	 * @author Casper
	 * @date 2018年11月1日 上午10:17:42
	 * @param target
	 * @return 影响行数
	 */
	public int insertUserFile(UserFileEntity target);

	/**
	 * 更新一条用户记录
	 * 
	 * @author Casper
	 * @date 2018年11月1日 上午10:18:12
	 * @param target
	 * @return 影响行数
	 */
	public int updateUserFile(UserFileEntity target);

	/**
	 * 选择一条用户记录
	 * 
	 * @author Casper
	 * @date 2018年11月1日 上午10:18:32
	 * @param username
	 * @return 一个用户实体
	 */
	public UserFileEntity selectUserFile(String username);

	/**
	 * 根据条件查询用户记录列表
	 * 
	 * @author Casper
	 * @date 2018年11月1日 上午10:19:57
	 * @param username
	 *            用户名，模糊查询
	 * @param nickname
	 *            用户别名，模糊查询
	 * @param isLocked
	 *            是否锁上，精准匹配
	 * @param isDisable
	 *            是否不可用，精准匹配
	 * @param curPage
	 *            当前页号
	 * @param pageSize
	 *            当前页大小
	 * @return 一页的用户记录
	 */
	public List<Map<String, Object>> selectUserFileList(SearchConditionDTO dto);

	/**
	 * 搭配查询用户记录列表使用，统计相同条件时，总结果数
	 * 
	 * @author Casper
	 * @date 2018年11月1日 上午10:22:02
	 * @param username
	 * @param nickname
	 * @param isLocked
	 * @param isDisable
	 * @return 总结果条目数
	 */
	public int countUserFileListLength(SearchConditionDTO dto);

}
