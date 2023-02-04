package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {

    //1. Utilities de Listeners class olustur.
    //2. Implement ITestListeners interface. Bu TestBase class gibidir.
    //3. ITestListeners metotlarını ekle.
    //*******************************************
    //4. tests package da, yeni bir package olustur : listeners
    //5. listeners package da yeni bir class olustur : ListenersTest
    //********************************************
    //NOT : Test Classlari ile Listenerlari iliskilendirmenin 2 yolu vardır
    //1. @Listeners annotation : @Listeners(techproed.utilities.Listeners.class)
    //2. Xml file : listeners taginin xml file da kullan
    //<listeners>
    //    <listener class-name="techproed.utilities.Listeners"></listener>
    //</listeners>


    @Override
    public void onStart(ITestContext context){
        System.out.println("Tum testlerden once bir kere cagrilir : "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Tum testlerden sonra bir kere cagrilir : "+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart-Her bir @Testden once tek bir kez cagrilir : "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess-Sadece PASS olan testerden SONRA tek bir kez cagrilir : "+result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("onTestFailure-Sadece FAIL olan testlerden SONRA tek bir kez cagrilir : "+result.getName());
        try {
            ReusableMethods.getScreenshot("Test-Case-Fail :"+result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped-Sadece SKIP(atlanan) testlerden SONRA tek bir kez cagrilir : "+result.getName());
    }



}
