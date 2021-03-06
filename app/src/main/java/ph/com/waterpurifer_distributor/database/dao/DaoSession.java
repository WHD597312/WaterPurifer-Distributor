package ph.com.waterpurifer_distributor.database.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import ph.com.waterpurifer_distributor.pojo.Equipment;

import ph.com.waterpurifer_distributor.database.dao.EquipmentDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig equipmentDaoConfig;

    private final EquipmentDao equipmentDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        equipmentDaoConfig = daoConfigMap.get(EquipmentDao.class).clone();
        equipmentDaoConfig.initIdentityScope(type);

        equipmentDao = new EquipmentDao(equipmentDaoConfig, this);

        registerDao(Equipment.class, equipmentDao);
    }
    
    public void clear() {
        equipmentDaoConfig.clearIdentityScope();
    }

    public EquipmentDao getEquipmentDao() {
        return equipmentDao;
    }

}
