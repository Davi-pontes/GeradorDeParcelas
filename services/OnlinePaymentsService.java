package services;

public interface OnlinePaymentsService {
	
	double paymentFee(double amount);
	double interest(double amount, int months);
}
