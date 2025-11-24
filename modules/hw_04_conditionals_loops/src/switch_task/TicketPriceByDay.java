package switch_task;

public class TicketPriceByDay {
    public static int TicketPrice(int day) {
        int PriceDay = 300;
        switch (day) {
            case 6:
                PriceDay = 450;
                break;
            case 7:
                PriceDay = 450;
                break;
        }
        return PriceDay;
    }

    public static void main(String[] args) {
        System.out.println(TicketPrice(5) + " рублей");
        System.out.println(TicketPrice(7) + " рублей");
    }
}
