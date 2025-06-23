package com.turtoblock.blockchain_web_app.repository;

import com.turtoblock.blockchain_web_app.model.Miner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinerRepository extends JpaRepository<Miner, Long> {
}
