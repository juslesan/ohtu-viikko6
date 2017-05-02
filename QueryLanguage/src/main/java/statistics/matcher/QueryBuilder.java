package statistics.matcher;

/**
 *
 * @author eekuurne
 */
public class QueryBuilder {
    
    Matcher matcher;

    public QueryBuilder() {
        this.matcher = new And();
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcher = new Or(m1, m2);
        return this;
    }
    
    public void reset() {
        this.matcher = new And();
    }

    public Matcher build(){
        return matcher;
    }
}
