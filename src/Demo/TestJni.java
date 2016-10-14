package Demo;

/**
 * Created by andilyliao on 16-8-11.
 */
// javah -jni org.jni.TestJni
// gcc org_jni_testjni.c -fPIC -shared -o testjni.so
public class TestJni {
    public native void xxx();
    public static void main(String[] args) {
        System.load("/opt/path/testjni.so");
        TestJni testJni=new TestJni();
        testJni.xxx();
    }
}
