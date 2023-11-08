package ex05;

import java.lang.Thread.State;

public class MainThreadEx {

	public static void main(String[] args) {
		Thread th = Thread.currentThread();
		long id = th.getId();
		System.out.println("id:" + id);
		String name = th.getName();
		System.out.println("name:" + name);
		int priority = th.getPriority();
		System.out.println("priority:" + priority);
		State state = th.getState();
		System.out.println("State:" + state);

	}

}
