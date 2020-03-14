/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package edu.eci.arsw.findeci.services;
import com.google.inject.Injector;
import com.google.inject.Guice;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
public class FindEciServicesFactory {
    private static FindEciServicesFactory instance = new FindEciServicesFactory();

    private static Injector injector;

    private static Injector testInjector;

    public FindEciServicesFactory(){

        injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
                
            }
        });

        testInjector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config-h2.xml");
                
            }
        });

    }

    public FindEciServices getHistoryService(){
        return injector.getInstance(FindEciServices.class);
    }

    public FindEciServices getHistoryServiceForTesting(){
        return testInjector.getInstance(FindEciServices.class);
    }

    public static FindEciServicesFactory getInstance(){
        return instance;
    }

}
**/