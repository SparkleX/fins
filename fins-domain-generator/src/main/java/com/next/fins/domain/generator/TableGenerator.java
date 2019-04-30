package com.next.fins.domain.generator;


import java.io.File;
import java.util.Collection;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.sap.b1.wcli.core.data.xml.schema.tables.Key;
import com.sap.b1.wcli.core.data.xml.schema.tables.Table;
import com.sap.b1.wcli.core.data.xml.util.TableUtil;

import freemarker.template.Template;

@SpringBootApplication
@Component
public class TableGenerator
{
	static Logger logger = LoggerFactory.getLogger(TableGenerator.class);
	public static void main(String[] args) throws Exception 
	{
		ApplicationContext appContext = SpringApplication.run(TableGenerator.class, args);
		TableGenerator instance = appContext.getBean(TableGenerator.class);
		instance.execute();
	}
	
	@Value("${input}")
	String input;

	@Value("${output}")
	String output;

	private Template template;
	Unmarshaller jaxbUnmarshaller;
	
	void execute() throws Exception
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);
		jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		this.template = FreeMarkerUtil.loadTemplate("classpath:template/table.ftl");
		logger.info("Output folder : {}", output);
		Collection<File> files = FileUtils.listFiles(new File(input), FileFilterUtils.suffixFileFilter(".xml"), FileFilterUtils.trueFileFilter());
		for(File file:files)
		{
			logger.info(file.getName());
			createJavaFile(file);
		}
	}

	private void createJavaFile(File file) throws Exception 
	{		
		Table table = (Table) jaxbUnmarshaller.unmarshal(file);

		HashMap<String,Object> data = new HashMap<>();
		data.put("data", table);
		String baseName = FilenameUtils.getBaseName(file.getName());
		File outputFile = new File(output+"/com/next/fins/domain/entity/Bmo"+baseName + ".java");
		FreeMarkerUtil.process(template, data, outputFile);
	}
}
