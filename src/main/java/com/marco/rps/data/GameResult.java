package com.marco.rps.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco.rotondi on 15/12/2016.
 */
public class GameResult {

	final List<Boolean> firstResult;
	final List<Boolean> secondResult;

	public GameResult() {
		this.firstResult = new ArrayList<>();
		this.secondResult = new ArrayList<>();
	}

	public void addFirstResult(final Boolean result) {
		this.firstResult.add(result);
	}

	public void addSecondResult(final Boolean result) {
		this.secondResult.add(result);
	}

	public List<Boolean> getFirstResult() {
		return firstResult;
	}

	public List<Boolean> getSecondResult() {
		return secondResult;
	}
}
