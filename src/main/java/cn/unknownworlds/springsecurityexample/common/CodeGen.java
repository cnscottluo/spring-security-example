package cn.unknownworlds.springsecurityexample.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;
import java.util.Map;

public class CodeGen {


    public static void main(String[] args) {

        AutoGenerator autoGenerator = new AutoGenerator();


        /*
        全局配置
         */
        GlobalConfig globalConfig = new GlobalConfig();
        // String projectPath = System.getProperty("user.dir");
         String projectPath = "D:\\code";
        //String projectPath = "/Volumes/Samsung_T5/work/yngishere/yngishere-admin/yngishere-admin-server";
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor("scottluo");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(false);
        globalConfig.setEnableCache(false);
        globalConfig.setActiveRecord(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setEntityName("%sModel");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        globalConfig.setIdType(IdType.AUTO);
        //globalConfig.setSwagger2(true);
        autoGenerator.setGlobalConfig(globalConfig);


        InjectionConfig injectionConfig = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig()
                                   .getGlobalConfig()
                                   .getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        autoGenerator.setCfg(injectionConfig);


        /*
        数据源配置
         */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(
                "jdbc:mysql://localhost:3306/example?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        // dataSourceConfig.setSchemaName("public");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        autoGenerator.setDataSource(dataSourceConfig);


        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("cn.unknownworlds.springsecurityexample");
        packageConfig.setEntity("entity");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setXml("mapper");
        packageConfig.setController("controller");
        autoGenerator.setPackageInfo(packageConfig);


        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategyConfig.setTablePrefix("sys");
//        strategyConfig.setFieldPrefix();
//        strategyConfig.setSuperEntityClass();
//        strategyConfig.setSuperEntityColumns();
//        strategyConfig.setSuperMapperClass();
//        strategyConfig.setSuperServiceClass();
//        strategyConfig.setSuperServiceImplClass();
//        strategyConfig.setSuperControllerClass();
//         strategyConfig.setInclude("permission", "role", "role_permission", "user", "user_role");
//        strategyConfig.setInclude("employee_example");
//        strategyConfig.setExclude();
        strategyConfig.setEntityColumnConstant(true);
        strategyConfig.setEntityBuilderModel(true);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
//        strategyConfig.setVersionFieldName("version");
//        strategyConfig.setLogicDeleteFieldName("");

        autoGenerator.setStrategy(strategyConfig);


        autoGenerator.execute();
    }
}
