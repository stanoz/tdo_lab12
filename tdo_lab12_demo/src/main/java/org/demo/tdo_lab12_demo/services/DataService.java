package org.demo.tdo_lab12_demo.services;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class DataService {

    public String getApiData() {
        return "Java 21, up and running";
    }

    public String getJsonData() {
        return "Some data";
    }

}
