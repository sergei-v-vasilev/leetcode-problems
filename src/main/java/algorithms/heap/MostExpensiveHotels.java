package algorithms.heap;

import java.util.*;

public class MostExpensiveHotels {
    private final int k;
    private final TreeSet<String> kMostExpensiveHotels;
    private final Map<String, Integer> hotelPriceMap;
    private int sumPrice;

    public MostExpensiveHotels(int k) {
        this.k = k;
        this.hotelPriceMap = new HashMap<>(k);
        this.sumPrice = 0;
        this.kMostExpensiveHotels = new TreeSet<>((l, r) -> {
            int lPrice = hotelPriceMap.getOrDefault(l, -1);
            int rPrice = hotelPriceMap.getOrDefault(r, -1);
            if (lPrice == rPrice) return 0;
            else if (lPrice != -1 && rPrice != -1) return rPrice - lPrice;
            else return 1;
        });
    }

    public void addHotel(String hotel, int price) {
        //if there was the same hotel with another price we need to recalculate it
        if (hotelPriceMap.containsKey(hotel)) {
            kMostExpensiveHotels.remove(hotel);
            sumPrice -= hotelPriceMap.get(hotel);
        }
        hotelPriceMap.put(hotel, price);
        sumPrice += price;
        kMostExpensiveHotels.add(hotel);
        //verify the size of the data structure
        if (kMostExpensiveHotels.size() > k) {
            String cheapestHotel = kMostExpensiveHotels.pollLast();
            sumPrice -= hotelPriceMap.get(cheapestHotel);
            hotelPriceMap.remove(cheapestHotel);
        }
    }

    public double averagePrice() {
        return (double) sumPrice / kMostExpensiveHotels.size();
    }

    public List<String> getMostExpensiveHotels() {
        List<String> mostExpensiveHotels = new ArrayList<>(k);
        mostExpensiveHotels.addAll(kMostExpensiveHotels);
        return mostExpensiveHotels;
    }

    public static void main(String[] args) {
        MostExpensiveHotels system = new MostExpensiveHotels(2);
        system.addHotel("Grand Budapest", 500);
        System.out.println(system.getMostExpensiveHotels()); //(Grand Budapest)
        System.out.println(system.averagePrice());
        system.addHotel("Overlook Hotel", 1);
        system.addHotel("Modest Budapest", 270);
        System.out.println(system.getMostExpensiveHotels()); //(Grand Budapest, Modest Budapest)
        System.out.println(system.averagePrice());
        system.addHotel("Overlook Hotel", 280);
        System.out.println(system.getMostExpensiveHotels()); //(Grand Budapest, Overlook Hotel)
        System.out.println(system.averagePrice());
        system.addHotel("Royal Budapest", 10001);
        System.out.println(system.getMostExpensiveHotels()); //(Royal Budapest, Grand Budapest)
        System.out.println(system.averagePrice());
    }
}
