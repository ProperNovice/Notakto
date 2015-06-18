package gui;

import controller.Controller;
import instances.Instances;
import utils.Parent;

public class PanelGame extends Parent {

	public PanelGame(Panel panel) {
		Instances.setPanelGameInstance(this);
		new Controller();
	}

}
