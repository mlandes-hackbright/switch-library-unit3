package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.SwitchGame;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
    @Bean
    public SessionFactory getHibernateSessionFactory() {
        var sessionFactory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SwitchGame.class)
                .buildSessionFactory();

        return sessionFactory;
    }
}
