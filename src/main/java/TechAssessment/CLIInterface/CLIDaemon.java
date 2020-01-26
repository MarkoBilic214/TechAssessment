package TechAssessment.CLIInterface;

import TechAssessment.CLIInterface.views.BaseView;

public class CLIDaemon implements Runnable{
	
	public BaseView first;
	public CLIDaemon(BaseView initialView) {
		this.first = initialView;
	}
	
	public void run() {
		while(true) {
			this.first.startInteraction();
			this.first = this.first.nextView;
			if(this.first==null) {
				break;
			}
		}
		
	}

}
