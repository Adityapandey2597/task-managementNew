package com.aditya.orgservice;

import org.springframework.stereotype.Service;
import com.aditya.org_entities.OrgValue;
import com.aditya.repository.OrgRepository;

import java.util.List;
@Service
public class OrgServiceImpl implements OrgService{

    private OrgRepository orgRepository;

    public OrgServiceImpl(OrgRepository orgRepository) {
        this.orgRepository = orgRepository;
    }


    @Override
    public OrgValue saveOrg(OrgValue orgValue) {
        return orgRepository.save(orgValue);
    }

    @Override
    public List<OrgValue> getAllOrg() {
        return orgRepository.findAll();
    }

    @Override
    public OrgValue updateOrg(OrgValue orgValue, long id) {
        OrgValue existingUser=orgRepository.findById(orgValue.getId()).orElse(null);
        existingUser.setAddress(orgValue.getAddress());
        existingUser.setCompanyName(orgValue.getCompanyName());

        orgRepository.save(existingUser);
        return existingUser;

    }

    @Override
    public void deleteOrg(long id) {
        orgRepository.findById(id).orElse(null);
        orgRepository.deleteById(id);


    }
}
