package ch02.observer.observers;

import ch02.observer.logevent.LogEvent;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileLogObserver implements LogObserver {

    @Override
    public void onLogEvent(LogEvent event) {
        // TODO: 하드코딩된 경로 수정
        String logPath = "/Users/yerim_shin/Developer/digging-deep-design-patterns/yelm-212/src/main/java/ch02/observer/observers/logs/log.txt";
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(logPath, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            fos.write(event.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

