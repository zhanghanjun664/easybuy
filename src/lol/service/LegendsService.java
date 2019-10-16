package lol.service;

import lol.bean.Legends;

import java.util.List;

public interface LegendsService {

//    查所有英雄
    public List<Legends> getLegends();
//    分页查英雄
    public List<Legends> getLegends(int pageNo, int pageSize);
//    查询英雄数量
    public long getLegendsCount();


//    public List getLegendsFields();
//    删除英雄
    public int deleteLegendById(String id);
//增加英雄
    public int addLegends(String name, String ages, String catalog_id, String sex);
//修改英雄
    public int updateLegendsById(String id, String name, String ages, String catalog_id, String sex);
//    根据id查英雄
    public <T> T getLegends(String id);
}
