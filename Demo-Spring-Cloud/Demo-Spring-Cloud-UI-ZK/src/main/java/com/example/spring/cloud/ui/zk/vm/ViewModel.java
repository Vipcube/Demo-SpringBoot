package com.example.spring.cloud.ui.zk.vm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

/**
 * The simple view model.
 *
 * @author Brad Chen
 *
 */
public class ViewModel {
	private int count;

	@Init
	public void init(){
		this.count = 100;
	}

	@Command
	@NotifyChange("count")
	public void cmd() {
		++count;
	}

	public int getCount() {
		return count;
	}
}
