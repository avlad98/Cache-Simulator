import java.util.ArrayList;

/**
 *
 * @author Vlad Andrei-Alexandru
 */
public class LFUCache implements Cache{
    private ArrayList<Subscriptie> cache = new ArrayList();
    private int size = 0;

    /**
     *
     */
    public LFUCache(){
        
    }

    /**
     *
     * @param size
     */
    public LFUCache(int size){
        this.size = size;
    }

    /**
     *
     * @param object
     */
    @Override
    public void add(Subscriptie object) {
        if(this.contains(object.getName())){
            return;
        }else if(cache.size() == this.size){
            //removes the lfu object based on lfu rule
            int index =0 ;
            int min = cache.get(0).getNrGet();
            for(int i=0 ; i<cache.size() ; i++)
                if(cache.get(i).getNrGet() < min){
                    index = i;
                    min = cache.get(i).getNrGet();
                }
            cache.get(index).setNrGet(0);
            cache.remove(index);
        }

        cache.add(object);
    }

    /**
     *
     */
    @Override
    public void remove(){
        
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    //Check if an object exists in the cache
    public boolean contains(String name) {
        for(int i = 0; i < cache.size(); i++){
            if(cache.get(i).getName().equals(name)){
                return true;
            }
        }
        
        return false;
    }

    /**
     *
     * @param name
     */
    @Override
    //Remove a specific object from the cache based on its name
    public void remove(String name) {
        int index = 0;
        for(int i = 0; i < cache.size(); i++){
            if(cache.get(i).getName().equals(name)){
                index = i;
            }
        }
        cache.remove(index);
    }

    /**
     *
     * @param objName
     * @return
     */
    @Override
    //Return the reference of a specific object from the cache
    public Subscriptie get(String objName) {
        for(int i = 0; i < cache.size(); i++){
            if(cache.get(i).getName().equals(objName)){
                return cache.get(i);
            }
        }
        
        return null;
    }

}
