package kosta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kosta.model.ItemDao;
import kosta.model.Order;
import kosta.model.OrderDao;

@Service
public class OrderService {
	private OrderDao orderDao;
	private ItemDao itemDao;
	
	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,
			rollbackFor={Exception.class})
	public void orderAction(Order order) throws Exception{
		orderDao.addOrder(order); //주문처리
		
		//주문받은것의 번호를 찾아 그 것의 재고양을 체크
		if(itemDao.findItem(order.getNo()).getAmount() < order.getAmount()){ //재고수량 < 주문수량
			throw new Exception("재고부족");
		}
		
		itemDao.updateItem(order); //재고수정
	}
	

}
