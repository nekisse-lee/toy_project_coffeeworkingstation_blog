package com.nekisse.coffeeworkstation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.nekisse.coffeeworkstation.domain.InstaDomain;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestMain {
    private static String getCurrentData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        return sdf.format(new Date());
    }

    public static void main(String[] args) throws IOException {

        // 1. 가져오기전 시간 찍기

        System.out.println(" Start Date : " + getCurrentData());


        // 2. 가져올 HTTP 주소 세팅

        HttpPost http = new HttpPost("https://www.instagram.com/p/B5MJcTqnL82/");
//        HttpPost http = new HttpPost("http://co-duck.com/");


        // 3. 가져오기를 실행할 클라이언트 객체 생성

        HttpClient httpClient = HttpClientBuilder.create().build();


        // 4. 실행 및 실행 데이터를 Response 객체에 담음

        HttpResponse response = httpClient.execute(http);


        // 5. Response 받은 데이터 중, DOM 데이터를 가져와 Entity에 담음

        HttpEntity entity = response.getEntity();


        // 6. Charset을 알아내기 위해 DOM의 컨텐트 타입을 가져와 담고 Charset을 가져옴

        ContentType contentType = ContentType.getOrDefault(entity);
//        System.out.println("contentType = " + contentType);
        Charset charset = contentType.getCharset();


        // 7. DOM 데이터를 한 줄씩 읽기 위해 Reader에 담음 (InputStream / Buffered 중 선택은 개인취향)

        BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));


        // 8. 가져온 DOM 데이터를 담기위한 그릇

        StringBuffer sb = new StringBuffer();


        // 9. DOM 데이터 가져오기

        String line = "";

        while ((line = br.readLine()) != null) {

            sb.append(line + "\n");

        }


        // 10. 가져온 아름다운 DOM을 보자
        System.out.println("sb.toString = \n" + sb.toString());
//        System.out.println("========================");


        // 11. Jsoup으로 파싱해보자.

//        Document doc = Jsoup.parse(sb.toString(),"https://www.instagram.com/jami__anwa/");
//        System.out.println("doc = " + doc);
//        System.out.println("========================");


        // 참고 - Jsoup에서 제공하는 Connect 처리
//        List<InstaDomain> insDoLists = getInstaDomains();

//        System.out.println("insDoLists = " + insDoLists);
//        System.out.println("insDoLists.size() = " + insDoLists.size());



        // 12. 얼마나 걸렸나 찍어보자

        System.out.println(" End Date : " + getCurrentData());

    }


}

