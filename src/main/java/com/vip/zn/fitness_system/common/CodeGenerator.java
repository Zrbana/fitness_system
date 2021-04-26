package com.vip.zn.fitness_system.common;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName CodeGenerator
 * @Description 控制台输入表名自动生成相应文件
 * @Author na.zhao
 * @Date 2021/4/15 16:08
 */


public class CodeGenerator {

    public static String scanner(String table) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + table + ":");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String result = scanner.next();
            if (StringUtils.isNotBlank(result)) {
                return result;
            }
        }
        throw new MybatisPlusException("请输入正确的表名!");
    }

    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = "F:\\JavaProject\\fitness_system";
        globalConfig.setOutputDir(projectPath + "\\src\\main\\java");
        globalConfig.setAuthor("na.zhao");
        globalConfig.setOpen(true);
        globalConfig.setFileOverride(true);
        globalConfig.setDateType(DateType.TIME_PACK);
        globalConfig.setIdType(IdType.AUTO);
        autoGenerator.setGlobalConfig(globalConfig);
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/fitness_system?serverTimezone=GMT%2B8");
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        autoGenerator.setDataSource(dataSourceConfig);
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(scanner("模块名"));
        packageConfig.setParent("com.vip.zn.fitness_system");
        autoGenerator.setPackageInfo(packageConfig);
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                //to do nothing
            }
        };
        String templatePath = "/templates/mapper.xml.ftl";
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        fileOutConfigList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        autoGenerator.setCfg(injectionConfig);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setTablePrefix(packageConfig.getModuleName() + "_");
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }


}











