package com.matrix;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

//代码自动生成器
public class HSYCode {
    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();

        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//获取目录

        gc.setOutputDir(projectPath+"/src/main/java");//设置输出的目录
        gc.setOpen(false);//生成完毕后是否打开文件夹
        gc.setFileOverride(false);//是否覆盖
        gc.setServiceName("%sService");//去Service的I前缀
        gc.setIdType(IdType.AUTO);//设置默认主键类型
        gc.setDateType(DateType.ONLY_DATE);//设置默认时间类型为只显示时间
        gc.setSwagger2(true);//实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://121.196.98.183:3306/scanmannger?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("wea010lth320");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3、包的配置

        PackageConfig pc = new PackageConfig();
        pc.setParent("com.matrix");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("userinfo","usergate","gardgate","codeingardinfo","codeinfo");// 设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);//设置命名规则
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);// 自动lombok；
        strategy.setChainModel(true);//自动链式编程
        strategy.setVersionFieldName("version");// 乐观锁
        strategy.setLogicDeleteFieldName("deleted");//设置逻辑删除字段名字
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);

        //自动填充配置
        TableFill gmtCreate = new TableFill("inDateTime", FieldFill.INSERT);
        //TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        //tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);

        mpg.setStrategy(strategy);
        mpg.execute(); //执行
    }
}
