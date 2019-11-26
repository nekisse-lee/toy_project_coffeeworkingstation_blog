package com.nekisse.coffeeworkstation.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.nekisse.coffeeworkstation.domain.InstaDomain;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class InstagramUtils {

    private static final String USER_INSTAGRAM_URL = "https://www.instagram.com/jami__anwa/";
    public static final int SET_IMG_COUNT = 4;

    public static List<InstaDomain> getInstaImgAndDesc() throws IOException {
        Document doc2 = Jsoup.connect(USER_INSTAGRAM_URL).get();
        Element script = doc2.body().getElementsByTag("script").first();
        System.out.println("script = " + script);
//        System.out.println("script.data() = " + script.data());
        String substring = script.data().substring(21);

        JsonReader reader = new JsonReader(new StringReader(substring));
        System.out.println("substring = " + substring);
//        System.out.println("reader = " + reader.toString());
//        reader.setLenient(true);
//        System.out.println("reader = " + reader);

//        JsonParser jsonParser = new JsonParser();
//        JsonObject parse = (JsonObject) jsonParser.parse(reader);
//        System.out.println("parse = " + parse);

//        JsonElement entry_data = parse.get("entry_data");
//        System.out.println("entry_data = " + entry_data);


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(substring);


        System.out.println("jsonNode = " + jsonNode);
        JsonNode timelineMedia = jsonNode.findValue("edge_owner_to_timeline_media");
        System.out.println("edge_owner_to_timeline_media = " + timelineMedia);

        List<JsonNode> node = timelineMedia.findValues("node");
        System.out.println("node = " + node);
        List<InstaDomain> insDoLists = new ArrayList<>();
        for (int i = 0; i < SET_IMG_COUNT; i++) {
            JsonNode jsonNode1 = node.get(i);

            InstaDomain edge_media_to_caption = InstaDomain.builder()
                    .desc(String.valueOf(jsonNode1.get("edge_media_to_caption").findValue("text")))
                    .imgUrl(String.valueOf(jsonNode1.get("display_url")))
                    .build();

            insDoLists.add(edge_media_to_caption);
        }
        return insDoLists;
    }





}
