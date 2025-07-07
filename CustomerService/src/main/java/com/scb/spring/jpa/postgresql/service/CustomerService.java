package com.scb.spring.jpa.postgresql.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scb.spring.jpa.dto.AddCreditScoreDTO;
import com.scb.spring.jpa.dto.CreateCustomerDTO;
import com.scb.spring.jpa.dto.CreateLoanDTO;
import com.scb.spring.jpa.dto.CustomerBankRelationshipResponseDTO;
import com.scb.spring.jpa.dto.CustomerCreditScoreResponseDTO;
import com.scb.spring.jpa.dto.CustomerDetailsResponseDTO;
import com.scb.spring.jpa.dto.CustomerLoanResponseDTO;
import com.scb.spring.jpa.dto.CustomerResponseDTO;
import com.scb.spring.jpa.dto.RecordPaymentDTO;
import com.scb.spring.jpa.dto.UpdateRelationshipDTO;
import com.scb.spring.jpa.helper.TypeConverter;
import com.scb.spring.jpa.postgresql.model.BankRelationship;
import com.scb.spring.jpa.postgresql.model.CreditScore;
import com.scb.spring.jpa.postgresql.model.Customer;
import com.scb.spring.jpa.postgresql.model.Loan;
import com.scb.spring.jpa.postgresql.model.PaymentHistory;
import com.scb.spring.jpa.postgresql.model.PaymentStatus;
import com.scb.spring.jpa.postgresql.repository.BankRelationshipRepository;
import com.scb.spring.jpa.postgresql.repository.CreditScoreRepository;
import com.scb.spring.jpa.postgresql.repository.CustomerRepository;
import com.scb.spring.jpa.postgresql.repository.LoanRepository;
import com.scb.spring.jpa.postgresql.repository.PaymentHistoryRepository;

import jakarta.persistence.EntityNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private CreditScoreRepository creditRepo;

	@Autowired
	private BankRelationshipRepository relRepo;

	@Autowired
	private LoanRepository loanRepo;

	@Autowired
	private PaymentHistoryRepository payRepo;

	/* ------------ Customers ------------ */
	public CustomerResponseDTO createCustomer(CreateCustomerDTO dto) {
		Customer c = new Customer();
		c.setFirstName(dto.firstName());
		c.setLastName(dto.lastName());
		c.setEmail(dto.email());
		Customer cust = customerRepo.save(c);
		 
		CustomerResponseDTO custdto = mapCustomerToCustomerResponseDTO(cust);

		 return custdto;
	}

	/* ------------ Credit Score ------------ */
	public CreditScore addCreditScore(Long customerId, AddCreditScoreDTO dto) {
		Customer c = fetchCustomer(customerId);
		CreditScore cs = new CreditScore();
		cs.setScore(dto.score());
		cs.setBureau(dto.bureau());
		cs.setCustomer(c);
		return creditRepo.save(cs);
	}

	/* ------------ Relationship ------------ */
	public BankRelationship updateRelationship(Long customerId, UpdateRelationshipDTO dto) {
		Customer c = fetchCustomer(customerId);

		BankRelationship rel = relRepo.findByCustomerId(customerId).orElseGet(() -> {
			BankRelationship r = new BankRelationship();
			r.setCustomer(c);
			return r;
		});

		rel.setLoyaltyTier(dto.loyaltyTier());
		rel.setProductsHeld(dto.productsHeld());
		return relRepo.save(rel);
	}

	/* ------------ Loan ------------ */
	public Loan createLoan(Long customerId, CreateLoanDTO dto) {
		Customer c = fetchCustomer(customerId);
		Loan loan = new Loan();
		loan.setCustomer(c);
		loan.setPrincipal(dto.principal());
		loan.setSecured(dto.secured());
		loan.setCollateral(dto.collateral());
		loan.setTenureMonths(dto.tenureMonths());
		loan.setStartDate(LocalDate.now());
		loan.setExpectedEndDate(LocalDate.now().plusMonths(dto.tenureMonths()));
		return loanRepo.save(loan);
	}

	/* ------------ Payments ------------ */
	public PaymentHistory recordPayment(Long loanId, RecordPaymentDTO dto) {
		Loan loan = loanRepo.findById(loanId).orElseThrow(() -> new IllegalArgumentException("Loan not found"));
		PaymentHistory pay = new PaymentHistory();
		pay.setLoan(loan);
		pay.setAmount(dto.amount());
		pay.setStatus(PaymentStatus.valueOf(dto.status()));
		return payRepo.save(pay);
	}

	private Customer fetchCustomer(Long id) {
		return customerRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
	}

	public CustomerResponseDTO getCustomer(Long id) {

		Customer cust = customerRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Customer not found for id = " + id));
		CustomerResponseDTO dto = mapCustomerToCustomerResponseDTO(cust);

		return dto;
	}

	public CustomerResponseDTO mapCustomerToCustomerResponseDTO(Customer c) {
		return new CustomerResponseDTO(c.getId(), c.getFirstName(), c.getLastName(), c.getEmail(), c.getJoinedOn());
	}

	public CustomerDetailsResponseDTO getCustomerDetails(Long id) {

		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Customer " + id + " not found"));

		CustomerLoanResponseDTO loanDto = loanRepo.findFirstByCustomerIdOrderByStartDateDesc(id)
				.map(l -> new CustomerLoanResponseDTO(l.getId(), l.getPrincipal(), l.getSecured(), l.getCollateral(),
						l.getTenureMonths(), l.getStartDate(), l.getExpectedEndDate()))
				.orElse(null);

		CustomerCreditScoreResponseDTO scoreDto = creditRepo.findFirstByCustomerIdOrderByEvaluatedOnDesc(id).map(
				s -> new CustomerCreditScoreResponseDTO(s.getId(), s.getScore(), s.getBureau(), s.getEvaluatedOn()))
				.orElse(null);

		CustomerBankRelationshipResponseDTO bankDto = relRepo.findByCustomerId(id).map(
				br -> new CustomerBankRelationshipResponseDTO(br.getId(), br.getLoyaltyTier(), br.getProductsHeld()))
				.orElse(null);

		return new CustomerDetailsResponseDTO(customer.getId(), customer.getFirstName(), customer.getLastName(),
				customer.getEmail(), customer.getJoinedOn(), loanDto, scoreDto, bankDto);
	}
}
