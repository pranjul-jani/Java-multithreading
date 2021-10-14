import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentApiCall {

    private static void call(String s, Map<String, String> map) {
        map.put(s,Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        List<String> urls = Arrays.asList("u1", "u2", "u3", "u4");

        List<Runnable> runnableList = new ArrayList<>();

        urls.forEach(url -> {
            Runnable runnable = () -> call(url,map);
            runnableList.add(runnable);
        });

        CompletableFuture<?>[] completableFutures = runnableList.stream()
                .map(CompletableFuture::runAsync)
                .toArray(CompletableFuture[]::new);

        // if the purpose of adding join is that
        // unless this task is completed the task below it won't be executed
        CompletableFuture.allOf(completableFutures).join();
        System.out.println(map);
    }
}
