
/**
 *
 * @author Vlad Andrei-Alexandru
 */
public interface Cache {
    
    /**
     *
     * @param object
     */
    public abstract void add(Subscriptie object);

    /**
     *
     */
    public abstract void remove();

    /**
     *
     * @param name
     * @return
     */
    public boolean contains(String name);

    /**
     *
     * @param name
     */
    public void remove(String name);

    /**
     *
     * @param objName
     * @return
     */
    public Subscriptie get(String objName);
    
}
