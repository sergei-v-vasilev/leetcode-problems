package algorithms.graph.dfs;


import java.util.*;

/**
 * 3387. Maximize Amount After Two Days of Conversions
 */
public class MaximizeAmountAfterTwoDaysOfConversions {

    private static class Currency {
        double amount;
        Map<String, Double> outgoingCurrencies;  //this -> currency, rate
        Map<String, Double> incomingCurrencies;  //this <- currency, rate

        public Currency() {
            this.amount = 0;
            outgoingCurrencies = new HashMap<>();
            incomingCurrencies = new HashMap<>();
        }
    }

    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        //currency conversion graph for the first day
        Map<String, Currency> firstDayGraph = buildGraph(pairs1, rates1);
        if (!firstDayGraph.containsKey(initialCurrency)) {
            firstDayGraph.put(initialCurrency, new Currency());
        }
        Currency initial = firstDayGraph.get(initialCurrency);
        initial.amount = 1;
        dfs(initialCurrency, firstDayGraph);

        //currency conversion graph for the second day
        Map<String, Currency> secondDayGraph = buildGraph(pairs2, rates2);

        //put amounts into currency for the second day
        for (String currency : firstDayGraph.keySet()) {
            Currency first = firstDayGraph.get(currency);
            if (secondDayGraph.containsKey(currency)) {
                Currency second = secondDayGraph.get(currency);
                if (second.amount < first.amount) {
                    second.amount = first.amount;
                    secondDayGraph.put(currency, second);
                }
            }
        }

        for (String currency : firstDayGraph.keySet()) {
            if (secondDayGraph.containsKey(currency)) {
                dfs(currency, secondDayGraph);
            }
        }

        Currency firstDay = firstDayGraph.get(initialCurrency);
        Currency secondDay = secondDayGraph.getOrDefault(initialCurrency, new Currency());
        return Math.max(firstDay.amount, secondDay.amount);
    }

    private Map<String, Currency> buildGraph(List<List<String>> pairs, double[] rates) {
        Map<String, Currency> graph = new HashMap<>();
        for (int i = 0; i < rates.length; i++) {
            String from = pairs.get(i).get(0);
            String to = pairs.get(i).get(1);
            double rate = rates[i];
            Currency fromCurrency = graph.getOrDefault(from, new Currency());
            Currency toCurrency = graph.getOrDefault(to, new Currency());
            fromCurrency.outgoingCurrencies.put(to, rate);
            toCurrency.incomingCurrencies.put(from, 1 / rate);
            graph.put(to, toCurrency);
            graph.put(from, fromCurrency);
        }
        return graph;
    }

    private void dfs(String currency, Map<String, Currency> graph) {
        Currency current = graph.get(currency);
        if (current.outgoingCurrencies.isEmpty() && current.incomingCurrencies.isEmpty()) {
            return;
        }
        //checking outgoing connections
        for (String to : current.outgoingCurrencies.keySet()) {
            double amount = current.amount * current.outgoingCurrencies.get(to);
            Currency nextCurrency = graph.get(to);
            if (amount > nextCurrency.amount) {
                nextCurrency.amount = amount;
                graph.put(to, nextCurrency);
                dfs(to, graph);
            }
        }
        //checking incoming connections
        for (String from : current.incomingCurrencies.keySet()) {
            double amount = current.amount * current.incomingCurrencies.get(from);
            Currency nextCurrency = graph.get(from);
            if (amount > nextCurrency.amount) {
                nextCurrency.amount = amount;
                graph.put(from, nextCurrency);
                dfs(from, graph);
            }
        }
    }

}
