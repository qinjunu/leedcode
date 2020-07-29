package collection;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerDemo {
    private static Exchanger<String> exchanger = new Exchanger();

    public static void main(String[] args) {

        //浠ｈ〃鐢风敓鍜屽コ鐢�
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(() -> {
            try {
                //鐢风敓瀵瑰コ鐢熻鐨勮瘽
                String girl = exchanger.exchange("鎴戝叾瀹炴殫鎭嬩綘寰堜箙浜�......");
                System.out.println("濂崇敓璇达細" + girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.execute(() -> {
            try {
                System.out.println("濂崇敓鎱㈡參鐨勪粠鏁欏閲岃蛋鍑烘潵......");
                TimeUnit.SECONDS.sleep(3);
                //鐢风敓瀵瑰コ鐢熻鐨勮瘽
                String boy = exchanger.exchange("鎴戝緢鍠滄浣�......");
                System.out.println("鐢风敓璇达細" + boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
