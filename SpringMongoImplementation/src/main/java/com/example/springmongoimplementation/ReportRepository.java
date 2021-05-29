package com.example.springmongoimplementation;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "report", path = "report")
public interface ReportRepository extends MongoRepository<Report, Float> {


}