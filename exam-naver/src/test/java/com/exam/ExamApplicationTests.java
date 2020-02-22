package com.exam;

import com.exam.naver.three.OwnQueue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExamApplicationTests {

    @Test
    void contextLoads() {
        OwnQueue ownQueue = new OwnQueue(3);
        ownQueue.push(1);

    }

}
