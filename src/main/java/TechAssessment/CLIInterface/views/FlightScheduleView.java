package TechAssessment.CLIInterface.views;

import java.util.ArrayList;

import TechAssessment.model.FlightDetails;
import TechAssessment.model.OrderList;
import TechAssessment.util.FlightSchedular;
import TechAssessment.util.OrdersLoader;

public class FlightScheduleView extends BaseView {

	@Override
	public void startInteraction() {
		// TODO Auto-generated method stub
		super.startInteraction();
		if (!BaseView.NextViewInfo.containsKey("flights")) {
			System.out.println("Please go back and add flights before you can schedule them");
			this.setNextView(new InitialView());
		}
		else {
			System.out.println("Loading coding-assignment-orders.json");
			OrdersLoader loader = new OrdersLoader();
			loader.loadOrders();
			OrderList orders = loader.getOrders();
			System.out.println("Loaded Orders \n printing Flight Schedule");
			FlightSchedular sched = new FlightSchedular();
			sched.ScheduleOrders((ArrayList<FlightDetails>)this.NextViewInfo.get("flights"), orders.getOrders());
			this.nextView= new InitialView();
		}
	}

	
}
