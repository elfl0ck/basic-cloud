package com.cars.network.cloud;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BootstrapApplicationTest {

    @Test
    public void contextLoad() throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getResource("/demo.log").toURI());
        List<String> list = Files.readAllLines(path);
        for(String line : list) {
            JsonObject jsonObject = (JsonObject) new JsonParser().parse(line);
            log.info("line is: -> {}, demo is: {}", line, jsonObject.get("demo"));
        }
    }

}
