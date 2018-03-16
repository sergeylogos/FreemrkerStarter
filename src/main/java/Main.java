import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(Main.class, "/");
        configuration.setDefaultEncoding("UTF-8");


        Map<String, Object> input = new HashMap<String, Object>();
        input.put("title", "freemarkrer example");
        input.put("exmapleObject", new Developer("serj", "me"));
        List<Developer> systems = new ArrayList<Developer>();
        systems.add(new Developer("Android", "Google"));
        systems.add(new Developer("iOS States", "Apple"));
        systems.add(new Developer("Ubuntu", "Canonical"));
        systems.add(new Developer("Windows7", "Microsoft"));

        Template template = configuration.getTemplate("helloworld.ftl");

        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input,consoleWriter);

        Writer fileWriter = new FileWriter(new File("output.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }



    }

}
