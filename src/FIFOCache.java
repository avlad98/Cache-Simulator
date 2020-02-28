
/**
 *
 * @author Vlad Andrei-Alexandru
 */
public class FIFOCache implements Cache{
    private Subscriptie[] cache = null;
    private int size = 0;
    private int used = 0;

    /**
     *
     * @param cacheSize
     */
    public FIFOCache(int cacheSize) {
        cache = new Subscriptie[cacheSize];
        this.size = cacheSize;
        this.used = 0;
    }

    /**
     *
     * @param object
     */
    @Override
    public void add(Subscriptie object) {
        if(this.contains(object.getName()))
        {
            //If it contains don't add it
            return;
        }else if(this.used == this.size){
            //Aply the rule for deleting the object
            remove();
        }
        
        cache[this.used] = object;
        this.used++;
    }

    /**
     *
     */
    @Override
    public void remove() {
        //If the cache is empty, nothing is to be done
        if(this.used == 0){
            return;
        }

        //Shift the elements a position to the left
        for(int i = 1; i < this.used; i++){
            cache[i-1] = cache[i];
        }
        cache[this.used - 1] = null;
        this.used--;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    //Check if an object exists in the cache
    public boolean contains(String name) {
        boolean contains = false;
        for(int i = 0; i < this.used; i++){
            Subscriptie object = cache[i];
            if(object.getName().equals(name)){
                contains = true;
                break;
            }
        }
        
        return contains;
    }

    /**
     *
     * @param name
     */
    @Override
    //Remove a specific object from the cache based on its name
    public void remove(String name) {
        if(this.used == 0){
            return;
        }
        
        int i = 0;
        for(; i < this.used; i++){
            Subscriptie object = cache[i];
            if(object.getName().equals(name)){
                cache[i] = null;
                break;
            }
        }
        
        for(i = i+1; i < this.used; i++){
            cache[i-1] = cache[i];
        }
        
        this.used--;
    }

    /**
     *
     * @param objName
     * @return
     */
    @Override
    //Return the reference of a specific object from the cache
    public Subscriptie get(String objName) {
        Subscriptie object = null;
        for(int i = 0; i < this.used; i++){
            Subscriptie tmp = cache[i];
            if(tmp.getName().equals(objName)){
                object = tmp;
                break;
            }
        }
        return object;
    }
    
}
