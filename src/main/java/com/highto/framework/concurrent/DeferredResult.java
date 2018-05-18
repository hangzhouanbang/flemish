package com.highto.framework.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Description:异步转同步处理 User: tan DateTime: 2016/8/19 13:44
 */
public class DeferredResult<T> {
	private final CountDownLatch latch = new CountDownLatch(1);

	private T result;

	/**
	 * 阻塞当前线程，直到setResult被调用
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public T getResult() throws InterruptedException {
		latch.await();
		return result;
	}

	public void setResult(T result) {
		this.result = result;
		latch.countDown();
	}

	public void setExceptionResult() {
		latch.countDown();
	}

}
