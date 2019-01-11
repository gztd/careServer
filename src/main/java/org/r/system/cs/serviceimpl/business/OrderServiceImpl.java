/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:33:47 
 */
package org.r.system.cs.serviceimpl.business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.r.system.cs.dao.business.OrderDao;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.OrderInfoDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.OrderEntity;
import org.r.system.cs.exception.business.FileInsertException;
import org.r.system.cs.service.business.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Casper
 *
 */
@Component
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.r.system.cs.service.business.BaseService#getFile(java.lang.Object)
	 */
	@Override
	public Object getFile(Object primaryKey) {

		OrderEntity target = null;
		if (primaryKey instanceof String) {
			target = (OrderEntity) orderDao.selectFileByCode((String) primaryKey);
		} else if (primaryKey instanceof Long) {
			target = (OrderEntity) orderDao.selectFile(primaryKey);
		}

		return target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.business.BaseService#createFile(java.lang.Object)
	 */
	@Override
	@Transactional
	public Object createFile(Object dto) {
		OrderEntity order = null;
		try {
			order = ((OrderInfoDTO) dto).build();
			orderDao.insertFile(order);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new FileInsertException("时间格式出错");
		}
		return order.getId();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.business.BaseService#updateFile(java.lang.Object)
	 */
	@Override
	public void updateFile(Object dto) {
		orderDao.updateFile(dto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.business.BaseService#getFileList(org.r.system.cs.util
	 * .dto.SearchConditionDTO)
	 */
	@Override
	public ListDTO<OrderEntity> getFileList(SearchConditionDTO dto) {

		List<Object> result = orderDao.selectFileList(dto);
		List<OrderEntity> list = new ArrayList<>();

		for (Object tmp : result) {
			list.add((OrderEntity) tmp);
		}

		int size = orderDao.countFileList(dto);
		ListDTO<OrderEntity> target = new ListDTO<>();
		target.setResult(list);
		target.setSize(size);

		return target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.business.OrderService#calculateServiceAmount(java.
	 * lang.Long)
	 */
	@Override
	public Double calculateServiceAmount(Long orderId) {

		return null;
	}

}
