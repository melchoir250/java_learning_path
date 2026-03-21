package chapter_06_oop_principles.bank_gateway;

public class Main {
    public static void main(String[] args) {
        SberbankAPI sberbankAPI = new SberbankAPI();
        TinkoffAPI tinkoffAPI = new TinkoffAPI();
        AlfaBankAPI alfaBankAPI = new AlfaBankAPI();

        PaymentService service = new PaymentService(sberbankAPI);
        service.executePayment(100);
        service.setBank(alfaBankAPI);
        service.executePayment(999);
        service.setBank(tinkoffAPI);
        service.executePayment(1200);
    }
}