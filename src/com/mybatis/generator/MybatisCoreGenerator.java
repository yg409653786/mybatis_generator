package com.mybatis.generator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisCoreGenerator {
	public static void generator() {
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			// 解析
			ConfigurationParser cp = new ConfigurationParser(warnings);
			InputStream inputStream = Resources.getResourceAsStream("generatorConfig.xml");
			Configuration config = cp.parseConfiguration(inputStream);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		MybatisCoreGenerator.generator();
		System.out.println("done!");
	}

}