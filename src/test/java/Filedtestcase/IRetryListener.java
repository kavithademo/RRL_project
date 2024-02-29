package Filedtestcase;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class IRetryListener {
	public class Retry implements IRetryAnalyzer{

		int max_try=1;
		int count=0;
		@Override
		public boolean retry(ITestResult result) {
			// TODO Auto-generated method stub
			if(!result.isSuccess()) {
				if(count<max_try) {
					count++;
					return true;
				}
			}
			return false;
		}
		

	}
	

}
