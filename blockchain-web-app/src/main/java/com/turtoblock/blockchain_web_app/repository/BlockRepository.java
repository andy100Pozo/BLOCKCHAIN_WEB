package com.turtoblock.blockchain_web_app.repository;

import com.turtoblock.blockchain_web_app.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
