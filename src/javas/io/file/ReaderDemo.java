package javas.io.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReaderDemo {

    public static void main(String[] args) {
        String s = readText();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = gson.fromJson(s, JsonObject.class);
        System.out.println(gson.toJson(jsonObject));
    }

    public static String readText() {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/javas/io/case/demo.txt"))) {
            String text;
            while ((text = reader.readLine()) != null) {
                builder.append(text);
            }
        } catch (IOException e) {
            return null;
        }
        return builder.toString();
    }

}
