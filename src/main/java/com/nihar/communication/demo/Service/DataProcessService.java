package com.nihar.communication.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class DataProcessService {

    private final String REMOVE_HTML_REGEX = "\\<.*?>";

    public String reomveHTMLFromBody(String body) {
        return body.replaceAll(REMOVE_HTML_REGEX,"");

    }

}
