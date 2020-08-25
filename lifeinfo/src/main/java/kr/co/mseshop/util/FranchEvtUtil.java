package kr.co.mseshop.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import kr.co.mseshop.model.FranchEvtVO;

public class FranchEvtUtil {
	public int randomRange(int n1, int n2) {
		return (int) (Math.random() * (n2 - n1 + 1)) + n1;
	}

	public static <E> E getWeightedRandom(Map<E, Double> weights, Random random) {
		E result = null;
		double bestValue = Double.MAX_VALUE;

		for (E element : weights.keySet()) {
			double value = -Math.log(random.nextDouble()) / weights.get(element);
			if (value < bestValue) {
				bestValue = value;
				result = element;
			}
		}
		return result;
	}

	HashSet<String> setBox = new HashSet<String>();

	public void rstEvent(int start, Map<String, Double> w, Random rand) {
		for (int y = 0; y < start; y++) {
			// System.out.println("[Random Value]"+getWeightedRandom(w, rand));
			setBox.add(getWeightedRandom(w, rand));
		}
	}

	public List<String> rtnCvtIntValue(List<FranchEvtVO> franchList, int size, int start) {

		Map<String, Double> w = new HashMap<String, Double>();
		Random rand = new Random();

		int sum = 0;
		for (int i = 1; i <= size; i++) {
			sum += i;
		}

		ArrayList<Integer> arr = new ArrayList<Integer>();
		int result = 0;
		for (int j = 1; j <= size; j++) {
			arr.add(sum - j);
			result += sum - j;
		}

		for (int k = 0; k < franchList.size(); k++) {
			double b = (double) arr.get(k) / result;
			System.out.println("가중치%" + b);
			w.put(franchList.get(k).getUserID(), b);
		}

		System.out.println(getWeightedRandom(w, rand));
		System.out.println("[setBox Size]" + setBox.size());
		System.out.println("[start]" + start);
		System.out.println("[setBox Size]" + setBox.size() + "[start]" + start);

		boolean startEvt = true;
		while (startEvt) {
			try {
				Thread.sleep(1000);
				rstEvent(start, w, rand);
				if (setBox.size() == start) {
					System.out.println("[cnt same]");
					startEvt = false;
				}else {
					System.out.println("[cnt diff]");
					setBox = new HashSet<String>();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		System.out.println("[setBox Size]" + setBox.size() + "[start]" + start);

		Iterator<String> it = setBox.iterator();
		ArrayList<String> evtList = new ArrayList<String>();
		while (it.hasNext()) {
			// System.out.println("[value]:" + it.next());
			evtList.add(it.next());
		}

		return evtList;
	}

}
