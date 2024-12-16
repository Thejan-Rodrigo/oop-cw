package com.TicketingSystem.RealTime_Ticketing_System.repo;

import com.TicketingSystem.RealTime_Ticketing_System.entity.ConfigurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepo extends JpaRepository<ConfigurationEntity,Integer>{

}
