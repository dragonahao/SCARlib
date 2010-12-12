package com.js.interpreter.plugins;

import com.js.interpreter.ast.PascalPlugin;
import com.js.interpreter.gui.IDE;

public class SCAR_ScriptControl implements PascalPlugin {
	IDE ide;

	public SCAR_ScriptControl(IDE i) {
		this.ide = i;
	}

	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.err.println("??? Interrupted.");
			e.printStackTrace();
		}
	}

	public static void wait(int ms) {
		sleep(ms);
	}

	public void terminatescript() {
		ide.stopProgram();
	}

}
