package com.rmkshr.javanewfeatures.java13;

public class TextBlocks {

    public static void main(String[] args) {

        //Usual practice
        String JSON_STRING
                = "{\r\n" + "\"name\" : \"Baeldung\",\r\n" + "\"website\" : \"https://www.%s.com/\"\r\n" + "}";


        //Using TEXT_BLOCK
        String TEXT_BLOCK_JSON = """
                {
                    "name" : "Baeldung",
                    "website" : "https://www.%s.com/"
                }
                """;
    }
}
