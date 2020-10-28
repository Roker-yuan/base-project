package com.roker.template.common.tools;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Roker
 * @Date 2020/10/27 15:48
 * @Title CodeGenerator
 * @Description 代码生成器
 */
@Data
public class CodeGenerator {

    /**
     * 数据库链接地址
     */
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/base_project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    /**
     * 驱动
     */
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * 用户名
     */
    private static final String USERNAME = "root";

    /**
     * 密码
     */
    private static final String PASSWORD = "000000";

    /**
     * 作者
     */
    private static final String AUTHOR = "roker";

    /**
     * 父包名
     */
    private static final String PACKAGE_PARENT = "com.roker.template.codeGeneratorDir";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 全局配置
     * @return GlobalConfig
     */
    private static GlobalConfig getGlobalConfig(){
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(System.getProperty("user.name"));
        gc.setOpen(false);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        gc.setFileOverride(true);
        return gc;
    }

    /**
     * 数据源配置
     * @return DataSourceConfig
     */
    private static DataSourceConfig getDataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        return dsc;
    }

    /**
     * 包名配置
     * @return  PackageConfig
     */
    private static PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent(PACKAGE_PARENT);
        return pc;
    }

    private static InjectionConfig getInjectionConfig(){
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return System.getProperty("user.dir") + "/src/main/resources/mapper/"  + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
/*      cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        return cfg;
    }

    /**
     * 模板引擎配置
     *
     * @return 返回 TemplateConfig
     */
    private static TemplateConfig getTemplateConfig() {
      TemplateConfig templateConfig = new TemplateConfig();
      // 配置自定义输出模板
      //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
      // templateConfig.setEntity("templates/entity2.java");
      // templateConfig.setService();
      // templateConfig.setController();
      templateConfig.setXml(null);
      return templateConfig;
    }

    /**
     * 策略配置
     *
     * strategy.setInclude(tableNames) 传入需要 "生成" 的表名
     * strategy.setExclude(tableNames) 传入需要 "过滤" 的表名
     * strategy.setSuperEntityColumns("id");
     * @return 返回 getStrategyConfig
     */
    private static StrategyConfig getStrategyConfig() {
      StrategyConfig strategy = new StrategyConfig();
      strategy.setNaming(NamingStrategy.underline_to_camel);
      strategy.setColumnNaming(NamingStrategy.underline_to_camel);
      strategy.setEntityLombokModel(true);
      strategy.setRestControllerStyle(true);
      strategy.setControllerMappingHyphenStyle(true);
      strategy.setTablePrefix("_");
//      strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
      // 公共父类
//      strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
      // 写于父类中的公共字段
//      strategy.setSuperEntityColumns("id");
      strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
      strategy.setControllerMappingHyphenStyle(true);
      return strategy;
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        mpg.setGlobalConfig(getGlobalConfig());

        // 数据源配置
        mpg.setDataSource(getDataSourceConfig());

        // 包配置
        mpg.setPackageInfo(getPackageConfig());

        // 自定义配置
        mpg.setCfg(getInjectionConfig());

        // 配置模板
        mpg.setTemplate(getTemplateConfig());

        // 策略配置
        mpg.setStrategy(getStrategyConfig());
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
