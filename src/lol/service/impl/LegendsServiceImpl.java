package lol.service.impl;

import lol.bean.Legends;
import lol.dao.LegendsDao;
import lol.dao.impl.LegendsDaoImpl;
import lol.service.LegendsService;

import java.util.List;

public class LegendsServiceImpl implements LegendsService {
    LegendsDao legendsDao = new LegendsDaoImpl();

    @Override
    public List<Legends> getLegends() {

        return legendsDao.getLegends();
    }

    @Override
    public List<Legends> getLegends(int pageNo, int pageSize) {
        return legendsDao.getLegends(pageNo, pageSize);
    }

    @Override
    public long getLegendsCount() {
        return legendsDao.getLegendsCount();
    }

    @Override
    public int deleteLegendById(String id) {

        return legendsDao.deleteLegendById(id);
    }

    @Override
    public int addLegends(String name, String ages, String catalog_id, String sex) {
        return legendsDao.addLegends(name, ages, catalog_id, sex);
    }

    @Override
    public int updateLegendsById(String id, String name, String ages, String catalog_id, String sex) {
        return legendsDao.updateLegendsById(id, name, ages, catalog_id, sex);
    }

    @Override
    public <T> T getLegends(String id) {
        return legendsDao.getLegends(id);
    }

}
