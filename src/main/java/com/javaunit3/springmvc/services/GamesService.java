package com.javaunit3.springmvc.services;

import com.javaunit3.springmvc.model.SwitchGame;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GamesService {
    private SessionFactory sessionFactory;

    @Autowired
    public GamesService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<SwitchGame> listGames() {
        var session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<SwitchGame> games = session.createQuery("from SwitchGame").list();
        session.getTransaction().commit();

        return games;
    }

    public void addGame(SwitchGame game) {
        var session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(game);
        session.getTransaction().commit();
    }
}
