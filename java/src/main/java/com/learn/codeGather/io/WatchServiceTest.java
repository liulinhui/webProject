package com.learn.codeGather.io;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by linkage on 2016-12-29.
 */
public class WatchServiceTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Paths.get("e:/").register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.OVERFLOW);
        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent event : key.pollEvents()) {
                System.out.println(event.context() + "文件发生变化了，" + event.kind() + "事件");
            }
            boolean valid = key.reset();
            if (!valid)
                break;
        }
    }
}
