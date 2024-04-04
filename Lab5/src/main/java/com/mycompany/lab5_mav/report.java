/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_mav;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rebec
 */
public class report {
    public static void report(Repository r){
         Configuration cfg = new Configuration();
                try {
                    cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\rebec\\OneDrive\\Desktop\\Advanced-Programming-\\Lab5_Maven\\repositories\\" + r.getName()));
                    Template template = cfg.getTemplate("report.ftl");

                    Map<String, Object> data = new HashMap<>();
                    data.put("title", r.getName());
                    data.put("content", r.ls());

                    Writer out = new OutputStreamWriter(System.out);
                    template.process(data, out);
                    out.flush();
                } catch (IOException | TemplateException e) {
                    e.printStackTrace();
                }
    }
}
