package com.TicketingSystem.RealTime_Ticketing_System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConfigurationEntity {
    @Id
    private int configId;
    private int numTickets;
    private int releaseRate;
    private int retrievalRate;
    private int ticketCapacity;
}
