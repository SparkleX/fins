package com.next.fins.domain.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.util.ResourceUtils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateModel;
import freemarker.template.Version;

public class FreeMarkerUtil 
{
	static String readResource(String url) throws FileNotFoundException, IOException
	{
		try (InputStream is = ResourceUtils.getURL(url).openStream()) 
		{
			String content = IOUtils.toString(is, StandardCharsets.UTF_8);
			return content;
		}
	}
	
	
	static public Template loadTemplate(String templateFile) throws Exception 
	{
		String content = readResource(templateFile);

		Configuration cfg = new Configuration(new Version(2, 3, 20));
		StringTemplateLoader dummyLoader = new StringTemplateLoader();
		dummyLoader.putTemplate("template", content);
		cfg.setTemplateLoader(dummyLoader);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Template template = cfg.getTemplate("template");
		return template;
	}
	
	static public void process(Template template, HashMap<String,Object> data, File outputFile) throws TemplateException, IOException 
	{
		DefaultObjectWrapper wrapper = new DefaultObjectWrapper(new Version(2,3,20));
		TemplateModel statics = wrapper.getStaticModels();
		data.put("statics", statics);
		StringWriter sw = new StringWriter();
		template.process(data, sw);
		FileUtils.writeStringToFile(outputFile, sw.toString(), "utf8");
	}
}
