package techproed.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersRetryAnalyzer implements IAnnotationTransformer {
    //tum fail test caseleri bir kez daha otomatik olarak run etmek.
    //bu sinif ListenersRetry sinifini xml de kullanabilmek icin oluturuldu.
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //bu sinif ListenersRetry util class'a baglidir.
        annotation.setRetryAnalyzer(ListenersRetry.class);
    }

}
