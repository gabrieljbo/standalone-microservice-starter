package dev.gabrieljbo.project.adapters.in.web.registercustomer;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.gabrieljbo.project.domain.model.Customer;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoundedMapper {

	Customer requestPayloadToCustomer(RequestPayload requestPayload);

	ResponsePayload customerToResponsePayload(Customer customer);

}