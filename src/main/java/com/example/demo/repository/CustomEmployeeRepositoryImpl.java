package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.demo.model.CountResult;
import com.example.demo.model.Employee;
import com.mongodb.client.result.UpdateResult;

@Component
public class CustomEmployeeRepositoryImpl implements UpdateEmployeeRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	public void updatePhoneNumber(String firstName, String phoneNumber) {
		Query query = new Query(Criteria.where("firstName").is(firstName));
		Update update = new Update();
		update.set("phoneNumber", phoneNumber);

		UpdateResult result = mongoTemplate.updateFirst(query, update, Employee.class);

		if (result == null)
			System.out.println("No documents updated");
		else
			System.out.println(result.getModifiedCount() + " document(s) updated..");

	}
	
	public Integer getEmployeesCountByFirstName(String firstName) {
		Aggregation agg = Aggregation.newAggregation(
	            Aggregation.match(Criteria.where("firstName").is(firstName)),
	            Aggregation.group().count().as("count"));
	    AggregationResults<CountResult> result = 
                mongoTemplate.aggregate(
                        agg ,
                        "employee",
                        CountResult.class
                );
	    int count = result.getMappedResults().get(0).getCount();
	    return count;
	}

	
}
