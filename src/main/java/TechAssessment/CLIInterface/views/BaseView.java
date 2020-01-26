package TechAssessment.CLIInterface.views;
import java.util.HashMap;
import java.util.Scanner;

public class BaseView {

	static Scanner scanner = new Scanner(System.in);
	static HashMap<String,Object> NextViewInfo = new HashMap<String,Object>();
	public BaseView nextView;
	
	public BaseView() {
	}
	
	public BaseView(HashMap<String,Object>nextInfo) {
		this.NextViewInfo = nextInfo;
	}
	
	public void startInteraction() {
		
	}
	
	public void startNextView() {
		this.nextView.startInteraction();
	}
	
	public void setNextView(BaseView view) {
		this.nextView = view;
	}
	
	public void setNextInfo(HashMap<String,Object> next) {
		this.NextViewInfo = next;
	}
	public void closeScanner() {
		this.scanner.close();
	}
}
