package com.emlakcepteloggerservice.repository;

import com.emlakcepteloggerservice.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Integer> {

}
