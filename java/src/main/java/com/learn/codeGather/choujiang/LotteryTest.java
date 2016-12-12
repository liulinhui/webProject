package com.learn.codeGather.choujiang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 不同概率抽奖
 *
 * @author ShunLi
 */
public class LotteryTest {
	public static void main(String[] args) {
		List<Gift> gifts = new ArrayList<Gift>();
		// 序号==物品Id==物品名称==概率
		gifts.add(new Gift("C券", 0.0024d));
		gifts.add(new Gift("100元", 0.0072d));
		gifts.add(new Gift("50元", 0.16d));
		gifts.add(new Gift("100M", 0.8304d));
		List<Double> orignalRates = new ArrayList<Double>(gifts.size());
		for (Gift gift : gifts) {
			double probability = gift.getProbability();
			if (probability < 0) {
				probability = 0;
			}
			orignalRates.add(probability);
		}

		// statistics
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		double num = 1250;
		for (int i = 0; i < num; i++) {
			int orignalIndex = LotteryUtil.lottery(orignalRates);

			Integer value = count.get(orignalIndex);
			count.put(orignalIndex, value == null ? 1 : value + 1);
		}

		for (Entry<Integer, Integer> entry : count.entrySet()) {
			System.out.println(gifts.get(entry.getKey()) + ", count="
					+ entry.getValue() + ", probability=" + entry.getValue()
					/ num);
		}
	}

}