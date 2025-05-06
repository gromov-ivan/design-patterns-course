package main.java.prototype.book_reccomendation_system;

import java.util.ArrayList;
import java.util.List;

public class RecommendationRepository {

    private final List<Recommendation> data = new ArrayList<>();

    public void save(Recommendation r) {
        data.add(r);
    }

    public List<Recommendation> all() {
        return data;
    }

    public Recommendation get(int idx) {
        return data.get(idx);
    }
}
