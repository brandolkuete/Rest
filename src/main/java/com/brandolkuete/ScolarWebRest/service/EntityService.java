package com.brandolkuete.ScolarWebRest.service;

import java.util.List;

public interface EntityService<DT0,ID> {
    DT0 save(DT0 entityDTO);
    DT0 update(DT0 entityDTO);
    List<DT0> findAll();
    void delete(DT0 entityDTO);

}
