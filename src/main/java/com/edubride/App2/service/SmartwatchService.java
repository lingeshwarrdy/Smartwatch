package com.edubride.App2.service;



import java.util.List;

import com.edubride.App2.dao.SmartwatchDao;
import com.edubride.App2.model.Smartwatch;


public class SmartwatchService implements SmartwatchI {
    private SmartwatchDao dao;

    public SmartwatchService() {
        dao = new SmartwatchDao();
    }

    @Override
    public void addSmartwatch(Smartwatch smartwatch) {
        dao.addSmartwatch(smartwatch);
    }

    @Override
    public List<Smartwatch> getAllSmartwatches() {
        return dao.getAllSmartwatches();
    }

    @Override
    public Smartwatch getSmartwatchById(Integer id) {
        return dao.getSmartwatchById(id);
    }

    @Override
    public void updateSmartwatch(Smartwatch smartwatch) {
        dao.updateSmartwatch(smartwatch);
    }

    @Override
    public void deleteSmartwatch(Integer id) {
        dao.deleteSmartwatch(id);
    }

    @Override
    public void deleteAllSmartwatches() {
        dao.deleteAllSmartwatches();
    }
}

