package com.edubride.App2.service;

import java.util.List;

import com.edubride.App2.model.Smartwatch;


public interface SmartwatchI {
    void addSmartwatch(Smartwatch smartwatch);
    List<Smartwatch> getAllSmartwatches();
    Smartwatch getSmartwatchById(Integer id);
    void updateSmartwatch(Smartwatch smartwatch);
    void deleteSmartwatch(Integer id);
    void deleteAllSmartwatches();
}
