
/**
 *
 * @author Vlad Andrei-Alexandru
 */
public abstract class Subscriptie {
    private String name;
    private int nrGet;  //counter for lfu

    /**
     *
     */
    public Subscriptie(){
        
    }
    
    /**
     *
     * @param name
     */
    public Subscriptie(String name){
        this.name = name;
        nrGet=0;
    }
    
    /**
     *
     * @return
     */
    public String getName(){
        return this.name;
    }
    
    /**
     *
     * @return
     */
    public abstract String getType();

    //Calculate the subscription and returns the newly created object

    /**
     *
     * @param name
     * @param basic
     * @param premium
     * @return
     */
    public static Subscriptie createSubscriptie(String name, int basic, int premium){
        Subscriptie object = null;
        if(premium > 0){
            object = new Premium(name, basic, premium);
        }else if(basic > 0){
            object = new Basic(name, basic);
        }else{
            object = new Free(name);
        }
        
        return object;
    }

    /**
     *
     * @return
     */
    public int getNrGet() {
        return nrGet;
    }

    /**
     *
     * @param nrGet
     */
    public void setNrGet(int nrGet) {
        this.nrGet = nrGet;
    }

    //Increments the number of accessings of the object (for lfu)

    /**
     *
     */
    public void plus(){
        this.nrGet++;
    }

    //The consume function for basic and premium

    /**
     *
     */
    public abstract void use();
    
}
