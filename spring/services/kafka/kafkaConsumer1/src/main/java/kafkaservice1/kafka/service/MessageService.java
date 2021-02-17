package kafkaservice1.kafka.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService implements UpdateMessageArray {
    List<String> list = new ArrayList<>(10);


    @Override
    public void updateArray(String message) {
        System.out.println(list);
        if (list.size() == 10) {
            list.clear();
        }
        System.out.println("In UpdateArray");
        String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());

        list.add(message + "\t" + timeStamp);
    }

    public List<String> getList() {
        return list;
    }
}
