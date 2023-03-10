package techproed.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ListenersRetry implements IRetryAnalyzer {

    /*
2. Test sinifi olustur : ListenersTest3.  Listeners Retry i iliskilendir : @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
3. Sonuc : Eger herhangi bir test case FAIL olursa, bu test case 3 kez data run edilecektir.
     */
    private int retryCount = 0;
    private static final int maxRetryCount = 1;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }



}
