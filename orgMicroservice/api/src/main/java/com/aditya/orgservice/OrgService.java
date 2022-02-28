package com.aditya.orgservice;

import com.aditya.org_entities.OrgValue;

import java.util.List;

public interface OrgService {

    OrgValue saveOrg(OrgValue orgValue);
    List<OrgValue> getAllOrg();
    OrgValue updateOrg(OrgValue orgValue, long id);
    void deleteOrg(long id);


}
