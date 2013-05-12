package com.unexpected.ant;

import com.unexpected.ant.model.Dynamic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * WE LOVE GOLDSCHMIDT
 */
public class Timer implements Serializable {
	private Set<Dynamic> dynamicItems = new HashSet<>();
	private volatile boolean stopped = true;
	private long tick = 0;

	/**
	 * Adds a dynamic item for schedule
	 *
	 * @param dynamic An item to be scheduled
	 */
	public void add(Dynamic dynamic) {
		dynamicItems.add(dynamic);
	}

	/**
	 * Starts scheduling infinitely, until stop() is called. Stop should be called in a different thread.
	 */
	public void start() {
		stopped = false;
		while (!stopped) {
			schedule();
			try {
				Thread.sleep(100);
			} catch (InterruptedException ignored) {
			}
		}
	}

	/**
	 * Schedules all the contained items for one step.
	 */
	public void schedule() {
		tick++;
		for (Dynamic item : new ArrayList<>(dynamicItems)) {
			item.action(tick);
		}
	}

	/**
	 * Stops scheduling.
	 */
	public void stop() {
		stopped = true;
	}

	public long getTick() {
		return tick;
	}

	public void clear() {
		dynamicItems.clear();
	}
}
