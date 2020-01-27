package TechAssessment.CLIInterface;

import TechAssessment.CLIInterface.views.BaseView;

public class CLIDaemon implements Runnable{
	
	public BaseView view;
	public CLIDaemon(BaseView initialView) {
		this.view = initialView;
	}
	
	public void run() {
		while(true) {
			this.view.startInteraction();
			this.view = this.view.nextView;
			if(this.view==null) {
				break;
			}
		}
		
	}

}
