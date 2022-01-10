import com.util.ShutdownHookServerThread;
import org.junit.Assert;
import org.junit.Test;

public class ShutdownThreadTest {

    @Test
    public void testShutdown() {
        ShutdownTest shutdownTest = new ShutdownTest();
        Assert.assertNotNull(shutdownTest);

        shutdownTest.startup();
        shutdownTest.shutdown();
    }

   static class ShutdownTest {
        private void startup(){
            Runtime.getRuntime().addShutdownHook(new ShutdownHookServerThread<>(this, v -> {
                System.out.println("server is shut down...");
                return v;
            }));
        }

        private void shutdown(){
            System.exit(0);
        }
    }
}
