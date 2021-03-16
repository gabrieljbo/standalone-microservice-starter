package dev.gabrieljbo.project.adapters.in.web.getallcustomers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.gabrieljbo.project.domain.model.Customer;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoundedMapper {
    
    //List<ResponsePayload> customerToResourceEntity(List<Customer> customerList);

}