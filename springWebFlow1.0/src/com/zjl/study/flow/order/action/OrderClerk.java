package com.zjl.study.flow.order.action;

import com.zjl.study.flow.order.domain.Purchase;

// TODO import @Transactional
public interface OrderClerk {
	void placeOrder(Purchase purchase);
}
