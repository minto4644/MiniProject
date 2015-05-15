package com.cs593;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
	public static void main(String[] args) {
		List<Subscriber> subscribers = new ArrayList<>();
		for (int i = 1; i <= 10000; ++i) {
			String phNo = "98056" + Math.round(Math.random() * 10000);
			subscribers.add(new Subscriber(phNo, 100.0));
		}
		List<CallRecord> records = new ArrayList<>();
		for (int i = 1; i <= 10000; ++i) {
			String phNo1 = "98056" + Math.round(Math.random() * 10000);
			String phNo2 = "98056" + Math.round(Math.random() * 10000);
			records.add(new CallRecord(phNo1, phNo2, 1.0));
		}

		Collection<Callable<Boolean>> collections = new ArrayList<>();
		for (Subscriber i : subscribers)
			collections.add(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {
					try {
						i.Call(2.0);
					}
					catch (Exception e) {
						return false;
					}
					return true;
				}
			});
		ExecutorService pool = Executors.newFixedThreadPool(10);
		try {
			List<Future<Boolean>> futures = pool.invokeAll(collections);
			for (Future<Boolean> future : futures)
				future.get();
		}
		catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		pool.shutdown();
		for (Subscriber i : subscribers)
			System.out.println(i.getBalance());
	}
}